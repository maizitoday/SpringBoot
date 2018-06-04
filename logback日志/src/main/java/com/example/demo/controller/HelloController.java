package com.example.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/5/30 下午5:20
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@RestController
@Log4j2
public class HelloController {

    @RequestMapping("showLog")
    public String showLog(){
        log.info("写入沙发发日志");
        return "showLog";
    }

}
