package com.zhao.center.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.zhao.center")
@EnableDubbo
@MapperScan("com.zhao.center.provider.mapper")
public class CenterZhaoProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CenterZhaoProviderApplication.class, args);
		System.out.println("*************");
		System.out.println("*************");
		System.out.println("*****启动完成*****");
		System.out.println("*************");
		System.out.println("*************");
	}

}
