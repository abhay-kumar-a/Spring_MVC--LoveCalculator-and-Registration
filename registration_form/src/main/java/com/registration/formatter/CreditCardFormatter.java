package com.registration.formatter;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.registration.reference_entity.CreditCardNumber;

public class CreditCardFormatter  implements Formatter<CreditCardNumber>{

	@Override
	public String print(CreditCardNumber object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditCardNumber parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("Indide the parseFormatter() of CreditCardNumber");
		String[] split = text.split("-");
		System.out.println(Arrays.toString(split));
		CreditCardNumber card = new CreditCardNumber();
		card.setFirstNumber(Integer.parseInt(split[0]));
		card.setSecondNumber(Integer.parseInt(split[1]));
		card.setThirdNumber(Integer.parseInt(split[2]));
		card.setFirstNumber(Integer.parseInt(split[3]));
		System.out.println(card);
		return card;
	}

}
