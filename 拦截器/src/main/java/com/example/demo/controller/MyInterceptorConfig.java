package com.example.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/12 下午10:05
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */

/***
 *   拦截器更多的是处理controller层， 同时他的生命周期不是根据这个web容器来进行初始化的， 生命周期是根据Controller来进行处理的。
 *   过滤器的创建都是在web容器初始化的时候就进行了，同时销毁的时候也是根据容器销毁了就销毁了。他是依托于servlet来进行的。
 *
 *   拦截器的话更加的方便， 同时控制的方向主要在于Controller层的前后处理
 *
 */
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurerAdapter {

    /***
     * addPathPatterns：需要拦截的访问路径
     * excludePathPatterns：不需要拦截的路径，String数组类型可以写多个用","分割
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ChanelInterceptor()).addPathPatterns("/**");
    }
}
