package com.practice.jdbc_driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDriver {
	public static void main(String[] args) {
		
		String urlString = "jdbc:postgresql://localhost:5432/hibernate_practice";
		String userName = "postgres";
		String passwordString = "AbhayPassword";
		
		try {
			System.out.println("connection check fro data base"+ urlString);
			Connection connection  = DriverManager.getConnection(urlString , userName,passwordString);
			System.out.println("Connection Seccessfull");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
