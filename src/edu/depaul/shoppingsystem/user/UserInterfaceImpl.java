package edu.depaul.shoppingsystem.user;

import edu.depaul.shoppingsystem.cart.Cart;

public class UserInterfaceImpl implements UserInterface {
    
    private String username; 
    private String password;
    
    public UserInterfaceImpl() {
        // ProductCatalog instance is managed elsewhere 
    }

    // getters and setters
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override 
    public Cart getCart() {
        return Cart.getInstance(); 
    }
    
}
