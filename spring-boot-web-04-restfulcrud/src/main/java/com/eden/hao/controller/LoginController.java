package com.eden.hao.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@PostMapping("/login")
	public String login(@RequestParam("username") String username, 
						@RequestParam("password") String password,
						Map<String, String> map,
						HttpSession session){
		
		if(!"1".equals(password.trim())){
			
			// 登录失败
			map.put("errMsg", "密码错误");
			return "login.html";
		}else{
			
			// 登录成功, 将登录的 user 信息放入 Session 中, 在拦截器中进行判断, 
			//如果 Session 中有登录信息那么说明页面是从登录页面跳转过来的, 而不是直接访问 main.html
			session.setAttribute("loginUser", username);
			
			// 登录成功, 放防止表单重复提交, 可以重定向到主页
			return "redirect:/main.html";
		}
	}
}
