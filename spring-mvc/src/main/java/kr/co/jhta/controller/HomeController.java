package kr.co.jhta.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	/*
	 *	"/home.do" url ��û�� ���� ����Ǵ� ��û�ڵ鷯�޼ҵ� ����
	 *
	 *	- "/home.do" ril ��û�� �����Ǹ� home()�� ����ȴ�
	 *	- home()�� ��ȯ�ϴ� ���ڿ��� �̵��� JSP�������� �̸��̵ȴ�.
	 *	- spring mvc �����ӿ�ũ�� ��û�ڵ鷯 �޼ҵ尡 ��ȯ�ϴ� ���ڿ��� jsp �̸����� �����ϰ� �ش� jsp �������� ��û�� �̵���Ų��
	 *  - ��û�� ���� jsp�� ���� ����� ������ HTML��þ�ٰ� �������� �����Ѵ�.
	 *  
	 * */
	@RequestMapping(value="/home.do")
	public String home(Model model) {
		// ������ String�� ��� �̵��� JSP �̸��� ��������Ѵ�.
		
		model.addAttribute("message", "Ȩ�������� ���� ����Ǿ����ϴ�.");
		
		List<String> rankings = Arrays.asList("����ġ����", "��ȿ��", "�̿�", "������", "���ֳ�����");
		model.addAttribute("rankings", rankings);
		
		return "main";
	}
	
	@RequestMapping(value = "/about.do")
	public String about() {
		return "about";
	}
}
