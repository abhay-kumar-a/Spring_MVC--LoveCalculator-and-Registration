package com.registration.converter;

import java.util.Arrays;

import org.springframework.core.convert.converter.Converter;

import com.registration.reference_entity.CreditCardNumber;

public class CreditCardConverter implements Converter<String, CreditCardNumber> { // this interface take two type of generic , first data Object take form user
	                                                                              // and convert it on required object
	@Override
	public CreditCardNumber convert(String source) {
		// TODO Auto-generated method stub
System.out.println("i a, inside first converter");
		// TODO Auto-generated method stub
		String[] split = source.split("-");
		System.out.println(Arrays.toString(split));
		CreditCardNumber card = new CreditCardNumber();
		card.setFirstNumber(Integer.parseInt(split[0]));
		card.setSecondNumber(Integer.parseInt(split[1]));
		card.setThirdNumber(Integer.parseInt(split[2]));
		card.setFirstNumber(Integer.parseInt(split[3]));

		return card;
	} 

}

// from register with mvc we user addFormatter to register..