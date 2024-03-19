package edu.depaul.shoppingsystem.tests;

import edu.depaul.shoppingsystem.product.*; // access to Product (including subclasses) and ProductCatalog

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ProductCatalogTest {

    private ProductCatalog productCatalog;

    @BeforeEach
    void setUp() {
    	
    	// reset singleton ProductCatalog instance before each test
        productCatalog = ProductCatalog.getInstance();
        // load test products into the catalog to ensure a consistent test environment
        productCatalog.loadProductsFromCSV("data/ProductList.csv");
    }

    @Test
    void testFindProductById() {
        // Assuming you have a product with this ID in your CSV
        String testId = "fd25b3ca-16c7-46af-8ccb-d77f15e18405";
        Product foundProduct = productCatalog.findProductById(testId);
        assertNotNull(foundProduct, "Product with ID should be found");
        assertEquals(testId, foundProduct.getId(), "Found product ID should match the test ID");
    }

    @Test
    void testProductListNotEmpty() {
        List<Product> products = productCatalog.getProducts();
        assertFalse(products.isEmpty(), "Product list should not be empty after loading from CSV");
    }

    @Test
    void testProductType() {
        String testId = "a73e789f-6030-4d0c-8d05-3275917f462d"; // An electronics ID, for example
        Product foundProduct = productCatalog.findProductById(testId);
        assertNotNull(foundProduct, "Product should not be null");
        assertTrue(foundProduct instanceof Electronics, "Product should be an instance of Electronics");
    }
}

