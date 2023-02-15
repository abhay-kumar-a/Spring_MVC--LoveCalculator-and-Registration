package com.registration.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidater implements ConstraintValidator<Age, Integer>{

	int lower;
	int upper;
	@Override
	public void initialize(Age age) {
		// TODO Auto-generated method stub
		System.out.println("I am inside  initializer() method of AgeValidater class");
	this.lower=age.lower();
	this.upper=age.upper();
	}
	@Override
	public boolean isValid(Integer age_value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		System.out.println("I am inside  isVali() method of AgeValidater class");

		// here i will write my logic..
		if(age_value == null)
		{
			return false;
		}
		if(age_value<lower || age_value>upper)
		{
			return false;
		}
		return true;
	}

}
