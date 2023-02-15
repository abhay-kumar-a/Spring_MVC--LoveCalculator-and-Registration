package com.registration.spring_validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.registration.dto_api.UserDTO;

public class EmailCustomValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"communication.email","email.empty","{email.empty}");
		  String email = ((UserDTO)target).getCommunication().getEmail();
		  
		  if(!email.endsWith("@gmail.com")) {
			  errors.rejectValue("communication.email","email.invalid","{email.invalid}");
		  }
		
	}

}
