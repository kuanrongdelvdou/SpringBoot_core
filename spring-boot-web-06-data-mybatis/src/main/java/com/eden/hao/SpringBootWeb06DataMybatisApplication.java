package com.eden.hao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.eden.hao.mapper")
@SpringBootApplication
public class SpringBootWeb06DataMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWeb06DataMybatisApplication.class, args);
	}
}
