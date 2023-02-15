package com.love_calculator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.love_calculator.api.UserDTO;

@Service
public class PredictionResultServiceImpl implements PredictionResultService {

// First way
	public final static String LC_APP_FORMULA = "FLAMES";
    @Override
	public String calculateLove(String userName, String crushName) {
		int userAndCrushNameCount = (userName+crushName).toCharArray().length;
		int formulacount = LC_APP_FORMULA.toCharArray().length;
		
		int position = userAndCrushNameCount %formulacount;
		
		char resultChar = LC_APP_FORMULA.charAt(position);
	
		String whatsBetweenUs = whatsBetweenUs(resultChar);
		return whatsBetweenUs;

	}

	@Override
	public String whatsBetweenUs(char calculationResult) {
		switch(calculationResult)
		{
		
		case 'F' : 
			return LoveCalculatorConstants.F_CHAR_MEANING;
		case 'L' :
			return LoveCalculatorConstants.L_CHAR_MEANING;
		case 'A' :
			return LoveCalculatorConstants.A_CHAR_MEANING;
		case 'M' : 
			return LoveCalculatorConstants.M_CHAR_MEANING;
		case 'E' : 
			return LoveCalculatorConstants.E_CHAR_MEANING;
		case 'S' : 
			return LoveCalculatorConstants.S_CHAR_MEANING;
		
		}
		return null;
	}

	
	
	
	
	//----------------------------------------------------------------------------------------------------------------
	
	// second way
	public final static String rule = "FLAME";
	
	public String getPredictionResult(@SessionAttribute("userInfo") UserDTO userDTO) {
		String user = userDTO.getUserName();
		String crush = userDTO.getCrushName();

		int length1 = user.length();
		int length2 = crush.length();

		int position = (length2 + length1) % rule.length();
		for (int i = 0; i < rule.length(); i++) {
			if (i + 1 == position) {
				return predict(position);
			}
		}

		return "nothing";
	}

	public static String predict(int position) {
		String result = "";
		switch (rule.charAt(position)) {
		case 'F':
			result = Data.A;
			break;
		case 'L':
			result = Data.L;
			break;
		case 'A':
			result = Data.A;
			break;
		case 'M':
			result = Data.M;
			break;
		case 'E':
			result = Data.E;
		}
		return result;
	}

}

class Data {
	public static final String F = "FRIEND";
	public static final String L = "LOVE";
	public static final String A = "AFFECTION";
	public static final String M = "MARRIGE";
	public static final String E = "ENEMY";

}