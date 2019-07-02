package com.sample.di.demo8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	public void login(String id , String pwd) {
		String dbPassword = userDao.getpasswordById(id);
		System.out.println("���Խ� ��й�ȣ : " + dbPassword);
		
		if(pwd.equals(dbPassword)) {
			System.out.println("��й�ȣ�� ��ġ�մϴ�.");
		} else {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	}
}
