package kr.co.jhta.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.form.EmployeeForm;


@Controller
// Ŭ�������� ������ �����ָ� �޼ҵ����� ��������
@RequestMapping("/employee")

public class EmployeeController {

	@RequestMapping(value ="/main.do")
	public String main(Model model) {
		//�ֱٿ� ���Ե� ������� ��ȸ
		// ��ȸ�� ������ �𵨿� ��Ƽ� view �������� ����
		
		
		//views �ؿ� �������� jsp ��� ����a
		return "emp/main";
		
	}
	
	@RequestMapping(value ="/detail.do")
	public String detail(String id, int pno, Model model) {
		System.out.println(id);
		System.out.println(pno);
		
		// EmployeeDao dao = new EmployeeDao();
		// Employee emp = dao.getEmployeeById(id);
		// model.addAttribute("employee" , emp);
		
		HashMap<String, Object> emp = new HashMap<String, Object>();
		emp.put("id", id);
		emp.put("name", "ȫ�浿");
		emp.put("dept", "����1��");
		
		
		model.addAttribute("employee", emp);
		
		return "emp/detail";
	}
	
	@RequestMapping(value = "/registerform.do")
	public String registerform() {
		return "emp/form";
	}
	@RequestMapping(value = "/register.do")
	public String register(EmployeeForm emp) {
		System.out.println(emp);
		//�� �Է°��� �������ִ� Ŭ������ ���� (��ǲ�ڽ� ���Ӱ� ���� �������� ��������)
		// ���Է°� �޴� ���� ��ü�� �����ѳ��� EmployeeForm �̶�� Ŭ������
		//  getparameter�ؼ� �˾Ƽ� �־���
		return "redirect:main.do";
	}
}
