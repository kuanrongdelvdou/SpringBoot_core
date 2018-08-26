package com.eden.hao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eden.hao.bean.Department;
import com.eden.hao.bean.Employee;
import com.eden.hao.mapper.DepartmentMapper;
import com.eden.hao.mapper.EmployeeMapper;

@RestController
public class DeptController {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@GetMapping("/dept/{id}")
	public Department getDepartment(@PathVariable("id") Integer id){
		
		System.out.println("-------------------------------------" + departmentMapper == null);
		
		return departmentMapper.getDeptById(id);
	}
	
	@GetMapping("/dept")
	public Department insertDept(Department dept){
		departmentMapper.insertDept(dept);
		
		return dept;
	}
	
	@RequestMapping("/hello")
	public String hello(){
		
		return "天天抖开心";
	}
	
	@GetMapping("/emp/{id}")
	public Employee getEmp(@PathVariable("id") Integer id){
		
		return employeeMapper.getEmpById(id);
	}
}
