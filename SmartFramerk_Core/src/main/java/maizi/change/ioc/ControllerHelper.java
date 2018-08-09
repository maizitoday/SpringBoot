package maizi.change.ioc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yubo
 * @version V2.0
 * @Description:  控制器助手类
 * @date 2018/8/8 下午8:38
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public final class ControllerHelper {

    /***
     * 用于存放请求于处理器的映射关系
     */
    private static final Map<Request,Handler> ACTION_MAP = new HashMap<Request,Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (controllerClassSet != null)
        {
            for (Class<?> controllerClass : controllerClassSet)
            {
                Method[] methods = controllerClass.getDeclaredMethods();
                if (methods != null)
                {
                    for (Method method : methods)
                    {
                        if (method.isAnnotationPresent(Action.class))
                        {
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            if (mapping.matches("\\w+:/\\w*"))
                            {
                                String[] array = mapping.split(":");
                                if (array != null && array.length == 2)
                                {
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod,requestPath);
                                    Handler handler = new Handler(controllerClass,method);
                                    ACTION_MAP.put(request,handler);
                                }
                            }

                        }
                    }
                }
            }
        }
    }


    /***
     * 获取handler
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Handler getHandler(String requestMethod,String requestPath)
    {
       Request  request = new Request(requestMethod,requestPath);
       return ACTION_MAP.get(request);


    }


}
