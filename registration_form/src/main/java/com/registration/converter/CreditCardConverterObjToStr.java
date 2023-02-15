package com.registration.converter;

import javax.naming.ldap.SortControl;

import org.springframework.core.convert.converter.Converter;

import com.registration.dto_api.BillDTO;
import com.registration.reference_entity.CreditCardNumber;

public class CreditCardConverterObjToStr implements Converter<CreditCardNumber, String> {

	@Override
	public String convert(CreditCardNumber source1) {
		
		System.out.println("I am inside of Converter");
		
		//System.out.println("s"+source);
		System.out.println("s"+source1);
		return "simple" +" "+source1.getFirstNumber();
	}

}
