package com.eden.hao;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		
		//传入SpringBoot应用的主程序
		return application.sources(SpringBootWeb04JspApplication.class);
	}

}
