package com.eden.hao.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class HelloController {

	@RequestMapping("/toSuccess")
	public String toSuccessPage(){
		System.out.println("大家好呀");
		
		return "success";
	}
}
