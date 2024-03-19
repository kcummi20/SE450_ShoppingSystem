package edu.depaul.shoppingsystem.main;

import edu.depaul.shoppingsystem.cart.*;
import edu.depaul.shoppingsystem.product.*;
import edu.depaul.shoppingsystem.user.*;
import edu.depaul.shoppingsystem.order.*;

import java.util.Scanner; 

public class Main {
	
	// instances of Main class object
	private static ProductCatalog productCatalog = ProductCatalog.getInstance();
	private static Cart cart = Cart.getInstance(); 
	private static Scanner scanner = new Scanner(System.in);
	

	public static void main (String[] args) {
		
        //////// User Access/Authentication --> login, create account or exit ////////

		UserAuthentication userAuth = new UserAuthentication();
		
		boolean isAuthenticated = false; // initiate isAuthenticated as false

        System.out.println("Welcome to Southport Superstore!");
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Exit");
            System.out.print("Choose a numeric option (1-3): ");
            String input = scanner.nextLine();

            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        isAuthenticated = userAuth.authenticateUser(username, password);
                        if (isAuthenticated) {
                            System.out.println("Login successful!");
                            handleLoggedInUser();
                        } else {
                            System.out.println("Login failed. Please try again.");
                        }
                        break;
                    case 2:
                    	System.out.print("Choose a username: ");
                        String newUsername = scanner.nextLine();
                        System.out.print("\nPassword Requirements\nMust consist of at least eight characters include each of the following:\n1) uppercase letter\n2) lowercase letter\n3) digit\n4) special character\nChoose a password: ");
                        String newPassword = scanner.nextLine();
        		
                        if (userAuth.createNewAccount(newUsername, newPassword)) {
                            System.out.println("\nAccount created successfully! Please login.");
                        } else {
                            System.out.println("Failed to create account. The username may already exist or the password does not meet the requirements.");
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid numeric option.");
            }
        }
    }
	
	//////// LoggedIn User Handling --> present product catalog ////////
	private static void handleLoggedInUser() {
		System.out.println("\nUser is logged in...");
		
		// load product catalog
		productCatalog.loadProductsFromCSV("data/productList.csv");
		
			boolean exit = false;
			while (!exit) {
				System.out.println("\nNavigation Menu: ");
				System.out.println("1. View Products");
				System.out.println("2. Add Product to Cart");
				System.out.println("3. View Cart");
				System.out.println("4. Review and Checkout");
				System.out.println("5. Logout");
				System.out.print("\nChoose a numeric option (1-5): ");
				int choice = Integer.parseInt(scanner.nextLine());
	    
				switch (choice) {
					case 1:
						// print all products
				        productCatalog.getProducts().forEach(System.out::println);
				        break;
				    case 2:
				       // add a product to the cart
				       System.out.print("Enter product ID: ");
				       String productId = scanner.nextLine();
				       System.out.print("Enter quantity: ");
				       int quantity = Integer.parseInt(scanner.nextLine());
				       boolean added = cart.addItem(productId, quantity);
				       if (added) {
				    	   System.out.println("Product added to cart.");
				       }
				       break;
				    case 3:
				        // view cart items
				        cart.displayCartContents();
				        break;
				    case 4:
				        if (cart.getItems().isEmpty()) {
				            System.out.println("Your cart is empty, add some products before checkout.");
				        } else {
				            boolean reviewingCart = true;
				            while (reviewingCart) {
				                System.out.println("Your current cart:");
				                cart.displayCartContents(); // display cart contents
				                System.out.println("Press 1 to proceed to checkout, 2 to remove items, or 3 to return to navigation menu: ");
				                String cartChoice = scanner.nextLine();
				                switch (cartChoice) {
					                case "1":
					                    if (cart.getItems().isEmpty()) { // need check if remove all items 
					                        System.out.println("Your cart is empty, please add some products before checkout.");
					                    } else {
					                        System.out.println("Proceeding to checkout...");
					                        CheckoutService.checkout(cart);
					                    }
					                    reviewingCart = false;
					                    break;
				                    case "2":
				                        // implement functionality to remove items
				                    	System.out.println("Enter the product ID of the item you wish to remove:");
				                        String productIdToRemove = scanner.nextLine();
				                        if (cart.containsProduct(productIdToRemove)) { // Assume containsProduct checks if the product is in the cart
				                            cart.removeItem(productIdToRemove);
				                            System.out.println("Product removed successfully.");
				                        } else {
				                            System.out.println("Product not found in cart.");
				                        }
				                        break;
				                    case "3":
				                        reviewingCart = false;
				                        break;
				                    default:
				                        System.out.println("Invalid option, please try again.");
				                        break;
				                }
				            }
				        }
				        break;
				    case 5:
				       // logout
				       System.out.println("\nLogging out...");
				       exit = true;
				       break;
				   default:
				       System.out.println("Invalid option, please try again.");
				       break;
				}
			}
	}
}
		   
		