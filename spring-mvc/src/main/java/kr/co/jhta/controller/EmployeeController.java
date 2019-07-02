package kr.co.jhta.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.form.EmployeeForm;


@Controller
// 클레스위에 맵핑을 적어주면 메소드위에 생략가능
@RequestMapping("/employee")

public class EmployeeController {

	@RequestMapping(value ="/main.do")
	public String main(Model model) {
		//최근에 가입된 사원정보 조회
		// 조회된 정보를 모델에 담아서 view 페이지에 전달
		
		
		//views 밑에 기준으로 jsp 경로 적어줭
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
		emp.put("name", "홍길동");
		emp.put("dept", "영업1팀");
		
		
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
		//폼 입력값을 담을수있는 클레스를 생성 (인풋박스 네임과 같은 변수명을 가져야함)
		// 폼입력값 받는 전용 객체로 정의한놈이 EmployeeForm 이라는 클레스임
		//  getparameter해서 알아서 넣어줌
		return "redirect:main.do";
	}
}
