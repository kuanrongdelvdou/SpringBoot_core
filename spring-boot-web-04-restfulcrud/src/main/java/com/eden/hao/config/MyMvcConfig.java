package com.eden.hao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import component.MyLocalResolver;

/**使用 WebMvcConfigurer 可以来扩展 SpringMVC 的功能*/
@Configuration
//@EnableWebMvc
public class MyMvcConfig  implements WebMvcConfigurer{

	// 需要扩展什么功能那么就重写 WebMvcConfigurer 中相对应的方法
	
	// 我们来定义自己的视图控制器
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		// 将 "/edenHao" 映射到 success.html 页面 
		// 效果: 浏览器发送 /edenHao 请求来到 success 页面
		registry.addViewController("/edenhao").setViewName("success.html");
		
		registry.addViewController("/").setViewName("login.html");
		
		registry.addViewController("/login.html").setViewName("login.html");
		
		registry.addViewController("/main.html").setViewName("dashboard.html");
	}
	
	// 所有的 WebMvcConfigurer 组件都会一起起作用
	@Bean // 将组件注册在容器中(加入到容器中)  
	public WebMvcConfigurer myWebMvcConfigurer(){
		
		WebMvcConfigurer myExtensionConfig = new WebMvcConfigurer() {
			
			
			// 注册拦截器
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				
				// Spring Boot 1.xxx 已经做好了静态资源的映射, 所以我们的拦截器无需考虑会将所有的静态资源也拦截了
				// 经过测试发现 Spring Boot 2.xxx 会对静态资源进行拦截, 所以要把 /static/** 排除掉!!!
//				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//																	  .excludePathPatterns("/", "/login.html","/login","/static/**","/resources/**");
			}
		};
		return myExtensionConfig;
	}// 这个方法同下面的方法是一样的(不同的写法)
	
	/*
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
		  												      .excludePathPatterns("/", "/login.html","/login",);
	}*/
	
	@Bean
	public LocaleResolver localResolver(){
		return new MyLocalResolver();
	}
}
