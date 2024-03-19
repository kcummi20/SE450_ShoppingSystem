# SE450 Final Project: Shopping System

## Project Overview 
The "Southport Superstore" Shopping System is a comprehensive application developed to apply the fundamental principles and design patterns learned in my SE 540 course. This project emphasizes hands-on experience in building a robust and maintainable software application while incorporating SOLID principles, Singleton, Factory, and Builder design patterns. The system allows customers to browse products, add items to their shopping cart, place orders, and simulate the payment process.

## Getting Started
### Prerequisites
Java JDK 11 or later
An IDE like IntelliJ IDEA or Eclipse (optional)

### Running the Application
1) Clone the repository
2) Navigate to the project directory
3) Compile the application
4) Run the application

Alternatively, if using an IDE (such as Eclipse), you can directly run the 'Main' class.

## Navigation Features
User Authentication: Log in or create an account to associate cart data with user accounts.
Product Catalog: Browse a catalog of products loaded from a CSV file.
Shopping Cart Management: Add or remove products from your shopping cart.
Order and Payment Processing: Place orders and simulate the payment process using a mock payment gateway.
Logging: The system records important events and transactions.

## Design and Implementation
The application incorporates various design patterns and SOLID principles:

Singleton: Used for cart and product catalog management to ensure a single instance.
Factory: A ProductFactory creates product objects for the catalog.
Builder: CartBuilder constructs shopping carts with a fluent interface.
SOLID Principles: The application structure adheres to OCP, SRP, LSP, ISP, and DIP for maintainability and extensibility.

## Testing 
Critical components, such as the shopping cart, product catalog, and order processing, include JUnit tests to ensure reliability.

## Technical Notes
### Mock Payment Gateway
The "Southport Superstore" Shopping System simulates the payment processing using a mock payment gateway. This mock implementation is intended to demonstrate the flow of payment processing without actual financial transactions. It's designed to randomly accept or decline input as valid payment details for the sake of simplicity and demonstration purposes.

### Payment Gateway Integration
PaymentGateway Interface: The system includes a PaymentGateway interface, defining a contract for payment processing. This architecture choice lays the groundwork for integrating with actual payment service providers in the future. The interface specifies a processPayment method, which takes an amount and payment details, returning a boolean to indicate the success of the transaction. This design allows for seamless adaptation to various payment processors with minimal changes to the core application logic.

### Security Measures
Password Encryption: The user authentication system enhances security by encrypting passwords using a hash function. This approach ensures that user passwords are securely stored, making the system more resilient against unauthorized access and data breaches.

### Design Decisions
Singleton and Factory Patterns: Utilized to ensure efficient management of the shopping cart and product catalog. The Singleton pattern guarantees that only one instance of the cart and catalog is used throughout the application, promoting data consistency. The Factory pattern aids in the creation of products, allowing for flexibility and scalability in product management.

Builder Pattern for Cart Management: The CartBuilder class provides a fluent interface for constructing shopping carts. This design choice simplifies the process of adding or removing items and setting customer information, enhancing code readability and maintainability.

### Storage Options
File-Based Product Catalog: The current implementation loads products from a CSV file (data/productList.csv). This method was chosen for its simplicity and ease of modification. However, the system is designed to allow easy transition to database storage if needed.

### Limitations and Future Enhancements
While the current implementation uses a mock payment system, the inclusion of the PaymentGateway interface is a strategic decision to facilitate future integration with real payment service providers.

Enhancing user experience through the development of a graphical or web-based interface.

Transitioning to database storage for the product catalog and user management to improve scalability and manageability of data.

