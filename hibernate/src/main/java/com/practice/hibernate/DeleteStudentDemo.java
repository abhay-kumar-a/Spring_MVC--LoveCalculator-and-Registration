package com.practice.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.entity.StudentEntity;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		System.out.println("get startd with hibernate configuration");
		Configuration configuration = new Configuration();
		configuration.configure("/com/practice/hibernate/hibernate.cfg.xml");
		configuration.addAnnotatedClass(StudentEntity.class);
		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// start transaction
			System.out.println("transaction started");
			session.beginTransaction();

			// read data from database using session;
			// get single student with the help of id....

			// update student object id =10 ;
			System.out.println("update student in database with id 10");
			int id = 10;
			/// first get data from dataBase
			StudentEntity student = session.get(StudentEntity.class, id); // it take class name and id ....
			System.out.println(student);

			// delete the student object from database
			
			System.out.println("\n all student before detele");
			
			ListOfAllStudents.displayAllStudent(session.createQuery("from StudentEntity").getResultList());
			
//			int id1 = 12;
//
//			// first get the student from data base by id
//			StudentEntity studentEntity = session.get(StudentEntity.class, id1);
//			// delete this studentEntity object
//			session.delete(studentEntity);
//            System.out.println("\n all student after detele student of id "+ id1);
//			
//			ListOfAllStudents.displayAllStudent(session.createQuery("from StudentEntity").getResultList());
//			
			
			// delete operation using HQL
			session.createQuery("delete from StudentEntity where id= 22").executeUpdate();
			System.out.println("\n all student after delete student of id 22 using HQL");
			ListOfAllStudents.displayAllStudent(session.createQuery("from StudentEntity").getResultList());
			
			// close the transaction
			session.getTransaction().commit();

			/// close session
			session.close();

		} finally {
			factory.close();
		}

	}

}
