package edu.depaul.shoppingsystem.product;

public class Clothing extends Product {
	
	private String color; 
	private String size; 

	// default constructor 
	public Clothing() {
		super(); 
		this.color = "Multicolored"; 
		this.size = "Medium";
	}
	
	// parameterized constructor
	public Clothing(String itemName, Double price, String id, String stockLevel, String delivery, String type, String description, String color, String size) {
		
		super(itemName, price, id, stockLevel, delivery, type, description);
		this.color = color; 
		this.size = size; 
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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
		
		
		return "\n" + "item: " + itemName + "\n" + "price: $" + price + "\n" + "id: " + id + "\n" + "color: " + color + "\n" + "size: " + size + "\n" +  "availability: " + stockLevel + "\n" + "delivery option: " + delivery + "\n" + "type: " + type + "\n" + "description: " + description;
	}
	
}
