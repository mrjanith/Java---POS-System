  POS -> 
        - no OOP
        - arrays,2D arrays
        - customer(id,name,address,salary)
        - product(code, description, unit price, qtyOnHand)
        - order (orderId,date,amount,customer)
        - orderDeatails (orderId, productCode, date,qty ,unitPrice)



Functional Requirements

    1. Customer Management Module (20 Marks)
    1.1 Add Customer (5 marks)
    Input validation for customer ID uniqueness
    Capture customer details (ID, name, address, salary)
    Prevent duplicate customer IDs
    Display success/error messages
    1.2 View All Customers (3 marks)
    Display all customers in tabular format
    Show customer ID, name, address, and salary
    Handle empty customer list scenario
    1.3 Search Customer (4 marks)
    Search by customer ID
    Display complete customer information
    Handle customer not found scenarios
    1.4 Update Customer (8 marks)
    Find customer by ID
    Allow selective field updates
    Maintain data integrity
    Confirm successful updates


    2. Product Management Module (20 Marks)
    2.1 Add Product(5 marks)
    Unique product code validation
    Input product details (code, description, price, quantity)
    Prevent duplicate product codes
    Display confirmation messages
    2.2 View All Products (3 marks)
    Tabular display of all products
    Show code, description, price, and stock levels
    Handle empty inventory scenarios
    2.3 Search Product(4 marks)
    Search by product code
    Display complete product information
    Handle product not found cases
    2.4 Update Product(4 marks)
    Modify product details except code
    Update description, price, and quantity
    Validate input data
    2.5 Stock Management(4 marks)
    Add or subtract stock quantities
    Prevent negative stock levels
    Display current stock after updates
    

    3. Order Processing Module (25 Marks)
    3.1 Create New Order (15 marks)
    Generate unique order IDs
    Validate customer existence
    Multi-item order processing
    Real-time stock checking and updates
    Calculate order totals automatically
    Handle insufficient stock scenarios
    3.2 Order Validation (5 marks)
    Verify customer ID exists
    Check product availability
    Validate quantities against stock
    Prevent invalid order creation
    3.3 Receipt Generation (5 marks)
    Format and display detailed receipts
    Show customer information
    List all ordered items with quantities and prices
    Display order total and date

    4. Order Management Module (15 Marks)
    4.1 View All Orders (8 marks)
    Display order summary in tabular format
    Show order ID, date, customer details, and total amount
    Allow detailed order viewing
    4.2 Order Details View (7 marks)
    Display complete order information
    Show itemized list of products
    Include customer and order metadata


    5. Reporting Module (15 Marks)
    5.1 Sales Summary Report(4 marks)
    Calculate total sales revenue
    Count total number of orders
    Compute average order value
    Display comprehensive sales statistics
    5.2 Product Sales Report(4 marks)
    Show quantity sold for each product
    Calculate revenue per product
    Display only products with sales activity
    5.3 Customer Purchase Report(4 marks)
    List customer purchase history
    Show total orders per customer
    Calculate total spending per customer
    5.4 Low Stock Alert(3 marks)
    User-defined minimum stock level
    Identify products below threshold
    Display products requiring restocking


    6. User Interface and Navigation (5 Marks)
    6.1 Menu System (3 marks)
    Clear and intuitive main menu
    Proper sub-menu navigation
    Consistent interface design
    6.2 Error Handling (2 marks)
    Validate user inputs
    Handle invalid menu selections
    Display appropriate error messages
    Implementation Guidelines
    Data Management Strategy
    . Use separate arrays for each entity attribute
    . Implement counter variables to track current array usage
    . Create search functions for finding records by key fields
    . Maintain data relationships through foreign key references
    Menu Structure
    Sample Data Requirements
    Initialize the system with:
    3 sample customers with varied salary ranges
    5 sample products with different categories and stock levels
    Display initialization confirmation message
