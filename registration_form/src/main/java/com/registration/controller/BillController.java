package com.registration.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registration.custom_formatter_propertyeditor.CreditCardPropertyFormatter;
import com.registration.custompropertyeditors.CurrencyPropertyEditor;
import com.registration.dto_api.BillDTO;
import com.registration.formatter.CreditCardFormatter;
import com.registration.reference_entity.CreditCardNumber;

@Controller
public class BillController {

	@RequestMapping("/bill")
	public String getBill(@ModelAttribute("bill") BillDTO billDTO)
	{
		return "bill_page";
	}
	
	@RequestMapping("/billProcess")
	public String billDetails(@ModelAttribute("bill") BillDTO billDTO)
	{
		System.out.println("card number : "+billDTO.getCardNumber() );
		System.out.println("bill Amount : "+ billDTO.getAmount() );
		System.out.println("currency  : "+ billDTO.getCurrency());
		System.out.println("date: "+ billDTO.getDate());
		return "bill_details";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		//editor use for the date field
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy");
		CustomDateEditor editor = new CustomDateEditor(date,true);
		binder.registerCustomEditor(Date.class,"date",editor);
		
		/// adding dummy data on web page from credit card
		CreditCardNumber source = new CreditCardNumber();
		source.setFirstNumber(1000);
		source.setSecondNumber(2000);
		source.setFirstNumber(3000);
		source.setFourthNumber(4000);
		BillDTO dto = new BillDTO();
		dto.setCardNumber(source);
		
		// Register a custom editor for the amount field... if i want to enter number like 20,000.00   --> instead of 20000
		
		NumberFormat number  = new DecimalFormat("##,###.00"); // define the formate of numnber 
		
		CustomNumberEditor editor1 = new CustomNumberEditor(BigDecimal.class,number,true);
		binder.registerCustomEditor(BigDecimal.class,"amount", editor1);
		
		// register custom editor for currency
		
		CurrencyPropertyEditor editor2 = new CurrencyPropertyEditor();
		binder.registerCustomEditor(Currency.class,"currency", editor2);
		
		// adding a custom formatter...
		// adding my credit card formatter by using InitBinder without registering my formatter using addFormatters() witch come from WebMvcConfigrur
//		CreditCardFormatter  formatter = new CreditCardFormatter();
//		binder.addCustomFormatter(formatter);
		
		
		// credit card custom property editor formatter , 
		
//		CreditCardPropertyFormatter property_formatter = new CreditCardPropertyFormatter();
//		binder.registerCustomEditor(CreditCardNumber.class,"cardNumber", property_formatter);
		
		
		
	}
}
