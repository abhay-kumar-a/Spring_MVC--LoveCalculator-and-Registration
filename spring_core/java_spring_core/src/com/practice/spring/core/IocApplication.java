package com.practice.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocApplication {
	public static void main(String[] arg)
	{
		ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("application_properties.xml");
		  Coach c = context1.getBean("myCoach",Coach.class);
		  Coach c2 = context1.getBean("myCoach",Coach.class);
		  System.out.println(c.hashCode()==c2.hashCode());
		  c.dailyWork();
		  FortuneService happy = context1.getBean("fortune",FortuneService.class);
		  happy.getFortuneServiceDetails();
		 BaseBallCoach b = new  BaseBallCoach();
//		 System.out.println("Your name is  "+ b.b+" and age is  "+b.a);
		  
		  
		  
		  CricketCoach c1 = context1.getBean("CricketCoach",CricketCoach.class);
		  c1.dailyWork();
//		  CricketCoach c3 = new CricketCoach();
		  System.out.println(c1.getEmail() + c1.getNumber());
		  context1.close();
		  
	}
}
