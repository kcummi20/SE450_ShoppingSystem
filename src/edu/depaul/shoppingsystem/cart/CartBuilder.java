package edu.depaul.shoppingsystem.cart;

import edu.depaul.shoppingsystem.order.FinalizeOrder;
import edu.depaul.shoppingsystem.order.OrderProcessing;

// Constructs and manages the cart
public class CartBuilder implements FinalizeOrder {
    private final Cart cart; // Singleton, so we use the instance
    private String customerName;
    private String customerAddress;
    private String customerEmail;

    public CartBuilder() {
        this.cart = Cart.getInstance(); // Use the Singleton instance
    }

    @Override
    public FinalizeOrder addItem(String productId, int quantity) {
        cart.addItem(productId, quantity);
        return this;
    }
    
    @Override 
    public FinalizeOrder removeItem(String productId) {
    	cart.removeItem(productId);
    	return this; 
    }
    
    @Override 
    public FinalizeOrder setCustomerInfo(String name, String address, String email) {
    	this.customerName = name;
        this.customerAddress = address;
        this.customerEmail = email;
        return this;
    }

    @Override
    public OrderProcessing finalizeOrder() {
        // handle the finalization process, ensuring all necessary
        // information is set and cart is in a valid state before creating an OrderProcessing
        if (isValidCustomerInfo() && !cart.getItems().isEmpty()) {
            return new OrderProcessing(customerName, customerAddress, customerEmail); // Creates an Order
        } else {
            throw new IllegalStateException("Cart or customer information is incomplete or invalid.");
        }
    }

    private boolean isValidCustomerInfo() {
        // customer info validation logic
        return customerName != null && !customerName.isEmpty() &&
               customerAddress != null && !customerAddress.isEmpty() &&
               customerEmail != null && !customerEmail.isEmpty();
    }

}
