package com.sample.di.demo7;

public class EmailService {

	private String host;
	private int port;
	private String userId;
	private String userPwd;
	

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public void connect() {
		System.out.println("���� ���� ����");
		System.out.println("ȣ��Ʈ : " + host);
		System.out.println("��Ʈ��ȣ : " +port);
		System.out.println("���̵� : " + userId);
		System.out.println("��й�ȣ : " + userPwd);
	}
	
}
