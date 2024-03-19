package edu.depaul.shoppingsystem.product;

public class Home extends Product {
	
	private String color; 
	private String room; 
	
	// default constructor 
	public Home() {
		super(); 
		this.color = "Multicolored";
		this.room = "Bedroom";
	}
	
	// parameterized constructor
	public Home(String itemName, Double price, String id, String stockLevel, String delivery, String type, String description, String color, String room) {
		
		super(itemName, price, id, stockLevel, delivery, type, description);
		this.color = color; 
		this.room = room;
		
	}
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
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
		
		
		return "\n" + "item: " + itemName + "\n" + "price: $" + price + "\n" + "id: " + id + "\n" + "room: " + room + "\n" + "color: " + color + "\n" + "availability: " + stockLevel + "\n" + "delivery option: " + delivery + "\n" + "type: " + type + "\n" + "description: " + description;
	}
	
	

}
