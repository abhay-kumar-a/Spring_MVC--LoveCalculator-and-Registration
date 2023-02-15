package com.practice.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.entity.StudentEntity;

public class ReadHibernateDemo {
	
	public static void main(String[] args) {

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
			int id = 10;
			System.out.println("persist the student from data base with id " + id);
			StudentEntity student = session.get(StudentEntity.class, id); // it take class name and id ....
			System.out.println(student);

			// get all student.... using Hibernate Query...
			System.out.println("\n All Student persist using Hibernate Query \n");

			/// this is called Hibernate Query Language (HQL)
			String queryString = "from StudentEntity";
			List<StudentEntity> resultList = session.createQuery(queryString).getResultList();

			// print all student
			ListOfAllStudents.displayAllStudent(resultList);

			/// Hiberrnate query language

			String getByName = "from StudentEntity  s where s.firstName = 'Abhay'"; // here s is like alias..
			List<StudentEntity> student1 = session.createQuery(getByName).getResultList();
			System.out.println("\n Display all student s which start with 'Abhay' \n");
			ListOfAllStudents.displayAllStudent(student1);
			
			// Querying using or operator ...
			System.out.println("\n display all student with name Abhay and Praneet");
			String getStudent = "from StudentEntity s where s.firstName='Abhay' OR s.firstName='Praneet'";
			ListOfAllStudents.displayAllStudent(session.createQuery(getStudent).getResultList());
			
			
			// Querying using Like  % operator
			System.out.println("\n display student using like operator");
			String likeQuery = "from StudentEntity where lastName LIKE '%wal'";
			ListOfAllStudents.displayAllStudent(session.createQuery(likeQuery).getResultList());
			
			// close the transaction

			session.getTransaction().commit();

			/// close session
			session.close();

		} finally {
			factory.close();
		}

	}

}
