package annotation.noxml;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:car.properties")
public class AllCars{

	@Bean
	Car AudiCar()
	{
		return new AudiCar();
	}
	
	@Bean 
	@Qualifier("audiCarService")
	Service getService()
	{
		return new AudiCarService();
	}
	@Bean 
	Service getService1()
	{
		return new ServiceProvider();
	}
}
