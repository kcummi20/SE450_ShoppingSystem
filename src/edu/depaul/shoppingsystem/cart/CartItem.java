package edu.depaul.shoppingsystem.cart;

import edu.depaul.shoppingsystem.product.Product;

public class CartItem {

	private Product product; 
	private int quantity; 
	
	public CartItem(Product product, int quantity) {
		this.product = product; 
		this.quantity = quantity; 
	}
	
	// getters and setters
	public Product getProduct() {
		return product; 
	}
	
	public void setProduct(Product product) {
		this.product = product; 
	}
	
	public int getQuantity() {
		return quantity; 
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity; 
	}
	
	// total price = product price * quantity 
	public double getTotalPrice() {
		return this.product.getPrice() * this.quantity; 
	}
	
}

