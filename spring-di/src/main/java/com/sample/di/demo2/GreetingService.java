package com.sample.di.demo2;

public class GreetingService {

	private KoreanGreeting ko; 
	private EnglishGreeting en;
	
	public String message(String name) {
		String message = ko.message(name);
		return  message;
	}

	
	public void setEn(EnglishGreeting en) {
		this.en = en;
	}


	public void setKo(KoreanGreeting ko) {
		this.ko = ko;
	}
	
	public String hello(String name) {
		String message = ko.message(name);
		
		return message;
	}
	
	public String bye() {
		String message = en.goodbye();
		return message;
	}
}
