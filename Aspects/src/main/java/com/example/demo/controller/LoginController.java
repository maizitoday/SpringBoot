package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LoginService;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/21 上午10:48
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService  loginService;

    @RequestMapping("login")
    public String login(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginService.loginBusiness();
        return "login";
    }

}
