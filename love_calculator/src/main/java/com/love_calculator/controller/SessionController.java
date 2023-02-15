package com.love_calculator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"firstName","lastName"})  // here both my firstName and last name is persisted with session...    // first request scope will come , the session scope , 
public class SessionController {
	
	
	@GetMapping("/first")
	public String first(Model model,HttpServletRequest request)
	{
		model.addAttribute("firstName","Abhay");
		model.addAttribute("lastName","Kumar");
		model.addAttribute("url", "second");
		
		
		HttpSession session = request.getSession();
		session.setAttribute("Location", "Lucknow");  // this is session 
		
		return "session";
	}
	
	@GetMapping("/second")
	public String second(Model model ,SessionStatus status , HttpSession session )
	{

		
		System.out.println("I am from second Handler method");
		String firstName = (String) model.getAttribute("firstName");
		String lastName =   (String)model.getAttribute("lastName");
		
		
		System.out.println(firstName);
		System.out.println(lastName);
		
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("url","third");
	//	status.setComplete();  ///  Mark the current handler's session processing as complete , means Conversational scope will dropped.. session object is no more available on server.
	
	//session.invalidate(); //this is used to remove session object from server which is created by HttpSession..
		
		return "session";
	}
	@GetMapping("/third")
	public String third(Model model)
	{
		System.out.println(" i am from third handler");
		
		model.addAttribute("url","newMethod");
		return "session";
	}

}
