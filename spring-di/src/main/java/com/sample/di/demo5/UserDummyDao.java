package com.sample.di.demo5;

public class UserDummyDao implements UserDao{
	
	
	public void insertUser(String name, String id, String password) {
			System.out.println("[신규가입]");
			System.out.println("이름 : " + name + "아이디 : "+ id + "비밀번호 : " + password );
	}
	
}
