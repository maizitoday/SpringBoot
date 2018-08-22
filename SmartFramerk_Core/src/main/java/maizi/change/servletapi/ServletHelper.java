package maizi.change.servletapi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/20 下午3:56
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class ServletHelper {


    private static ThreadLocal<ServletHelper> SERVLET_HELPER_HOLDER = new ThreadLocal<ServletHelper>();

    private HttpServletRequest  request;
    private HttpServletResponse response;

    private ServletHelper(HttpServletRequest  request,HttpServletResponse response)
    {
         this.request = request;
         this.response = response;
    }

    /***
     * 初始化，request 和 response ,保证每一个线程有一个独立备份。 都是当前线程
     * @param request
     * @param response
     */
    public static void init(HttpServletRequest  request,HttpServletResponse response)
    {
        SERVLET_HELPER_HOLDER.set(new ServletHelper(request,response));
    }



}
