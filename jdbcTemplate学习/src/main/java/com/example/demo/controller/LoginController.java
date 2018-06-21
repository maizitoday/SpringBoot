package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Login;
import com.example.demo.service.LoginService;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/15 下午3:04
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("login")
    public List<Login> findAll(){
        List<Login> loginList = loginService.getLoginAll();
        return loginList;
    }
}
