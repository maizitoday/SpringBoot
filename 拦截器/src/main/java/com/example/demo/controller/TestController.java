package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/12 下午10:06
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@RestController
public class TestController {

    @RequestMapping("login")
    public String login(String id){
        return "login";
    }

}
