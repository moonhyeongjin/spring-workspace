package com.sample.di.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SampleApp {

	public static void main(String[] args) {
		String resource = "classpath:/com/sample/di/demo3/sample.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		SampleController controller = ctx.getBean("sampleController", SampleController.class);
		
		controller.add("hong", "zxcv1234");
	}
}
