package edu.depaul.shoppingsystem.order;

// Build order - add and remove items from the cart, set customer information, and finalize the order
public interface FinalizeOrder {
    FinalizeOrder addItem(String productId, int quantity);
    FinalizeOrder removeItem(String productId);
    FinalizeOrder setCustomerInfo(String name, String address, String email);
    OrderProcessing finalizeOrder(); 
}