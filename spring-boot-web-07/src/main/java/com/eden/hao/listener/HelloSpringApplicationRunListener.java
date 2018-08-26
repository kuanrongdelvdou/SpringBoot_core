package com.eden.hao.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {
	
	 //必须有的构造器
    public HelloSpringApplicationRunListener(SpringApplication application, String[] args){

    }

	@Override
	public void starting() {
		System.out.println("SpringApplicationRunListener .... 的 starting() 方法开始运行了");
	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		System.out.println("SpringApplicationRunListener .... 的准备环境方法开始运行了 environmentPrepared(), 里面还传入了配置环境:" + environment);
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		System.out.println("SpringApplicationRunListener ... 的 IOC 容器准备好了的方法 contextPrepared() 运行了, 里面传入了 IOC 容器对象: " + context);
	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {

		System.out.println("SpringApplicationRunListener ... 的 IOC 的容器开始加载的方法  contextLoaded() 运行了, 里面还传入了 IOC 容器对象: " + context);
	}

	@Override
	public void started(ConfigurableApplicationContext context) {
		System.out.println("SpringApplicationRunListener ... 的 IOC 容器的开始运行方法 started() 运行了....");
	}

	@Override
	public void running(ConfigurableApplicationContext context) {
		System.out.println("SpringApplicationRunListener ... 的 IOC 容器正在运行的方法 runnting() 运行了....");
	}

	@Override
	public void failed(ConfigurableApplicationContext context, Throwable exception) {
		System.out.println("SpringApplicationRunListener .... 的 IOC 容器运行失败的方法 failed() 运行了....");
	}

}
