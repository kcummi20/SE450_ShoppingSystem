package edu.depaul.shoppingsystem.payment;

// Defines the contract for payment processing
public interface PaymentGateway {
	
	/* Processes a payment
	 * 
	 * Parameters: 
	 * amount - amount to be paid
	 * paymentDetails - details of the payment method
	 * return true if payment is successful, false otherwise
	 * 
	 */
	boolean processPayment(double amount, PaymentDetails paymentDetails);
	
}
	


