package com.sample.di.demo8;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	public void deleteAllUSers() {
		System.out.println("��� ����� ����");
	}
	
	public String getpasswordById(String id) {
		System.out.println("��й�ȣ ��ȸ");
		return "zxcv1234";
	}
}
