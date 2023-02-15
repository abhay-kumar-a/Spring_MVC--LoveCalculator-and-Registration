package com.registration.custom_formatter_propertyeditor;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;

import com.registration.reference_entity.CreditCardNumber;

public class CreditCardPropertyFormatter extends PropertyEditorSupport {
	// setting dummy value for credit card..
		@Override
		public String getAsText() {  // with the help of this method  we can set date on web page without using print formatter
			// TODO Auto-generated method stub
			
			//getValuse is the method , with the help of this , we take object of class
			
			//CreditCardNumber bumber = (CreditCardNumber)getValue();


			return "####-####-####-####";
		}
		
		
		/// setting formatter
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			String[] split = text.split("-");
			System.out.println(Arrays.toString(split));
			CreditCardNumber card = new CreditCardNumber();
			card.setFirstNumber(Integer.parseInt(split[0]));
			card.setSecondNumber(Integer.parseInt(split[1]));
			card.setThirdNumber(Integer.parseInt(split[2]));
			card.setFirstNumber(Integer.parseInt(split[3]));
			
			setValue(card);
			
		}
		


}
