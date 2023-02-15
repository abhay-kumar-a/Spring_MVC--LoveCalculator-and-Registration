package com.registration.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.registration.reference_entity.Phone;

// this PhoneNumberFormatter will calls with , String is try to convert in phone object.. , 
public class PhoneNumberFormatter implements Formatter<Phone> {// i want to use formatter with Phone Object , so i will
																// give Phone at place of generic type T;

	/// about print ---> let's say i want to show all data on my registration page .
	/// if same user want to edit his form details....
	// so my phone number is type of phone object and when data show on the phone
	/// text box , that data is type of string...
	// so for convert object data to string type-- we user print formatter.. it will
	/// call , when object data is try to convert in string type..
	@Override
	public String print(Phone phone, Locale locale) {
		// TODO Auto-generated method stub
		System.out.println("i am iside the print() formatter method of PhoneNumberFormatter");

		return phone.getCountryCode() + "-" + phone.getNumber();
	}

// this parse method will responsible to convert String  to required Object..
	@Override
	public Phone parse(String PhoneNumberString, Locale locale) throws ParseException {
		System.out.println("i am iside the parse() formatter method of PhoneNumberFormatter");
		PhoneNumberString.trim();
		// TODO Auto-generated method stub
		String[] phoneNumberString = PhoneNumberString.split("-");
		Phone phone = new Phone();
		int indexOf = PhoneNumberString.indexOf("-");
		
		int count=0;
		for(int i =0;i<PhoneNumberString.length();i++)
		{
			count++;
			if(PhoneNumberString.charAt(i)=='-')
			{
				break;
			}
		}
		if (indexOf == -1) {
			phone.setCountryCode("91");
			phone.setNumber(phoneNumberString[0]);
		}
		else if(count<2)
		{
			phone.setCountryCode("91");
			phone.setNumber(phoneNumberString[1]);
		}
		 else {
			phone.setCountryCode(phoneNumberString[0]);
			phone.setNumber(phoneNumberString[1]);
		}

		return phone;
	}

}

// for  say to spring, hey spring use this formatter , i have to implement WebMvcConfigurer interface with our COnfiguration class..
// and i will override the addFormatter method
// after that i will pass this PhoneNumberFormatter object to registry.addFormatter(new PhoneNumberFormatter());
