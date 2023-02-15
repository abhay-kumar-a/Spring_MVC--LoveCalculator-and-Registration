package spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaAnnotation {
 public static void main(String[] args)
 {
	 System.out.println("Hello Abhay");
	 ApplicationContext context = new ClassPathXmlApplicationContext("annotaion_base_properties.xml");
	 Car c = context.getBean("audi",Car.class);
	 c.start();
	 c.engine();
	 c.stop();
	 c.engine();          
	 Audi a = context.getBean("audi",Audi.class);
	 // constructor injection work over Here....
	 a.getCarservice(); // 
	 System.out.println(a.getCarService()); 
	// a.carService.getCarService();// both result are same;
	 
	 // setter Injection
	 

	 
 }
}
