package edu.depaul.shoppingsystem.cart;

import edu.depaul.shoppingsystem.product.*; // access to Product Catalog
import edu.depaul.shoppingsystem.log.*; // access to Logging

import java.util.ArrayList;
import java.util.List;

// Represents shopping cart with its attributes
// Singleton used to ensure one instance of cart throughout the application

public class Cart {
	
	private static Cart instanceCart; // implements Singleton pattern 
	private List<CartItem> items; 
	private ProductCatalog catalog; 
	
	// private constructor to prevent external instantiation
	private Cart(){
		this.items = new ArrayList<>();
		this.catalog = ProductCatalog.getInstance();  
	}
	
	// Singleton instance getter
    public static Cart getInstance() {
        if (instanceCart == null) {
            instanceCart = new Cart();
        }
        return instanceCart;
    }
	
    // check if a product with the given ID exists in the cart
    public boolean containsProduct(String productId) {
        return items.stream().anyMatch(item -> item.getProduct().getId().equals(productId));
    }
    
    // add product by ID and adjust quantity 
    public boolean addItem(String productId, int quantity) {
        Product product = catalog.findProductById(productId);
        if (product != null) {
            if (containsProduct(productId)) {
                for (CartItem item : items) {
                    if (item.getProduct().getId().equals(productId)) {
                        item.setQuantity(item.getQuantity() + quantity);
                        Logging.info("Cart", "Added product ID " + productId + " to cart, Quantity: " + quantity);
                        return true; // Product found and quantity updated
                    }
                }
            } else {
                items.add(new CartItem(product, quantity));
                Logging.info("Cart", "Added product ID " + productId + " to cart, Quantity: " + quantity);
                return true; // New product added
            }
        } else {
            System.out.println("Product with ID " + productId + " not found.");
            return false; // Product not found in catalog
        }
        return false; // General failure case, should not be reached
    }

    // remove item by ID if in cart
    public void removeItem(String productId) {
    	items.removeIf(item -> item.getProduct().getId().equals(productId));
    	Logging.info("Cart", "Removed product ID " + productId + " from cart");
    }

    // calculate total price of items in cart 
    // summation of each product's total price -> CartItem method
    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void displayCartContents() {
        if (this.items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (CartItem item : this.items) {
                Product product = item.getProduct();
                System.out.println("\nProduct ID: " + product.getId() + "\n" + "Name: " + product.getItemName() + "\n" + "Price: $" + product.getPrice() + "\n" + "Quantity: " + item.getQuantity());
            }
            System.out.println("Total: $" + String.format("%.2f", calculateTotal()));
        }
    }


    // return copy of cart items 
    public List<CartItem> getItems() {
        return new ArrayList<>(items); // return a copy to prevent external modifications
    }
    
    // clear cart
    public void clearCart() {
        this.items.clear(); 
    }
	
	
}
