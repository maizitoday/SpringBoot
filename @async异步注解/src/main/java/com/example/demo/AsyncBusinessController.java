package com.example.demo;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/12 下午3:48
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@RestController
public class AsyncBusinessController {

    @Autowired
    private AsyncBusinessService  asyncBusinessService;

    @RequestMapping("asyncAction")
    public String async() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Future<String> task1 = asyncBusinessService.task1();
        Future<String> task2 = asyncBusinessService.task2();
        Future<String> task3 = asyncBusinessService.task3();
        String result = null;
        while (true){
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        result = "task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";
        result = Thread.currentThread().getName()+": --- "+result;
        System.out.println(result);
        return result;
    }


}
