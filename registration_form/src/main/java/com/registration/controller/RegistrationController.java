package com.registration.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registration.dto_api.CommunicationDTO;
import com.registration.dto_api.UserDTO;
import com.registration.reference_entity.Phone;
import com.registration.spring_validator.EmailCustomValidator;
import com.registration.spring_validator.UserNameValidater;

@Controller
public class RegistrationController {
	
	
	@RequestMapping("/")
	String registration(Model model)
	{
		UserDTO userDTO = new UserDTO();
		model.addAttribute("userInfo",userDTO);
		System.out.println("i am inside registration() mehtod");
		
		// setting the default phone number for web page...
		Phone phone = new Phone();
		phone.setCountryCode("91");
		phone.setNumber("7459946676");
		
		// i have create phone object that hold the number;
		// then i will pass this phone in my communicationDTO
		
		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);
		// now my communication object have the phone number
		
		// now i want to show this phone number on web page..  and data of / web page are hold by user DTO Object...
		userDTO.setCommunication(communicationDTO);  // ---> here is the use of print formatter method.. because I want to convert this
		// phone number object to string object.. .. so while set this phone number to web page , first it will search print formatter..
		
		
		
		return "registration_page";
	}
	@RequestMapping("/user_details")
	String  userResponse(@Valid @ModelAttribute("userInfo") UserDTO user  ,BindingResult result)
	{
		System.out.println("I am inside the userResponse() method");
		System.out.println("name field is : "+ "|" + user.getName() + "|");
		if(result.hasErrors())
		{
//			List<ObjectError> allErrors = result.getAllErrors();
//			for(ObjectError a : allErrors)
//			{
//				System.out.println(a);
//			}
			return "registration_page";
		}

		return "registration_completed";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		//binder.setDisallowedFields("name");
		
		// custom 
//		StringTrimmerEditor editor = new StringTrimmerEditor(true); // when give true --> null , give false --> "" (empty String)
//		
//		//register  editor with binder
//		binder.registerCustomEditor(String.class,"name", editor);
		
		/// register spring custom validator...
		binder.addValidators(new UserNameValidater());
		
         binder.addValidators(new EmailCustomValidator());
		
		System.out.println("initBinder() method is called");
	}

}
