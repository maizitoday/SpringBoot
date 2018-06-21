package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/11 下午9:46
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@RestController
public class Test2Controller {

    @RequestMapping("login")
    public String login(String id)
    {
        return "login";
    }
}
