package com.practice.spring.core;

public class CricketCoach implements Coach{

	/**
	 *
	 */
	@Override
	public void dailyWork() {
		System.out.println("this is from cricket coach");
		
	}
	//setter injection
	String email;
	int number;
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public int getNumber() {
		return number;
	}
	

}
