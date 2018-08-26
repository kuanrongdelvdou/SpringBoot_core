package com.eden.hao.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@ResponseBody
	@RequestMapping("/query")
	public Map<String, Object> getAllDept(){
		System.out.println(".....................eeeeeeeeeeeeeeeeeeeeeeeeeeeeee...............");
		List<Map<String,Object>> queryForList = jdbcTemplate.queryForList("select * from department");
		
		return queryForList.get(0);
	}

}
