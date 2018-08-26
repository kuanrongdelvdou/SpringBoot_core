package com.eden.hao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

	// 关闭web 应用后 ServletContext 也就销毁了
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed ... 当前web 应用销毁了!!");
	}
	
	// ServletContext 对象的初始化, 也就代表 web 应用启动了
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized ... web 应用启动了!!");
	}

}
