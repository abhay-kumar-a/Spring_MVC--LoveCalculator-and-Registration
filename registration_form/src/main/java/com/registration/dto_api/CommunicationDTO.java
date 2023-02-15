package com.registration.dto_api;

import com.registration.reference_entity.Phone;

public class CommunicationDTO {
	private String email;
	private Phone phone;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	

}
