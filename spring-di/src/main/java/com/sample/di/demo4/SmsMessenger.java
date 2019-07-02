package com.sample.di.demo4;

public class SmsMessenger implements Messenger{

	public void sendMessage(String to, String text) {
		System.out.println("SMS 단문 메세지 보내기");
		System.out.println("받는사람 번호 : " + to);
		System.out.println("메세지내용 : " + text);
	}
	
	public String receiveMessage() {
		System.out.println("SMS 단문 메세지 받기");
		return "안녕하세요";
	}
}
