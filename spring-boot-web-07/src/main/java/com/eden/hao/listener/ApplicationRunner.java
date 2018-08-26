package com.eden.hao.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;


@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("ApplicationRunner ... 的 run() 方法开始运行了, 传入的参数 args 是 :"  + args.toString());
	}

}
