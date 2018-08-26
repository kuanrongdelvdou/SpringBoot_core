package com.eden.hao.mapper;

import com.eden.hao.bean.Employee;

// 使用 Mapper 或者 @MapperScan 将接口扫描装配到容器中
public interface EmployeeMapper {
	
	public Employee getEmpById(Integer id);
	
	public void insertEmp(Employee emp);
}
