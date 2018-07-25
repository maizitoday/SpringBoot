package com.example.demo;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/21 上午10:51
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
//@Aspect // FOR AOP
//@Order(-99) // 控制多个Aspect的执行顺序，越小越先执行
//@Component
@Log4j2
public class TestAspect {

    private long currentTime;

    /***
     *  确定方法进行AOP处理
     */
    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    public void webLog(){
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        currentTime = System.currentTimeMillis();
        log.info("方式执行前: "+System.currentTimeMillis());
    }

    @After("webLog()")
    public void doAfter(JoinPoint joinPoint){
        currentTime = System.currentTimeMillis() - currentTime;
        log.info("方法执行后: "+currentTime/1000+"秒");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        log.info("方法返回值：" + ret);

    }
}
