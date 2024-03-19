package edu.depaul.shoppingsystem.payment; 

import edu.depaul.shoppingsystem.cart.Cart;
import edu.depaul.shoppingsystem.payment.*;
import java.util.Scanner;

public class CheckoutService {

    private static Scanner scanner = new Scanner(System.in);

    public static void checkout(Cart cart) {
        System.out.println("Checkout Process:");
        System.out.println("Please enter payment details.\n");

        System.out.print("Cardholder Name: ");
        String cardholderName = scanner.nextLine();

        System.out.print("Card Number: ");
        String cardNumber = scanner.nextLine();

        System.out.print("Expiration Date (MM/YY): ");
        String expirDate = scanner.nextLine();

        System.out.print("CVV: ");
        String cvv = scanner.nextLine();

        // Calculate the total amount
        double amount = cart.calculateTotal();

        // Create payment details with user input
        PaymentDetails paymentDetails = new PaymentDetails(cardholderName, cardNumber, expirDate, cvv);
        paymentDetails.setCardholderName(cardholderName);
        paymentDetails.setCardNumber(cardNumber);
        paymentDetails.setExpirDate(expirDate);
        paymentDetails.setCvv(cvv);

        // Process payment
        PaymentGateway paymentGateway = new MockPaymentGateway();
        boolean paymentSuccess = paymentGateway.processPayment(amount, paymentDetails);

        if (paymentSuccess) {
            System.out.println("Payment succeeded.");
            cart.clearCart(); // Clear cart after successful payment
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }
}
