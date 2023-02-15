package com.love_calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImp implements LCAppEmailService{

	
	@Autowired
	private JavaMailSender javaMailSender;  // this object is help full to send email..
	@Override
	public void  sendEmail(String userName, String email, String result) {
		// TODO Auto-generated method stub
		
		try
		{
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			
			simpleMailMessage.setTo(email);
			simpleMailMessage.setSubject("Love Calculator Application Prediction result : ");
			simpleMailMessage.setText("Hii " + userName + "\nThe result pridicted by the Love Calculator App is :  \n" + result);
			
			javaMailSender.send(simpleMailMessage);
		}
		catch (Exception e) {
			String message = e.getMessage();		
		System.out.println(message);
		
   }
 }
}
