package com.registration.dto_api;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import com.registration.reference_entity.CreditCardNumber;

public class BillDTO {

	private CreditCardNumber cardNumber;
	private BigDecimal amount;
	private Currency currency;
	private Date date;

	public CreditCardNumber getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(CreditCardNumber cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
