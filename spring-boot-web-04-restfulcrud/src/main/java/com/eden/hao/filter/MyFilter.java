package com.eden.hao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{

	// Filter 的销毁
	@Override
	public void destroy() {
		
	}

	// Filter 的过滤请求, 对请求做处理
	@Override
	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain)
			throws IOException, ServletException {
		
		// 打印一句话
		System.out.println("我的 Filter 执行了.....");
		
		// 放行请求
		chain.doFilter(req, rep);
	}
	
	// Filter 初始化
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
