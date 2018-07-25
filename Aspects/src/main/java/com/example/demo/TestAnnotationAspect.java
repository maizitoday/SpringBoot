package com.example.demo;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author yubo
 * @version V2.0
 * @Description:  拦截有自动注解
 * @date 2018/6/21 上午10:55
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Aspect // FOR AOP
@Order(0) // 控制多个Aspect的执行顺序，越小越先执行
@Component
@Log4j2
public class TestAnnotationAspect {

    private long currentTime;

    /***
     * 注解形式处理AOP
     * @param point
     * @param timeExpend
     * @throws Throwable
     */

    @Before("@annotation(timeExpend)")
    public void beforeTest(JoinPoint point, TimeExpend timeExpend) throws Throwable {
        currentTime = System.currentTimeMillis();
        log.info("timeExpend 方式执行前: "+System.currentTimeMillis());
    }

    @After("@annotation(timeExpend)")
    public void afterTest(JoinPoint point, TimeExpend timeExpend) {
        currentTime = System.currentTimeMillis() - currentTime;
        log.info("timeExpend 方法执行后: "+currentTime/1000+"秒");
    }
}
