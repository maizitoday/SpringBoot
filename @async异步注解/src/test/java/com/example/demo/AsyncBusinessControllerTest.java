package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/13 上午10:18
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@EnableAsync
public class AsyncBusinessControllerTest {

    @Autowired
    private AsyncBusinessService  asyncBusinessService;

    @Test
    public void async() throws Exception {

    }

}