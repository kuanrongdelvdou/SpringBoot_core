package com.eden.hao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**登录检查*/
public class LoginHandlerInterceptor implements HandlerInterceptor{
	
	/*// 目标方法执之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 从 Session 中获取登录用户信息
		Object user = request.getSession().getAttribute("loginUser");
		
		if(null != user){
			
			// user 不为空, 证明已经登录了, 放行请求;
			return true;
		}else{
			
			// user 为空, 证明未登录, 返回登录页面, 并且将错误信息放入 request 请求域中
			request.setAttribute("errMsg", "您还没有登录!请先登录!");
			
			request.getRequestDispatcher("/").forward(request, response);
			return false;
		}
	}*/

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
}
