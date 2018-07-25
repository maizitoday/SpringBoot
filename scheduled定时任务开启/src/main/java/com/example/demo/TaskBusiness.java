package com.example.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/12 下午2:44
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Component
@Log4j2
public class TaskBusiness {

    @Scheduled(fixedDelay=3000)
    public void doSomethingA() {
        log.info(Thread.currentThread().getName()+": 等上次执行完成后3秒开始执行");
    }

    @Scheduled(fixedRate=3000)
    public void doSomethingB() {
        log.info(Thread.currentThread().getName()+": 从开始执行进行计算时间，从这个时间点开始计算");
    }

//    @Scheduled(initialDelay=1000, fixedRate=3000)
//    public void doSomething() {
//        log.info(Thread.currentThread().getName()+": 延迟一秒， 从开始执行进行计算时间，从这个时间点开始计算");
//    }

    // 复杂的用core来进行处理
}
