package com.demo.model;

public class Student {
	String firstName;
	String lastName;
	String country;
	String favoriteLanguage;
	String[] operationSystem;

	public String[] getOperationSystem() {
		return operationSystem;
	}

	public void setOperationSystem(String[] operationSystem) {
		this.operationSystem = operationSystem;
	}

	public String getCountry() {
		return country;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
