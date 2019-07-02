package kr.co.jhta.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.jhta.vo.Department;
import kr.co.jhta.vo.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private SqlMapClientTemplate template;
	
	public List<Employee> getAllEmpByDeptId(int id){
		return template.queryForList("getAllEmpById", id);
		
	}
	
	public Employee getEmpById(int id) {
		return (Employee) template.queryForObject("getEmpById", id);
	}
	
	public void insertEmp(Employee employee) {
		template.insert("insertEmp", employee);
	}
}
