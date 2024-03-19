package edu.depaul.shoppingsystem.product;

import java.util.List;

// Implements Factory pattern for creating different types of product objects for the catalog

public class ProductFactory {
    private ProductCatalog productCatalog;
    
    // creates instance of ProductCatalog class and implements methods 

    public ProductFactory(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public void addProduct(Product product) {
        productCatalog.getProducts().add(product);
    }
    
    public List<Product> getProductCatalog() {
        return productCatalog.getProducts();
    }

    // create food item and add to product catalog
    public void createAndAddFood(String itemName, Double price, String id, String stockLevel, String delivery, String description, String size) {
        Food food = new Food(itemName, price, id, stockLevel, delivery, "Food", description, size);
        addProduct(food);
    }

    // create electronic item and add to product catalog
    public void createAndAddElectronics(String itemName, Double price, String id, String stockLevel, String delivery, String description, String color, String brand, String processorType) {
        Electronics electronics = new Electronics(itemName, price, id, stockLevel, delivery, "Electronics", description, color, brand, processorType);
        addProduct(electronics);
    }

    // create clothing item and add to product catalog
    public void createAndAddClothing(String itemName, Double price, String id, String stockLevel, String delivery, String description, String color, String size) {
        Clothing clothing = new Clothing(itemName, price, id, stockLevel, delivery, "Clothing", description, color, size);
        addProduct(clothing);
    }

    // create home item and add to product catalog 
    public void createAndAddHome(String itemName, Double price, String id, String stockLevel, String delivery, String description, String color, String room) {
        Home home = new Home(itemName, price, id, stockLevel, delivery, "Home", description, color, room);
        addProduct(home);
    }
}
