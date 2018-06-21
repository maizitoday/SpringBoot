package com.example.demo.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/13 下午7:47
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Component
@WebListener
@Log4j2
public class MyServletContextListener implements ServletContextListener {

    @Autowired
    MyService myService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("  服务开始启动 ----在这里可以做很多初始化工作  ");

        myService.handler();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("  服务已经停止   ");
    }
}
