package edu.depaul.shoppingsystem.tests;

import edu.depaul.shoppingsystem.cart.Cart;
import edu.depaul.shoppingsystem.order.*;
import edu.depaul.shoppingsystem.product.Product;
import edu.depaul.shoppingsystem.product.ProductCatalog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderProcessingTest {
    
    private Cart cart;
    private ProductCatalog productCatalog;

    @BeforeEach
    void setUp() {
        // reset the singleton Cart instance and ProductCatalog instance before each test
        cart = Cart.getInstance();
        cart.clearCart(); // Assuming there's a method to clear the cart

        productCatalog = ProductCatalog.getInstance();
        // load test products into the catalog to ensure a consistent test environment
        productCatalog.loadProductsFromCSV("data/productList.csv"); // relative path
    }

    @Test
    void orderContainsCorrectItems() {
        String customerId = "customer123";
        String customerAddress = "123 Test St";
        String customerEmail = "test@example.com";

        // add items to the cart
        Product testProduct1 = productCatalog.findProductById("fd25b3ca-16c7-46af-8ccb-d77f15e18405"); // product1: tshirt
        Product testProduct2 = productCatalog.findProductById("4ea0c3c5-632f-46f1-866c-c5b39112d5bc"); // product2: pizza
        assertNotNull(testProduct1, "Test product 1 should not be null");
        assertNotNull(testProduct2, "Test product 2 should not be null");

        cart.addItem(testProduct1.getId(), 2); // add two of product 1
        cart.addItem(testProduct2.getId(), 1); // add one of product 2

        OrderProcessing order = new OrderProcessing(customerId, customerAddress, customerEmail);

        // verify that the order contains the correct items and quantities
        assertEquals(2, order.getCart().getItems().stream().filter(item -> item.getProduct().getId().equals(testProduct1.getId())).findFirst().get().getQuantity(), "Quantity of product 1 should be 2");
        assertEquals(1, order.getCart().getItems().stream().filter(item -> item.getProduct().getId().equals(testProduct2.getId())).findFirst().get().getQuantity(), "Quantity of product 2 should be 1");

        // verify other order properties
        assertEquals(customerId, order.getCustomerName(), "Customer name should match");
        assertEquals(customerAddress, order.getCustomerAddress(), "Customer address should match");
        assertEquals(customerEmail, order.getCustomerEmail(), "Customer email should match");
    }

    @Test
    void orderTotalIsCalculatedCorrectly() {
        String customerId = "customer123";
        String customerAddress = "123 Test St";
        String customerEmail = "test@example.com";

        Product testProduct1 = productCatalog.findProductById("fd25b3ca-16c7-46af-8ccb-d77f15e18405");
        Product testProduct2 = productCatalog.findProductById("4ea0c3c5-632f-46f1-866c-c5b39112d5bc");

        cart.addItem(testProduct1.getId(), 2); // total = $39.98, $19.99 each
        cart.addItem(testProduct2.getId(), 1); // total = $12.99 

        OrderProcessing order = new OrderProcessing(customerId, customerAddress, customerEmail);

        double expectedTotal = 2 * testProduct1.getPrice() + testProduct2.getPrice();
        assertEquals(expectedTotal, order.calculateTotal(), "Order total should be correctly calculated");
    }
}
