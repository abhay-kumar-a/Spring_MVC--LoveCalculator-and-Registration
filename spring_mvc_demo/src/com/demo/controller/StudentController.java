package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Student;

@Controller
public class StudentController {

	@RequestMapping("/student")
	public String student(Model model)
	{
		
		// adding student object in model
				Student s = new Student();
				model.addAttribute("newStudent", s);
		return "student_form";
	}
	
	@RequestMapping("/submit_form")
	public String submit(HttpServletRequest h ,Model model ,@ModelAttribute("newStudent") Student std)
	{
		String s1 = h.getParameter("first");
		String s2 = h.getParameter("last");
		model.addAttribute("first", s1);
		model.addAttribute("last",s2);
	
		
		// taking Data from webPage , firstName, LastName by using ModelAttribute 
		System.out.println("The Student name is : "+std.getFirstName() + std.getLastName() +"\n country name "+ std.getCountry() +"\n Language : "+std.getFavoriteLanguage());
		return "submit_form";
	}
}
