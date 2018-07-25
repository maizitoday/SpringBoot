package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/25 上午10:11
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@RestController
public class LoginController {

    @ApiOperation(value="用户列表", notes="登录用户列表")
    @RequestMapping(value = "loginList", method = RequestMethod.POST)
    public List<User> getUserList () {
        List<User> userList = new ArrayList<>();
        for(int i = 0 ; i<5;i++)
        {
            User user = new User();
            user.setId(i);
            user.setAge(i*2);
            user.setUsername("登录"+i+"-");
            userList.add(user);
        }
        return userList;
    }


}
