package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.master.UserDao;
import com.example.demo.dao.slave.SysDao;
import com.example.demo.pojo.Sys;
import com.example.demo.pojo.User;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/19 下午4:01
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SysDao sysDao;


    public List<User> findUserAll(){
        return userDao.findUserAll();
    }

    public List<Sys> findSysAll(){
        return sysDao.findSysAll();
    }


}
