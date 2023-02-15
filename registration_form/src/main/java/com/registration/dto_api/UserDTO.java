package com.registration.dto_api;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.registration.annotations.Age;

public class UserDTO {
	
	@Size(min=3 , max=50)
	@NotEmpty(message="{name.empty}")
	String name;
	
	String userName;
	String password;
	String country;
	String[] hobby;

	String gender;
	
   @Age(lower=25, upper=100)
	private Integer age;
	
	private CommunicationDTO communication;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public CommunicationDTO getCommunication() {
		return communication;
	}
	public void setCommunication(CommunicationDTO communication) {
		this.communication = communication;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

}
