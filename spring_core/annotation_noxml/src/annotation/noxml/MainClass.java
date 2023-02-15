package annotation.noxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
public static void main(String[] a)
{
	ApplicationContext context =new AnnotationConfigApplicationContext(AllCars.class);
	
	System.out.println("Inside main method");
	 AudiCar c = context.getBean("AudiCar",AudiCar.class);
	 System.out.println("inside audi car main method");
	 c.start();
	 c.stop(); 
	 c.getAudiCarService();
	// accessing field property
	 System.out.println(c.getName() + " "+ c.getAge());
	 c.getAge();

//	 Service s = context.getBean("getService",Service.class);
//	 s.getService();
	
System.out.println("Hello World");

}

}
