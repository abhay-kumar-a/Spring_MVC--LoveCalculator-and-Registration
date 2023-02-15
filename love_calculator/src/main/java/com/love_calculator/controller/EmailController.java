package com.love_calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.love_calculator.api.EmailDTO;
import com.love_calculator.api.UserDTO;
import com.love_calculator.service.LCAppEmailServiceImp;
import com.love_calculator.service.PredictionResultServiceImpl;

@Controller
public class EmailController {

	@Autowired
	LCAppEmailServiceImp lcAppEmailServiceImp;
	
	@Autowired
	PredictionResultServiceImpl predictionResultService;
	
	@RequestMapping("/email_page")
	String email_page(Model model)
	{
		model.addAttribute("emailDTO",new EmailDTO());
		return "email_page";
	}
	
	@RequestMapping("/email_response")
	String email_response( @SessionAttribute("userInfo") UserDTO userDTO,@ModelAttribute("emailDTO") EmailDTO emailDTO , Model model )
	{
		if(emailDTO.getEmail().isBlank())
		{
			
			model.addAttribute("exception", "Email can not be blank");
			return "exception";
		}
		else{
			
			if(emailDTO.getEmail().endsWith("@gmail.com"))
			{
			lcAppEmailServiceImp.sendEmail(userDTO.getUserName(), emailDTO.getEmail(),predictionResultService.calculateLove(userDTO.getUserName(),userDTO.getCrushName()));
			return "email_response";
				
			}
			else {
				model.addAttribute("exception", "Email must end with @gmail.com ");
				return "exception"; 
			}
			

		}
		
	}
	
//	@ExceptionHandler(value=Exception.class)
//	public String exception()
//	{
//		return "exception";
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	//email page
	
	
//	@RequestMapping("/email_page/{userName}")
//	String email_page(Model model , @PathVariable("userName") String name)
//	{
//		model.addAttribute("data",new UserDTO());
//		model.addAttribute("modelName",name);
//		return "email_page";
//	}
//	@RequestMapping("/email_response/{userName}")
//	String email_response(Model model , @PathVariable("userName") String userName  )
//	{
//		System.out.println("i am inside email_response");
//		
//		model.addAttribute("data", new UserDTO());
//		UserDTO u = new UserDTO();
//		
//		
//System.out.println(u.getEmail());
//System.out.println(u.getUserName());
//System.out.println(u.getCrushName());
//		model.addAttribute("userName",userName);
//		
//		//System.out.println(u.getUserName());
//		return "email_response";
//	}
}
