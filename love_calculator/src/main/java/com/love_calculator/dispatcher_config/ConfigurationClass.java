package com.love_calculator.dispatcher_config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.love_calculator")
@PropertySource("classpath:email.properties")
public class ConfigurationClass {
	
	@Autowired
	private Environment env;
	 
	//enabling view Resolver...
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	// configuring the G_mail provider
	@Bean
    public  JavaMailSender getJavaMailSender()
    {
		JavaMailSenderImpl mail = new JavaMailSenderImpl();
		
		mail.setHost(env.getProperty("mail.host"));  // configuring gmail provider
		mail.setUsername(env.getProperty("mail.userName"));
		mail.setPassword(env.getProperty("mail.password"));
		mail.setPort( Integer.parseInt(env.getProperty("mail.port")));
		
		
		// gmail is to much secure to adding some other properties
		
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);  // 
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mailProperties.put("mail.smtp.starttls.required", "true");
		mailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		mail.setJavaMailProperties(mailProperties);
		
		return mail;
		
  }
}
