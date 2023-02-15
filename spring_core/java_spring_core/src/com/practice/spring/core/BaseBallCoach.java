package com.practice.spring.core;

public class BaseBallCoach  implements Coach{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
		
		HappyFortune happy  = new HappyFortune();
		happy.getFortuneServiceDetails();
		FortuneService h =new HappyFortune();
		h.getFortuneServiceDetails();
		
		happy.Hello();
		
		
		
	}
	public void startup_init()
	{
		new HappyFortune().Hello();
	}
	public void cleanup_destroy() {
		new HappyFortune().getFortuneServiceDetails();
	}

	@Override
	public void dailyWork() {
		System.out.println("I am from Base ball Coach");
		
	}
	

	
  
}
