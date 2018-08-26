package com.eden.hao.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class HelloApplicationContextIniterized implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {

		System.out.println("ApplicationContextInitializer ... 的  initialize() 方法运行了, 还给我们传入了 applicationContext 容器 :" + applicationContext );
	}

}
