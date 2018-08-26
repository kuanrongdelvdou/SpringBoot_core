package com.eden.hao.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import exception.UserNotExistException;

@Controller
public class HelloController {
	
	
	
//	@RequestMapping("/")
//	public String index(){
//		
//		return "index";
//	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(@RequestParam("user") String user){
		
		if("aaa".equals(user)){
			throw new UserNotExistException();
		}
		
		return "Hello World";
	}
	
	@RequestMapping("/success")
	public String success(Map<String, Object> map){
		
		// 默认放到请求域中
		map.put("hello", "<h1>郝伟<h1>");
		
		map.put("users", Arrays.asList("haowei", "edenHao", "绿豆"));
		
		//classpath:/templates/success.html
		return "success";
	}
}
