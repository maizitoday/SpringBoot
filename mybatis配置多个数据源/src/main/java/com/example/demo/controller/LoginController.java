package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Sys;
import com.example.demo.pojo.User;
import com.example.demo.service.LoginService;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/19 下午4:39
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("user")
    public List<User> user(){
        return loginService.findUserAll();
    }

    @RequestMapping("sys")
    public List<Sys> sys(){
        return loginService.findSysAll();
    }

}
