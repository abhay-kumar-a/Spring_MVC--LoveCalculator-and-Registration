package com.practice.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.practice.entity.StudentEntity;

public class UpdateStudentDemo {

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

			// now i have student of id 10 ;

			// update firstName and last name ...
			student.setFirstName("Gulshion");
			student.setLastName("Jaishwal");
		//	session.update(student); // update the student object
			
			// the student object which retrieve from database is basically the persistence object ,so without using session.update , student will automatically update..

			System.out.println("\n After update of student obejct of id : " + id);
			System.out.println(session.get(StudentEntity.class, id));
			
			// with help of HQL , update the data
			int id1=11;
			System.out.println("\n update student with help of HQL .. of id : " + id1);
			
			 session.createQuery("update StudentEntity s set s.firstName ='Dainal' where s.id=11").executeUpdate();
			
			
			
			// all student before update the email...
			ListOfAllStudents.displayAllStudent(session.createQuery("from StudentEntity").getResultList());
			
			String updateQuery = "update StudentEntity s set s.email='hello@gmail.com'";
			session.createQuery(updateQuery).executeUpdate();
			
			System.out.println("\n after updateAll Student ");
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
