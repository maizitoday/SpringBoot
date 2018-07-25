package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TransactionManagerService;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/25 下午1:59
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@RestController
public class TransactionManagerController {

    @Autowired
    private TransactionManagerService  transactionManagerService;

    @RequestMapping("updateData")
    public void  updateData(){
        transactionManagerService.updateData();
    }

}
