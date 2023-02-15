package com.registration.custompropertyeditors;

import java.beans.PropertyEditorSupport;
import java.util.Currency;

public class CurrencyPropertyEditor extends PropertyEditorSupport{

	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		
		Currency curencyCurrency= Currency.getInstance(text.toUpperCase());
		
		
		// TODO Auto-generated method stub
		
		setValue(curencyCurrency);
	}
}
