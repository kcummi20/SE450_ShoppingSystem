package edu.depaul.shoppingsystem.payment;

public class PaymentDetails {
	
	private String cardNumber;
	private String expirDate;
	private String cvv; 
	private String cardholderName;
	
	
	// constructor 
	public PaymentDetails(String cardholderName, String cardNumber, String expirDate, String cvv) {
		this.cardNumber = cardNumber;
		this.expirDate = expirDate;
		this.cvv = cvv;
		this.cardholderName = cardholderName;
	}
	// getters and setters
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpirDate() {
		return expirDate;
	}
	public void setExpirDate(String expirDate) {
		this.expirDate = expirDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getCardholderName() {
		return cardholderName;
	}
	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	} 
	

}
