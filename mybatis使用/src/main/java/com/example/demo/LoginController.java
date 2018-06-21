package com.example.demo;

import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Login;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/16 下午9:39
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Log4j2
@RestController
public class LoginController {

    @Autowired
    private  LoginService  loginService;

    /**
     * 打印sql
     * @return
     */
    @RequestMapping("login")
    public List<Login> login(){
        log.info("LoginController-sql");
       return   loginService.findAll();
    }

    @RequestMapping("annotationLogin")
    public List<Login> annotationLogin(){
        return   loginService.findAnnotationAll();
    }


    @RequestMapping("insert")
    public String insert(){
        boolean flag = false;
        try {
            flag = loginService.insert();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag)
        {
            return "插入成功";
        }else{
            return "插入失败";
        }

    }
}
