package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.TestLogin;
import com.example.demo.service.TestLoginService;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/10 下午9:23
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@RestController
public class TestController {

   @Autowired
   private TestLoginService testLoginService;


   @RequestMapping("query")
   public TestLogin queryById(){

       return testLoginService.queryById();
   }

   @RequestMapping("update")
   public TestLogin update(){

      return testLoginService.updateById();
   }


   @RequestMapping("del")
   public int del(){

      return testLoginService.delById();
   }

}
