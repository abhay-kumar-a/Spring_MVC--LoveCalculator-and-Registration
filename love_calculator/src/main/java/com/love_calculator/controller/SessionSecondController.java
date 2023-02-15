package com.love_calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class SessionSecondController {
	
	@GetMapping("/newMethod")
	public String method(Model model , @SessionAttribute("firstName") String firstName , @SessionAttribute("lastName") String lastName)
	{
		System.out.println("I am inside normal method of second SessionController");
//		String firstName1 = (String)model.getAttribute("firstName");
//		String lastName = (String)model.getAttribute("lastName");
		
		model.addAttribute("firstName", "Mr."+firstName);
		model.addAttribute("lastName", lastName);
		System.out.println(firstName);
		System.out.println(lastName);
		
		return "session";
	}

}
