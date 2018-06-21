package com.example.demo.controller;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/13 下午7:49
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Service
@Log4j2
public class MyService {

    public void handler(){
        log.info("开始处理业务----进行一些初始化的数据， 同时所有的bean都已经实例化了");

    }


}
