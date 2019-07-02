package com.sample.di.demo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo4App {

	public static void main(String[] args) {
		String resource = "classpath:/com/sample/di/demo4/demo4.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		EventNoticeService s1 = ctx.getBean("eventNoticeService", EventNoticeService.class);
		OrderService s2 = ctx.getBean("orderService", OrderService.class);
		
		s1.notice("제주도 여행 상품권 당촘");
		s2.sendOrderStatus();
		
	}
}
