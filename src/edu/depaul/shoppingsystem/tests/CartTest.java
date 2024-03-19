package edu.depaul.shoppingsystem.tests;

import edu.depaul.shoppingsystem.cart.Cart; // access to Cart
import edu.depaul.shoppingsystem.product.*; // access to Product Catalog

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 

class CartTest {
    
    private Cart cart;
    private ProductCatalog productCatalog;

    @BeforeEach
    void setUp() {
        cart = Cart.getInstance();
        cart.clearCart();
        productCatalog = ProductCatalog.getInstance();
        productCatalog.loadProductsFromCSV("data/productList.csv"); // relative path
    }

    @Test
    void addItemToCart() {
        String tShirtId = "fd25b3ca-16c7-46af-8ccb-d77f15e18405"; // T-shirt ID from Product Catalog
        String jeansId = "c6810ad0-543d-460c-8e46-c2ea19c15747"; // Jeans ID Product Catalog
        cart.addItem(tShirtId, 1);
        cart.addItem(jeansId, 1);
        
        assertFalse(cart.getItems().isEmpty(), "Cart should not be empty after adding items.");
        assertEquals(2, cart.getItems().size(), "Cart should contain two items.");
    }

    @Test
    void removeItemFromCart() {
        String pizzaId = "4ea0c3c5-632f-46f1-866c-c5b39112d5bc"; // Pizza ID from Product Catalog
        cart.addItem(pizzaId, 1);
        cart.removeItem(pizzaId);
        
        assertTrue(cart.getItems().isEmpty(), "Cart should be empty after removing the item.");
    }

    @Test
    void calculateTotal() {
        // using IDs from the CSV for T-shirt and Pizza
        String tShirtId = "fd25b3ca-16c7-46af-8ccb-d77f15e18405";
        String pizzaId = "4ea0c3c5-632f-46f1-866c-c5b39112d5bc";
        
        cart.addItem(tShirtId, 1); // price from Product Catalog: 19.99
        cart.addItem(pizzaId, 2); // Price from Product Catalog: 12.99 each
        
        double expectedTotal = 19.99 + (2 * 12.99); // total should be price of 1 T-shirt and 2 Pizzas
        assertEquals(expectedTotal, cart.calculateTotal(), "Total should match the expected value.");
    }
}
