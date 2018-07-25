package com.example.demo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import com.example.demo.TimeExpend;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/21 上午11:49
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Service
@Log4j2
public class LoginService {

    @TimeExpend
    public  void  loginBusiness(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("loginBusiness");
    }

}
