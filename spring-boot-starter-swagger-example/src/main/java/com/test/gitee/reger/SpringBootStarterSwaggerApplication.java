package com.test.gitee.reger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.test.gitee.controller")
public class SpringBootStarterSwaggerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootStarterSwaggerApplication.class, args);
	}

}
