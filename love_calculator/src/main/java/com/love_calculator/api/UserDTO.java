package com.love_calculator.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO {
	
	// form validation using JSR..
	@NotBlank(message="Field can not be blank..")
	//@Min(message="please enter at least 3 character..", value = 2)
	@Size(min=3,max=15,message="please enter name between 3 to 15 character.")
	private String userName;
	
	@NotBlank(message="Field can not be blank..")
	@Size(min=3,max=15,message="please enter name between 3 to 15 character.")
	private String crushName;
	
	@AssertTrue(message="please agree terms and conditons")
	private boolean agree;
	
	private String email;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
