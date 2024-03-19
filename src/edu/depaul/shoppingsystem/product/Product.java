package edu.depaul.shoppingsystem.product;

// Represents a product with its attributes 

abstract public class Product {
	
	// general product attributes 
	private String itemName; 
	private double price; 
	private String id; 
	private String type; 
	private String description;
	private String stockLevel;
	private String delivery; // pick-up, delivery, in-store only
	
	// default constructor 
	public Product() {
		this.id = java.util.UUID.randomUUID().toString(); // generate unique ID
		this.itemName = "Item Name";
		this.price = 0.00;
		this.stockLevel = "In Stock";
		this.delivery = "Pick Up";
		this.type = "General";
		this.description = "";
		
	}
	
	// parameterized constructor
	public Product(String itemName, Double price, String id, String stockLevel, String delivery, String type, String description) {
		this.id = id; 
		this.itemName = itemName; 
		this.price = price;
		this.stockLevel = stockLevel; 
		this.delivery = delivery; 
		this.type = type; 
		this.description = description; 
	}

	// getters and setters for product attributes 
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getStockLevel() {
		return stockLevel;
	}

	public void setstockLevel(String stockLevel) {
		this.stockLevel = stockLevel;
	}
	
	
	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "\n" + "item: " + itemName + "\n" + "price: " + price + "\n" + "id: " + id + "\n" + "available for: " + delivery + "\n" + stockLevel + "\n" + "type: " + type + "\n" + "description: " + description;  
	}
	
	
}
