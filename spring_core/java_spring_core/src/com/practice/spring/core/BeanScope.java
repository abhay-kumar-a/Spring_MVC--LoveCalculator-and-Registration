package com.practice.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScope {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("bean-scope_application_properties.xml");
		// check bean life cycle......................;
		Coach c= context.getBean("myCoach",Coach.class);
		
		System.out.print("\nThis is Bean Checkup\n");
		
		context.close();
		
		
	}
}
