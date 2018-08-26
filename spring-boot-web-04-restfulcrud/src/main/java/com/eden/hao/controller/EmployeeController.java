package com.eden.hao.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.eden.hao.dao.DepartmentDao;
import com.eden.hao.dao.EmployeeDao;
import com.eden.hao.entities.Department;
import com.eden.hao.entities.Employee;

@Controller
public class EmployeeController {
	
	// 将 employeeDao 自动装配进来!
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	DepartmentDao departmentDao;
	
	// 查询所有的员工返回到列表页面(list.html)
	@GetMapping("/emps")
	public String list(Model model){
		
		// 查询所有的员工
		Collection<Employee> emps = employeeDao.getAll();
		
		// Model, ModelMap, Map 都可以将数据放入到请求域中! 我么这里使用 Model (三种哪一种都可以)
		// 将查询到的员工放入到请求域中
		model.addAttribute("emps", emps);
		
		// 跳转到 emp 文件加下的 list.html 页面
		return "emp/list.html";
	}
	
	/**跳转到员工添加页面*/
	@GetMapping("/emp")
	public String toAddPage(Model model){
		
		// 跳转到页面之前需要查询出所有的部门在页面显示
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts", departments);
		
		// 来到添加页面
		return "emp/add.html";
	}
	
	/**员工添加功能*/
	// Spring MVC 自动将请求参数和入参对象 emp 的属性进行一一绑定
	// 要想将请求参数和入参对象emp 的属性进行绑定的要求是: 请求参数的名字和 javaBean 入参的对象里面的属性名是一样的!
	@PostMapping("/emp") 
	public String addEmp(Employee emp){
		
		System.out.println("添加的员工信息是: " + emp );
		
		// 保存员工
		employeeDao.save(emp);
		
		// 当员工添加完成以后, 我们应该来到员工列表页面, 来到员工列表页面两种方式
		// 一: redirect:表示重定向到一个地址
		// 二: 表示转发到一个地址
		//说明: / ---> 表示当前项目路径; 重定向可以重定向到任何路径!!!!		
		return "redirect:/emps";
	}
	
	/**来到修改页面, 查出当前员工, 在页面显示*/
	@GetMapping("/emp/{id}")
	public String toEditPage(@PathVariable("id") Integer id, Model model){
		
		System.out.println("我进入了修改页面的 controller 了SSSS");
		
		// 查询从页面传过来的 id 的员工
		Employee employee = employeeDao.get(id);
		
		// 页面要显示所有的部门列表
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts", departments);
		
		
		// 由于查出来的员工还要在页面回显还需要放在 Model 中
		model.addAttribute("emp", employee);
		
		// 会到修改页面两种方式:
		// 一: 将 add.html 页面复制一份作为修改页面
		// 二: 重用 add.html 页面(修改和添加的页面是二合一的页面)
		return "emp/add";
	}
	
	
	/**修改操作*/
	@PutMapping("/emp")  // 这是一个 put 请求
	public String updateEmp(Employee employee){
		
		System.out.println("修改的员工数据: " + employee);
		
		// 修改员工数据
		employeeDao.save(employee);
		
		// 修改成功以后还是来到 list.thml 页面
		return "redirect:/emps";
	}
	
	/**删除操作*/
	@DeleteMapping("/emp/{id}")
	public String deleteEmp(@PathVariable("id") Integer id){
		
		employeeDao.delete(id);
		
		// 删除成功后重新重定向到
		return "redirect:/emps";
	}
	
}
