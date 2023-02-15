package com.registration.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AgeValidater.class)
public @interface Age {

	int lower() default 18;
	int upper() default 60;
	
	//"Please enter message between {lower} to {upper}";  // dynamically getting value of upper and lower // i will enter value
	                                                                               //of l and u as 20 and 50 , so  it will override my current values instead of default values
	
	String message() default "{validaterMessage}";// validaterMessage is the key of properties file.  
	                                             // i want to get this key value from property .. so ,i will load my property file in COnfiguration class Using 
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
