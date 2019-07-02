package kr.co.jhta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.dao.DepartmentDao;
import kr.co.jhta.dao.EmployeeDao;
import kr.co.jhta.vo.Department;

@Controller
@RequestMapping("/emp")
public class EmployeeController2 {
	

	@Autowired
	private EmployeeDao employeeDao; 
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping("/dept.do")
	public String depts(Model model) {
		
		List<Department> depts = departmentDao.getAllDept();
		
		model.addAttribute("depts", depts);
		
		return "emp/depts";
	}
}
