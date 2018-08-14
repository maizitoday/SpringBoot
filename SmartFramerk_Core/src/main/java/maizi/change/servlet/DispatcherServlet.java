package maizi.change.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maizi.change.ioc.BeanHelper;
import maizi.change.ioc.ConfigHelper;
import maizi.change.ioc.ControllerHelper;
import maizi.change.ioc.Handler;
import maizi.change.ioc.HelperLoader;
import maizi.change.ioc.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/8 下午9:19
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet{

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("init");
        HelperLoader.init();
        ServletContext servletContext = config.getServletContext();
        //注册处理JSP的servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath()+"*");

        //注册处理静态资源默认的servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath()+"*");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("service");
        // 获取请求方法和请求路径
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();

        // 获取Action处理器
        Handler  handler = ControllerHelper.getHandler(requestMethod,requestPath);
        if (handler != null)
        {
            // 获取Controller类及其Bean实例
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);

            //创建请求参数对象
            Map<String,Object> paramMap = new HashMap<String, Object>();
            Enumeration<String> paramNames = req.getParameterNames();

            while (paramNames.hasMoreElements())
            {
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName, paramValue);
            }
            String body = decodeURL(getString(req.getInputStream()));
            if (body != null)
            {
                String[] params = body.split("&");
                if (params != null)
                {
                    for (String param : params)
                    {
                        String[] array = param.split("=");
                        if (array != null && array.length == 2)
                        {
                            String paramName = array[0];
                            String paramValue = array[1];
                            paramMap.put(paramName, paramValue);
                        }
                    }
                }
            }
            //调用Action方法
            Method  actionMethod = handler.getActionMethod();
            Object result = null;
            if (paramMap != null)
            {
                Object[]  objs = new Object[paramMap.size()];
                int count = 0;
                for (Object obj : paramMap.keySet())
                {
                    objs[count] = paramMap.get(obj);
                    count++;
                }
                result = ReflectionUtil.invokeMethod(controllerBean,actionMethod,objs);
            }else{
                result = ReflectionUtil.invokeMethod(controllerBean,actionMethod);
            }

            if (result instanceof View)
            {
                View view = (View)result;
                String path = view.getPath();
                if (path != null)
                {
                    if (path.startsWith("/"))
                    {
                        resp.sendRedirect(req.getContextPath()+path);
                    }else{
                        Map<String,Object> model = view.getModel();
                        for (Map.Entry<String,Object>entry : model.entrySet())
                        {
                            req.setAttribute(entry.getKey(),entry.getValue());
                        }
                        req.getRequestDispatcher(ConfigHelper.getAppJspPath()+path).forward(req,resp);
                    }
                }
            }else if(result instanceof  Data)
            {
                Data data = (Data)result;
                Object model = data.getModel();
                if (model != null)
                {
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter writer = resp.getWriter();
                    String json = toJson(model);
                    writer.write(json);
                    writer.flush();
                    writer.close();
                }
            }
        }
    }

    /***
     * 从输入流中获取字符串
     * @param is
     * @return
     */
    public static  String getString(InputStream is)
    {
        StringBuilder  sb = new StringBuilder();
        try {
            BufferedReader  reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line);
            }
        }catch (Exception e){
           e.printStackTrace();
        }
        return  sb.toString();
    }

    /***
     * 将URL编码
     * @param source
     * @return
     */
    public static String encodeURL(String source)
    {
        String target = null;
        try {
           target = URLEncoder.encode(source,"UTF-8");
        }catch (Exception e){
           e.printStackTrace();
        }
        return target;
    }

    /***
     * 将URL解码
     * @param source
     * @return
     */
    public static String  decodeURL(String source)
    {
        String target = null;
        try {
           target = URLDecoder.decode(source,"UTF-8");
        }catch (Exception e){
           e.printStackTrace();
        }
        return target;
    }


    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    /***
     *
     * 将POJO转为JSON
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJson(T obj)
    {
        String json = null;
        try {
           json = OBJECT_MAPPER.writeValueAsString(obj);
        }catch (Exception e){
           e.printStackTrace();
        }
        return json;
    }

    /***
     * 将JSON转为POJO
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T formJson(String json,Class<T> type)
    {
        T pojo = null;
        try {
              pojo = OBJECT_MAPPER.readValue(json,type);
        }catch (Exception e){
           e.printStackTrace();
        }
        return pojo;
    }


}
