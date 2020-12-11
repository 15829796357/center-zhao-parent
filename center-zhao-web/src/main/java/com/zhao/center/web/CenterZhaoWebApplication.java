package com.zhao.center.web;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zhao.center")
@EnableDubbo
public class CenterZhaoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CenterZhaoWebApplication.class, args);
		System.out.println("*************");
		System.out.println("*************");
		System.out.println("*****启动完成*****");
		System.out.println("*************");
		System.out.println("*************");
	}

}
