package com.love_calculator.custompropertyeditor;

import java.beans.PropertyEditorSupport;

public class CustomNamePropertyEditor extends PropertyEditorSupport {

	

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		String cap = text.toUpperCase();
		setValue(cap);
	}
	
	

}
