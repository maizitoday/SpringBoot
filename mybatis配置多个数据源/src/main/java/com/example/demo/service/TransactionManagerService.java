package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.master.UserDao;
import com.example.demo.dao.slave.SysDao;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/25 下午2:03
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Service
public class TransactionManagerService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SysDao sysDao;

//  @Transactional(value = "masterTransactionManager",rollbackFor = Exception.class)

    @Transactional(rollbackFor = Exception.class)
    public void  updateData(){
        userDao.updateAll();
        sysDao.updateAll();
        String message = null;
        message.split("#");
    }
}
