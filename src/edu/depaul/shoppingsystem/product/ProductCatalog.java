package edu.depaul.shoppingsystem.product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProductCatalog {
	
	private static ProductCatalog productCatalogInstance; 
    private List<Product> products; // creates list for instances of Product class and subclasses 
    

    public ProductCatalog() {
        products = new ArrayList<>();
    }
    
    // create static reference to Product Catalog (implement Singleton)
    public static synchronized ProductCatalog getInstance() {
        if (productCatalogInstance == null) {
        	productCatalogInstance = new ProductCatalog();
        }
        return productCatalogInstance;
    }

    // load product info from csv into Product Catalog 
    public void loadProductsFromCSV(String csvFile) {
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // skip the header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                if (data.length < 5 || data[4].trim().isEmpty()) {
                    System.err.println("Incomplete or missing product type data: " + line);
                    continue; // skip lines with incomplete or missing product type data
                }
            
                String itemName = data[0].trim();
                double price = Double.parseDouble(data[1].trim());
                String id = data[2].trim();
                String stockLevel = data[3].trim();
                String delivery = data[4].trim();
                String type = data[5].trim();
                String description = data.length > 6 ? data[6].trim() : ""; // check for array length
                String color = data.length > 7 ? data[7].trim() : ""; // check for array length
                String size = data.length > 8 ? data[8].trim() : ""; // check for array length
                String brand = data.length > 9 ? data[9].trim() : ""; // check for array length
                String processorType = data.length > 10 ? data[10].trim() : ""; // check for array length
                String room = data.length > 11 ? data[11].trim() : ""; // check for array length

                // create specific product types based on the 'type' field
                Product product = null;
                switch (type.toLowerCase()) {
                    case "clothing":
                        product = new Clothing(itemName, price, id, stockLevel, delivery, type, description, color, size);
                        break;
                    case "electronics":
                        product = new Electronics(itemName, price, id, stockLevel, delivery, type, description, color, brand, processorType);
                        break;
                    case "food":
                        product = new Food(itemName, price, id, stockLevel, delivery, type, description, size);
                        break;
                    case "home":
                        product = new Home(itemName, price, id, stockLevel, delivery, type, description, color, room);
                        break;
                    default:
                        // handle unknown type
                        System.out.println("Unknown product type: " + type);
                        break;
                }

                if (product != null) {
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error parsing price as double: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // find a product by its ID
    public Product findProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null; // product not found
    }
    
    // getter 
    public List<Product> getProducts() {
        return products;
    }

    // no setter because Singleton design
    
}
