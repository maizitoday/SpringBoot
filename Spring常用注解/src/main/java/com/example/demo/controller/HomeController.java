package com.example.demo.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/4 下午6:18
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Controller
public class HomeController
{
    @PostConstruct
    public void init(){
        System.out.println("  init---HomeController ");
    }


    @RequestMapping("/home")
    public void home() throws Exception{
        int number = 0;
        try {
            number = 1/0;
        }catch (Exception e){
            throw  new RuntimeException("运行时候异常");
        }
        System.out.println("   number  "+number);
    }
}
