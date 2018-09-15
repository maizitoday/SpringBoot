package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan({"com.example.demo.dao"})
@ServletComponentScan
@EnableTransactionManagement
public class DemoApplication {

public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
}
}
