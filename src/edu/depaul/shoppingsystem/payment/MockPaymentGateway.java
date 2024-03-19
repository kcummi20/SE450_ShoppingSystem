package edu.depaul.shoppingsystem.payment;

import edu.depaul.shoppingsystem.log.*;

// Simulate a successful transaction for mock payment 
// in real scenario, would integrate with a payment service provider here

public class MockPaymentGateway implements PaymentGateway {
	
	@Override
    public boolean processPayment(double amount, PaymentDetails paymentDetails) {
        // log the start of payment processing
        Logging.info("PaymentGateway", "Starting payment process for amount: $" + amount);
        
        try {
            // simulate payment processing logic here
            boolean isSuccess = Math.random() > 0.1; // simulated success rate
            
            if (isSuccess) {
                // log successful payment
                Logging.info("PaymentGateway", "Payment processed successfully for amount: $" + amount);
            } else {
                // log failed payment
                Logging.error("PaymentGateway", "Payment processing failed for amount: $" + amount);
            }
            
            return isSuccess;
        } catch (Exception e) {
            // log any exceptions during payment processing
            Logging.error("PaymentGateway", "Payment processing error: " + e.getMessage());
            return false;
        }
    }
}