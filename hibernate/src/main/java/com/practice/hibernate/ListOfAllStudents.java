package com.practice.hibernate;

import java.util.List;

import com.practice.entity.StudentEntity;

public  class ListOfAllStudents {

	public static void displayAllStudent(List<StudentEntity> studentEntity)
	{
		int count=0;
		for(StudentEntity student : studentEntity)
		{
			System.out.println(student);
			count++;
		}
		System.out.println("TOtal Students are : "+ count);
	}

}
