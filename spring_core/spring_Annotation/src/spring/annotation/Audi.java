package spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("audi")
@Scope("singleton")
public class Audi implements Car {
	
	// field injection using Autowired;
	@Autowired
	@Qualifier("bmwCarService") 
	CarService carService;
	
 // constructor injection using Autowired
//	@Autowired
//	Audi(CarService carService)
//	{
//		this.carService = carService;
//	}
	
    
    
	// Setter injection using Autowired..
	
	public CarService getCarService() {
		return carService;
	}
//	@Autowired
//	public void setCarService(CarService carService) {
//		this.carService = carService;
//	}
	
	
	
	// init method and destroy method in xml configuration
	// but in annotation for bean lifeCycle we have @PostConstruct and @PreDestroyed annotation;
	
	
	@PreDestroy
	public void beanStop()
	{
		System.out.println("Bean destroyed or stop");
	}
	@PostConstruct
	public void beanSrart()
	{
		System.out.println("Bean initialized or start");
	}
	
	
public void getCarservice()
	{
		carService.getCarService();
	}
	@Override
	public void start() {
		System.out.println("Audi car start");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method 
System.out.println("Audi car Stop");
		
	}

	@Override
	public void engine() {
		// TODO Auto-generated method stub
		System.out.println("Audi car Engine.......");
	}

}
