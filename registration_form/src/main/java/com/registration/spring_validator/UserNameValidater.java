package com.registration.spring_validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.registration.dto_api.UserDTO;

public class UserNameValidater implements Validator{

	// check if user Validation support a given object means clazz object
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		System.out.println(" inside support method of validation");
		System.out.println(UserDTO.class.equals(clazz));
		return UserDTO.class.equals(clazz);
	}
	
	
// here we need to write our custom validation logics
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("inside validate method of validator");
		// TODO Auto-generated method stub
		
		/// here i will define our logics..
		
		//to check if the fiield is null          // error , fieldName of dto , key name or errorcode, message to show on page"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName","username.empty","user can not be empty");
		
		// the string should contains hyfen (-)  .
		               String userName = ((UserDTO)target).getUserName();
		               if(!userName.contains("-"))
		               {
		            	   errors.rejectValue("userName","userName.envalidString","String must contains '-' ");
		               }
		
	}
	// then register this custom validator in Init binder
	// binder.addValidion (new UserNameValidater);

}
