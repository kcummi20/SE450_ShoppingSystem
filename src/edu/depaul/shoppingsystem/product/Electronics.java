package edu.depaul.shoppingsystem.product;

public class Electronics extends Product {
	
	private String color; 
	private String brand; 
	private String processorType; 
	
	// default constructor 
	public Electronics() {
		super(); 
		this.color = "Multicolored"; 
		this.brand = "Apple";
		this.processorType = "Intel Core i7";
	}
	
	// parameterized constructor
	public Electronics(String itemName, Double price, String id, String stockLevel, String delivery, String type, String description, String color, String brand, String processorType) {
		
		super(itemName, price, id, stockLevel, delivery, type, description);
		this.color = color; 
		this.brand = brand; 
		this.processorType = processorType; 
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	public String getProcesserType() {
		return processorType;
	}

	public void setProcesserType(String processerType) {
		this.processorType = processerType;
	}

	@Override
	public String toString() { 
		String itemName = super.getItemName(); 
		Double price = super.getPrice(); 
		String id = super.getId();
		String stockLevel = super.getStockLevel();
		String delivery = super.getDelivery();
		String type = super.getType();
		String description = super.getDescription();
		
		
		return "\n" + "item: " + itemName + "\n" + "price: $" + price + "\n" + "id: " + id + "\n" + "brand: " + brand + "\n" + "processor type: "+ processorType + "\n" + "color: " + color + "\n" +  "availability: " + stockLevel + "\n" + "delivery option: " + delivery + "\n" + "type: " + type + "\n" + "description: " + description;
	}
	
		

}
