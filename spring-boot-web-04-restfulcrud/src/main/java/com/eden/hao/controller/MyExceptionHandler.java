package com.eden.hao.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import exception.UserNotExistException;

/**
 * 在 SpringMVC 中要想称为一个异常处理器, 必须使用 @ControllerAdvice 来标注(这都是 SpirngMVC 的旧知识)
 */
@ControllerAdvice
public class MyExceptionHandler {

	/*
	 * // handleException 这个方法要处理那个异常呢? 需要用 // @ExceptionHandler 来指定需要处理的异常 //
	 * 只要发生异常 SpringMVC 就会调用我们定义的异常处理器中的 hadnleException 方法, 并且将 // 异常对象 e 传进来
	 * 
	 * @ResponseBody // 由于我们需要返回一个 Json 数据, 我们需要加一个 @ReponseBody 注解!
	 * 
	 * @ExceptionHandler(UserNotExistException.class) public Map<String, Object>
	 * handleException(Exception e){
	 * 
	 * // 定制我们自己的错误响应信息, 只要定义一个 map 将我们定制的错误信息放入 map 就好 Map<String, Object> map
	 * = new HashMap<>();
	 * 
	 * // 定制我们自己的错误状态码 map.put("code", "user.notExist");
	 * 
	 * // 放入我们自己的异常消息 map.put("message", e.getMessage());
	 * 
	 * return map; }
	 */

	@ExceptionHandler(UserNotExistException.class)
	public String handleException(Exception e, HttpServletRequest request) {

		Map<String, Object> map = new HashMap<>();
		
		// 传入我们自己的错误状态码 4xx、 5xx 等, 否则就不会进入定制错误页面的解析流程
		/*
		 * Integer statusCode = (Integer) request
		 *		.getAttribute("javax.servlet.error.status_code");
		 */
		request.setAttribute("javax.servlet.error.status_code", 500);

		// 定制我们自己的错误状态码
		map.put("code", "user.notExist");

		// 放入我们自己的异常消息
		map.put("message", "郝伟是你大爷");
		
		request.setAttribute("ext", map);
		
		
		// 原来是将信息返回, 现在是转发到 /errer 请求! --> BaseErrorController 
		//会进行自适应处理(有返回错误页面, 也有返回 Json 数据)
		return "forward:/error";
	}

}
