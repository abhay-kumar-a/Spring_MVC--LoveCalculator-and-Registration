package spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class BmwCarService implements CarService {

	@Override
	public void getCarService() {
		// TODO Auto-generated method stub
		System.out.println("BMW:  only for service");
		
	}

}
