package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
/***annotationLogin
 * 这个地方必须开启扫描，不然无法实例化这个bean文件， 也就是dao的文件
 */
@MapperScan({"com.example.demo.dao","com.example.demo.annotation"})
@ServletComponentScan
@EnableTransactionManagement
@ImportResource(locations = { "classpath:druid-bean.xml" })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
