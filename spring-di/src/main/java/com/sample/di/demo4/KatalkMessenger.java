package com.sample.di.demo4;

public class KatalkMessenger implements Messenger{

	public String receiveMessage() {
		System.out.println("ī������ �޼��� �����ϱ�");
		return "���� : �ݰ�����";
	}
	
	public void sendMessage(String to, String text) {
		System.out.println("ī������ �޼��� ������");
		System.out.println("�޴� ��� : " + to);
		System.out.println("�޼��� ���� : " + text);
	}
}
