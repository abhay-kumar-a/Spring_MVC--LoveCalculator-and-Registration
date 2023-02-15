package com.registration.reference_entity;

public class CreditCardNumber {
	Integer firstNumber;
	Integer SecondNumber;
	Integer ThirdNumber;
	Integer FourthNumber;

	public Integer getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(Integer firstNumber) {
		this.firstNumber = firstNumber;
	}

	public Integer getSecondNumber() {
		return SecondNumber;
	}

	public void setSecondNumber(Integer secondNumber) {
		SecondNumber = secondNumber;
	}

	public Integer getThirdNumber() {
		return ThirdNumber;
	}

	public void setThirdNumber(Integer thirdNumber) {
		ThirdNumber = thirdNumber;
	}

	public Integer getFourthNumber() {
		return FourthNumber;
	}

	public void setFourthNumber(Integer fourthNumber) {
		FourthNumber = fourthNumber;
	}
	

	@Override
	public String toString() {
		return getFirstNumber()+"-" + getSecondNumber()+ "-" + getThirdNumber()+"-"+ getFirstNumber();
	}


}
