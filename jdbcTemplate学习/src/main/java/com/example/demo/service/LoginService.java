package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Login;
import com.example.demo.dao.LoginDao;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/15 下午2:57
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public List<Login> getLoginAll(){
        List<Login> loginList = loginDao.queryAll();
        return loginList;
    }

}
