package spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class AudiCarService implements CarService{

	@Override
	public void getCarService() {
		// TODO Auto-generated method stub
	 System.out.println("Audi: only for service");
		
	}

}
