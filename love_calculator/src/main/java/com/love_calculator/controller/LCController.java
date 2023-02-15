package com.love_calculator.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.love_calculator.api.UserDTO;
import com.love_calculator.custompropertyeditor.CustomNamePropertyEditor;
import com.love_calculator.service.PredictionResultServiceImpl;

@Controller
@SessionAttributes("userInfo")
public class LCController {
	@Autowired
	PredictionResultServiceImpl predictionResultService;

	// handling the track of user using session...

	/*
	 * about session
	 * 
	 * session object store user record and generate some key value pair means
	 * generate some unique for particular item and then generate one cookies file
	 * and store all id in cookies , and send this cookies with response and , this
	 * cookies store in client machine.. basically HttpSession take care of all
	 * things . create , manage cookies , giving opportunity to store user data on
	 * server memory
	 */

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String home( Model model,HttpSession session) {

		

		UserDTO userDto = (UserDTO) session.getAttribute("userInfo");
		if (userDto != null) {
			
			System.out.println("user not null  "+ userDto.getUserName());
			//System.out.println("user" +  userDto.getUserName());
			new UserDTO().setUserName(userDto.getUserName());
			return "home";
		} else {
			model.addAttribute("userInfo", new UserDTO());
			System.out.println("user  null" );

			return "home";
		}

	}

	@RequestMapping("/processForm")
	String processFrom(@Valid @ModelAttribute("userInfo") UserDTO userDTO, BindingResult result, Model model) // @Valid will validate the DTO error and BindingResult will hold that errors
																												
	{
//		// creTING SESSION and set key value of session..
//		HttpSession session = request.getSession();  // it will try to get session object , if not found create one..
//		
//		// we decided that how many times  the session will alive on server
//		session.setMaxInactiveInterval(120);  //120 minutes
//		
//		  session.setAttribute("userName", userDTO.getUserName());

		if (result.hasErrors()) {
			return "home";
		}

		String result1 = predictionResultService.calculateLove(userDTO.getUserName(), userDTO.getCrushName());
		model.addAttribute("predictResult", result1);

//		String predictResult = predictionResultService.getPredictionResult(userDTO);
//		model.addAttribute("predictResult", predictResult);

		return "userDetails";
	}

	/*
	 * here we are not dealing explicitly managing cookies.. all this will be done
	 * behind the seen by default session object are store in server memory , all
	 * the session object will removed when server will stop..
	 */

//-------------------------------------------------------------------------------------------------------------------------------------------
	// spring provides better way to manage sessions
	// by using annotation like @SessionAttribute..

	// @SessionAttributes("userInfo") // alias and Model model ,
	// model.addAttribute("userInfo",new userDTO) will be same

	// @SessionAttributes is so heavy annotations , which manage multiple things
	// behind the seen..

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomNamePropertyEditor editor = new CustomNamePropertyEditor();
		binder.registerCustomEditor(String.class, "userName", editor);
	}

//// using model ...
//	@RequestMapping("/")
//	public String Demo(Model model)
//	{
//		UserDTO userInfo = new UserDTO();
//		model.addAttribute("userInfo",userInfo);
//		return "home";
//	}

	// DataBinding.... using @RequestParam...
//	@RequestMapping("/processForm")
//	String processFrom(@RequestParam String userName ,@RequestParam String crushName , Model model)
//	{
//		model.addAttribute("userName", userName);
//		model.addAttribute("crushName", crushName);
//	
//		
//		System.out.println("User Name " +  userName);
//		System.out.println("Crush Name" + crushName );
//		
//		return "userDetails";
//	}

	// DataBinding using Data Transfer Object (DTO) .... and model... ---> only one
	// thing is caseSensititive -- thats name of input from
	// userName , crushName will be same as userDTO fields.. userName , crushName...

//	@RequestMapping("/processForm")
//	String processFrom(UserDTO userDTO , Model  model)  // when prosessForm is fired , Spring will create the object of UserDTO and , user setter
//	                                                     // methods to set query parameter values.. 
//	{
//		model.addAttribute("user",userDTO);
//		return "userDetails";
//	}

	// data binding using @ModelAttribute annotation ... -- its is used by spring
	// form...

	/// all about cookies...................
	// reading cookies using servlet...
	// by using @ModelAttribute....
	@RequestMapping("/12")
	public String Demo(@CookieValue("lcApp.UserName") String userName, @ModelAttribute("userInfo") UserDTO userDTO,
			HttpServletRequest request) {

		String userName1 = "";
		Cookie[] cookies = request.getCookies(); // with first request cookies will be null

		if (cookies != null) // so handling cookie if null
		{
			for (Cookie cookie : cookies)

			{
				if ("lcApp.UserName".equals(cookie.getName())) {
					userName1 = cookie.getValue();

				}

			}
			userDTO.setUserName(userName1);
		} else {
			return "home";
		}

		/// reading cookies using spring annotation
		// using @CookiesValue("keyName") String userName;
//
//		if (userName != null) {
//			userDTO.setUserName(userName);
//		}
//
//		else {
//			return "home";
//		}

		return "home";

	}

	// data binding using @ModelAttribute annotation ... -- its is used by spring
	// form...

	@RequestMapping("/processForm/12")
	String processFrom1(@Valid @ModelAttribute("userInfo") UserDTO userDTO, BindingResult result,
			HttpServletResponse response) // @Valid will valid the DTO error , and BindingResult will hold that errors
	{

		// create Cookies file on server
		Cookie theCookie = new Cookie("lcApp.UserName", userDTO.getUserName()); // cookie created and added cookie key
																				// and value is userName
		// set the life of cookie alive on client computer
		theCookie.setMaxAge(60 * 60 * 24); // 60 second , 60 minute , 24 hours
		// add cookie on response
		response.addCookie(theCookie);

		if (result.hasErrors()) {
//			List<ObjectError> allErrors = result.getAllErrors();
//			for(ObjectError e: allErrors)
//			{
//				System.out.println(e);
//			}
//			System.out.println("my form has some errors");
			return "home";
		}

		return "userDetails";
	}

}
