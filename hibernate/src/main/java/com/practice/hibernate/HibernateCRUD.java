package com.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.entity.StudentEntity;


public class HibernateCRUD {
public static void main(String[] args) {
	System.out.println("get startd with hibernate configuration");
	
	//configuring xml file using `SessionFactory
	
	Configuration configuration = new Configuration();
	configuration.configure("/com/practice/hibernate/hibernate.cfg.xml");
	
	configuration.addAnnotatedClass(StudentEntity.class);
	//SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentEntity.class).buildSessionFactory();
	
	SessionFactory factory = configuration.buildSessionFactory();
	
	
	// get session using sessionFactory;
	
	Session session = factory.getCurrentSession();
	
	try {
		// create object of student
		System.out.println("Creating object of Student");
		
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setFirstName("Abhay");
		studentEntity.setLastName("kumar");
		studentEntity.setEmail("abhay.kumar@gmail.com");
		
		//start transaction
		System.out.println("start transaction");
		session.beginTransaction();
		
		//save student object;
		
		System.out.println("save student object");
		session.save(studentEntity);
		session.save( new StudentEntity("Ankit" , "kumar" ,"ankit@gmail..com"));
		session.save(new StudentEntity("Praneet" ,"Kanaka","praneet@Wgmail.com"));
		
		// commit the transaction;
		
		System.out.println("commit the transaction");
		session.getTransaction().commit();
		
		System.out.println("successfully save");
	} 
	finally{
		factory.close();
		
	}
	
	
}
}
