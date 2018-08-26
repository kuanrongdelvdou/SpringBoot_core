package com.eden.hao.myServerConfig;

import java.util.Arrays;
import java.util.EventListener;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eden.hao.filter.MyFilter;
import com.eden.hao.listener.MyListener;
import com.eden.hao.servlet.MyServlet;

// 首先这是一个配置类
@Configuration
public class MyServerConfig {

	// 注册三大组件
	// 1.注册 Servlet
	@Bean // 将返回值添加到容器中
	public ServletRegistrationBean<MyServlet> myServletConf(){
		
		// 我们自定义的 MyServlet() 就只映射 /myServlet 请求(只对 /myServlet 请求做处理)
		ServletRegistrationBean<MyServlet> servletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
		
		return servletRegistrationBean;
	}
	
	// 2.注册 Filter
	@Bean // 将返回值添加到容器中
	public FilterRegistrationBean<MyFilter> myFilterConf(){
		
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
		
		registrationBean.setFilter(new MyFilter());
		
		// 指定拦截的请求
		registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
		
		return registrationBean;
	}
	
	// 3.注册 Listener
	@Bean // 将返回值添加到容器中
	public ServletListenerRegistrationBean<MyListener> myListenerConf(){
		
		ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
		
		return servletListenerRegistrationBean;
	}	
	
}
