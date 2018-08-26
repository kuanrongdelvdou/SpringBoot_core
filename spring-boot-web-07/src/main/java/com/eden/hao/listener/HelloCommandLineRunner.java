package com.eden.hao.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner ... 的 run() 方法开始运行了, 传入了参数 args 是 : " + args);
	}

}
