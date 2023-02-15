package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

	// canteen home page
	@RequestMapping("/canteen")
	public String CanteenHomePage() {
		System.out.println("I am inside Home controller()");
		return "welcome_page";
	}

	// order page
	@RequestMapping("/order_page")
	String Order() {
		return "order_page";
	}

// order submission
	@RequestMapping(path = "/submit_order", method = RequestMethod.GET)
	String submit_order(Model model, HttpServletRequest hh) {
		System.out.println("I am indide submidPage()");
		String s = hh.getParameter("foodType");
		model.addAttribute("model", s);
		return "submit_order";
	}

	@RequestMapping("/h")
	@ResponseBody
	public String Hello() {
		System.out.print("Hello is running");
		return "hii Man";
	}

//	@RequestMapping("/hh")
//	public String Hello1()
//	{
//		return "/WEB-INF/view/NewFile.jsp";// we return page like this 
//	}
	@RequestMapping("/hh")
	public String Hello1() {
		return "NewFile"; // but with the help of viewResolver we return web_page like this
	}

	// model

	@RequestMapping("/model")
	public String model(Model model) {
		String name = "Abhay Kumar";
		model.addAttribute("modelName", name);
		return "Example";
	}
}
