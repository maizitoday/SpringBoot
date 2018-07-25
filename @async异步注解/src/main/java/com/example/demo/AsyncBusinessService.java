package com.example.demo;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
/**
 * @author yubo
 * @version V2.0
 * @Description:    这个异步和调用的需要在不同的类。不然不起作用。
 * @date 2018/7/12 下午3:46
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Service
public class AsyncBusinessService {

	@Async
	public Future<String> task1() throws InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();
		Thread.sleep(1000);
		long currentTimeMillis1 = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName()+": task1任务耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms");
		return new AsyncResult<String>("task1执行完毕");
	}

	@Async
	public Future<String> task2() throws InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();
		Thread.sleep(2000);
		long currentTimeMillis1 = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName()+": task2任务耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms");
        return new AsyncResult<String>("task2执行完毕");
	}

	@Async
	public Future<String> task3() throws InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();
		Thread.sleep(3000);
		long currentTimeMillis1 = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName()+": task3任务耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms");
        return new AsyncResult<String>("task3执行完毕");
	}
}
