package spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class ServiceProvider implements CarService{

	@Override
	public void getCarService() {
	System.out.println("Car Service...............");
		
	}           

}
