package com.sample.di.demo5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demo5App {

	public static void main(String[] args) {
		
		String resource = "classpath:/com/sample/di/demo5/demo5.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		UserService u1 = ctx.getBean("userService", UserService.class);
		
		u1.addNewUser("ȫ�浿", "hong", "zxcv1234");
	}
}
