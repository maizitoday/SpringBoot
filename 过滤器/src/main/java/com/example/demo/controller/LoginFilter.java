package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/11 下午9:26
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */





/****
 *    过滤器：  容器启动的时候就进行了初始化， @Component 这个保证了过滤器的可用。  @Order 这个用来判断过滤器的级别
 *
 *    容器销毁的时候，就进行了销毁。  他用于过滤所有的访问的请求。    拦截器相当于一个AOP类似。
 *
 */
@Component
@WebFilter(urlPatterns = "/*")
@Order(value = 1)
public class LoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         System.out.println("   过滤器 初始化   LoginFilter ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        String id = (String) servletRequest.getParameter("id");
        System.out.println("   id  "+id);

        String path = httpServletRequest.getRequestURL().toString();
        if (path.contains("login"))
        {
            // 上面直接拦截
            System.out.println(" LoginFilter 具体业务类处理   拦截login请求 ");
            // 此处可以做拦截的业务处理或者转发到不同的页面中。
        }else{
            // 这个继续放行，
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

        System.out.println("  过滤器  销毁了   LoginFilter  ");
    }
}
