package com.eden.hao;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import component.MyLocalResolver;

@SpringBootApplication
public class SpringBootWeb04RestfulcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWeb04RestfulcrudApplication.class, args);
	}
	
	
	/**
	 *在主配置类中定义我们自己的视图解析器
	 * 
	 */
	@Bean
	public ViewResolver myViewResolver(){
		
		return new MyViewResolver();
	}
	
	private static class MyViewResolver implements ViewResolver{

		@Override
		public View resolveViewName(String viewName, Locale locale) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
