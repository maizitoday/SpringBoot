package com.example.demo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author yubo
 * @version V2.0
 * @Description:   并行方式, 如果没有并行的话，系统中所有的任务都是在同一个线程中执行。 添加并行后，会在不同的线程中执行处理。
 * @date 2018/7/12 下午2:56
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Configuration
public class ScheduledConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(setTaskExecutors());
    }

    @Bean(destroyMethod="shutdown")
    public Executor setTaskExecutors(){
        return Executors.newScheduledThreadPool(2); // 3个线程来处理。
    }
}

