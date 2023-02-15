package annotation.noxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class AudiCar implements Car{
	//implement service dependency
	
	@Autowired
	@Qualifier("audiCarService")
	Service  service;
	@Value("${foo.name}")
	private String name;
	@Value("${foo.age}")
	private String age;
	
    public Service getService() {
		return service;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("car stated");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Car Stop");
		
	}
	
	public void  getAudiCarService()
	{
		service.getService();
	}

}
