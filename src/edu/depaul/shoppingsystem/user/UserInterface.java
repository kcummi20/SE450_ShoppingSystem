package edu.depaul.shoppingsystem.user;

import edu.depaul.shoppingsystem.cart.Cart;

public interface UserInterface {
	
    // username getter and setter
    String getUsername();
    void setUsername(String username);
    
    // password getter and setter
    String getPassword();
    void setPassword(String password);
    
    // shopping cart getter
    // no setter for the cart because instance is globally accessible (Singleton)
    Cart getCart(); 
}
