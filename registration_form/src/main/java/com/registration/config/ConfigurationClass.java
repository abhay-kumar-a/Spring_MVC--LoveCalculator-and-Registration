package com.registration.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.registration.converter.CreditCardConverter;
import com.registration.converter.CreditCardConverterObjToStr;
import com.registration.formatter.CreditCardFormatter;
import com.registration.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.registration.controller")
public class ConfigurationClass implements WebMvcConfigurer{
	
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	
	// this bean is responsible for load the property file
	
	@Bean
	MessageSource messageSource()
	{
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("message");  // give name of property file message ,that is set as base name ...
		return source;
	}
	
	// after this messageSource bean will be validate by..  Validator() bean type of LocalValidatorFactoryBean
	
	@Bean
	LocalValidatorFactoryBean validator()
	{
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		factory.setValidationMessageSource(messageSource());
		return factory;
	}
	
	// i have to tell to spring MVC hey please validate this validator() bean, this is WebMvcConfigure interface default method which is going to validate my getValidator()	
	
	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return validator();
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addFormatters(registry); // instead of doing i will pass my formatter Object
		System.out.println("I am inside the addFormatters()");
		registry.addFormatter(new PhoneNumberFormatter());
		//registry.addFormatter(new CreditCardFormatter());
		
		
		// register Credit card Converter
		registry.addConverter(new CreditCardConverter());
		registry.addConverter(new CreditCardConverterObjToStr());
	}

	
}
