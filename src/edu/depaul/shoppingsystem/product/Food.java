package edu.depaul.shoppingsystem.product;

public class Food extends Product {
	
	private String size; 
	
	// default constructor 
	public Food() {
		super(); 
		this.size = "8 oz";
	}
	
	// parameterized constructor
	public Food(String itemName, Double price, String id, String stockLevel, String delivery, String type, String description, String size) {
		
		super(itemName, price, id, stockLevel, delivery, type, description);
		this.size = size; 
	}

	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		String id = super.getId(); 
		String itemName = super.getItemName(); 
		Double price = super.getPrice(); 
		String stockLevel = super.getStockLevel();
		String delivery = super.getDelivery();
		String type = super.getType();
		String description = super.getDescription();
		
		
		return "\n" + "item: " + itemName + "\n" + "price: $" + price + "\n" + "id: " + id + "\n" + "size: " + size + "\n" + "availability: " + stockLevel + "\n" + "delivery option: " + delivery + "\n" + "type: " + type + "\n" + "description: " + description;
	}
	

}
