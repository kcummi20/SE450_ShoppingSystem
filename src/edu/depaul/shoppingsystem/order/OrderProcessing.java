package edu.depaul.shoppingsystem.order;

import java.time.LocalDateTime;
import java.util.List;

import edu.depaul.shoppingsystem.cart.Cart;
import edu.depaul.shoppingsystem.cart.CartItem;

// Implement the process of placing orders, utilizing the Singleton and Factory patterns for cart management and product creation.
// Encapsulates details of order at finalization 
public class OrderProcessing {
	
	private static int nextOrderId = 1; // for unique order IDs

    private final int orderId;
    private final Cart cart; 
    private final List<CartItem> items; // capture the cart's state
    private final String customerName;
    private final String customerAddress;
    private final String customerEmail;
    private final LocalDateTime orderDate;
    private String orderStatus; // e.g., "Pending", "Shipped"
    
    public OrderProcessing(String customerName, String customerAddress, String customerEmail) {
        this.orderId = nextOrderId++;
        this.cart = Cart.getInstance(); // get single instance of cart
        this.items = cart.getItems(); // get current state of cart
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.orderDate = LocalDateTime.now();
        this.orderStatus = "Pending";
    }
    
    // calculate the total amount for the current items
    private double calculateTotalAmount() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
    
    // getters for order information
    public int getOrderId() {
        return orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    // setter for order status
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // calculate the total amount of the order (implement Cart method)
    public double calculateTotal() {
        return cart.calculateTotal();
    }

    // represent order details as a string, could be used for order confirmations
    @Override
    public String toString() {
        return "Order ID: " + orderId + "\n" +
               "Customer Name: " + customerName + "\n" +
               "Customer Address: " + customerAddress + "\n" +
               "Customer Email: " + customerEmail + "\n" +
               "Order Date: " + orderDate + "\n" +
               "Order Status: " + orderStatus + "\n" +
               "Order Total: $" + calculateTotalAmount();
    }

}


