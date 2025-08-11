import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class App {

   static final int MAX_CUSTOMERS = 100;
   static final int MAX_PRODUCTS = 100;
   static final int MAX_ORDERS = 100;
   static final int MAX_ORDER_DETAILS = 100;

// Customer data -->  customer(id,name,address,salary)
   static int[] customerIds = new int[MAX_CUSTOMERS];
   static String[] customerName = new String[MAX_CUSTOMERS];
   static String[] customerAddress = new String[MAX_CUSTOMERS];
   static double[] customerSalaries = new double[MAX_CUSTOMERS];
   static int customerCount = 0;


// Product data --> product(code, description, unit price, qtyOnHand)
   static String[] productCodes = new String[MAX_PRODUCTS];
   static String[] productDescriptions = new String[MAX_PRODUCTS];
   static double[] productUnitPrice = new double[MAX_PRODUCTS];
   static int[] productQtyOnHand = new int[MAX_PRODUCTS];
   static int productCount = 0;


// Order data --> order (orderId,date,amount,customerId)

    static int[] orderIds = new int[MAX_ORDERS];
    static String[] orderDate = new String[MAX_ORDERS];
    static double[] orderAmount = new double[MAX_ORDERS];
    static int[] orderCustomerId = new int[MAX_ORDERS];
    static int orderCount = 0;

// Order Details data --> orderDetails (orderId, productCode, date, qty ,unitPrice)
    static int[] detailOrderIds = new int[MAX_ORDER_DETAILS];
    static String[] detailProductCodes = new String[MAX_ORDER_DETAILS];
    static String[] detailDates = new String[MAX_ORDER_DETAILS]; // Assuming date is represented as a String (e.g., "YYYYMMDD")
    static int[] detailQty = new int[MAX_ORDER_DETAILS];
    static double[] detailUnitPrice = new double[MAX_ORDER_DETAILS];
    static int orderDetailCount = 0;

   static Scanner scanner = new Scanner(System.in);


   public static void initializeSampleData() {
      // Sample Customer Data
      customerIds[0] = 1; customerName[0] = "John Doe"; customerAddress[0] = "123 Elm St"; customerSalaries[0] = 50000;
      customerIds[1] = 2; customerName[1] = "Jane Smith"; customerAddress[1] = "456 Oak St"; customerSalaries[1] = 60000;
      customerIds[2] = 3; customerName[2] = "Alice Johnson"; customerAddress[2] = "789 Pine St"; customerSalaries[2] = 70000;

      customerCount = 3; // Set the initial count of customers

      // Sample Product Data
      productCodes[0] = "P001"; productDescriptions[0] = "Laptop"; productUnitPrice[0] = 1200.0; productQtyOnHand[0] = 50; 
      productCodes[1] = "P002"; productDescriptions[1] = "Mouse"; productUnitPrice[1] = 800.0; productQtyOnHand[1] = 100;
      productCodes[2] = "P003"; productDescriptions[2] = "USE Keyboard"; productUnitPrice[2] = 600.0; productQtyOnHand[2] = 75;
      productCodes[3] = "P004"; productDescriptions[3] = "Printers"; productUnitPrice[3] = 300.0; productQtyOnHand[3] = 30;
      productCodes[4] = "P005"; productDescriptions[4] = "Monitor"; productUnitPrice[4] = 300.0; productQtyOnHand[4] = 30;

      productCount = 5; // Set the initial count of products

      System.out.println("Sample data initialized!");
      System.out.println("3 customers and 5 products added!");
      System.out.println();


   }


   static void displayMainMenu() {
      
      System.out.println("===POS SYSTEM MAIN MENU===");
      System.out.println("1. Manage Customers");
      System.out.println("2. Manage Products");
      System.out.println("3. Process Orders");
      System.out.println("4. View Order Details");
      System.out.println("5. Generate Reports");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");  
        
   }





   //  ================================== Customer management methods ==============================


   static void manageCustomers() {
      while (true) {
         System.out.println();
         System.out.println("===CUSTOMER MANAGEMENT===");
         System.out.println("1. Add Customer");
         System.out.println("2. View All Customers");
         System.out.println("3. Search Customer");
         System.out.println("4. Update Customers");
         System.out.println("5. Back to Main Menu");
         System.out.print("Enter your choice: ");
         
         int choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline character

         switch (choice) {
            case 1:
               addCustomer();
               break;
            case 2:
               viewAllCustomers();
               break;
            case 3:
               searchCustomer();
               break;
            case 4:
               updateCustomer();
               break;
            case 5:
               return; // Go back to main menu
            default:
               System.out.println("Invalid choice! Please try again.");
               System.out.println();
         }
      }
   }

   // Method to add a new customer
   static void addCustomer() {
      if (customerCount >= MAX_CUSTOMERS) {
         System.out.println("Customer limit reached. Cannot add more customers.");
         return;
      }
   
      System.out.print("Enter Customer ID: ");
      int customerId = scanner.nextInt();
      scanner.nextLine(); // Consume newline character

      //check if the ID already exists
      for (int i = 0; i < customerCount; i++) {
         if (customerIds[i] == customerId) {
            System.out.println("Customer ID already exists. Please enter a unique ID.");
            return;
         }
      }

      System.out.print("Enter Customer Name: ");
      String name = scanner.nextLine();
      

      System.out.print("Enter Customer Address: ");
      String address = scanner.nextLine();

      System.out.print("Enter Customer Salary: ");
      double salary = scanner.nextDouble();

      customerIds[customerCount] = customerId;
      customerName[customerCount] = name;
      customerAddress[customerCount] = address;
      customerSalaries[customerCount] = salary;
      customerCount++;
      System.out.println("Customer added successfully!");
      System.out.println();

   }

   // Method to view all customers
   static void viewAllCustomers() {
      if (customerCount == 0) {
         System.out.println("There is no customer to view.");
      }

      System.out.println("\n===ALL CUSTOMERS===");
      System.out.printf("%-5s %-20s %-30s %-10s%n", "ID", "Name", "Address", "Salary");
      System.out.println("-".repeat(70));

      for (int i = 0; i < customerCount; i++) {
         System.out.printf("%-5d %-20s %-30s $%-9.2f%n", customerIds[i], customerName[i], customerAddress[i], customerSalaries[i]);
      }
      System.out.println();



   }

   // Method to search for a customer by ID
   static void searchCustomer() {
      System.out.println("Enter Customer ID to search: ");
      int searchId = scanner.nextInt();

      for (int i = 0; i < customerCount; i++) {
         if (searchId == customerIds[i]) {
            System.out.println("\nCustomer found!");
            System.out.printf("ID: %d, Name: %s, Address: %s, Salary: $%.2f%n", customerIds[i], customerName[i], customerAddress[i], customerSalaries[i]);
            return;
         }
      }
      System.out.println("Customer with ID " + searchId + " not found.");
      System.out.println();

   }

   // Method to update customer details 
   static void updateCustomer() {
      System.out.println("Enter Customer ID to update: ");
      int updateId = scanner.nextInt();
      scanner.nextLine(); // Consume newline character

      for (int i=0; i<customerCount; i++){
         if (updateId == customerIds[i]) {
            System.out.println("Current Details:");
            System.out.printf("ID: %d, Name: %s, Address: %s, Salary: $%.2f%n", customerIds[i], customerName[i], customerAddress[i], customerSalaries[i]);
            System.out.println();

            System.out.println("Enter new Name (or press Enter to keep current): ");
            String newName = scanner.nextLine();
            if (!newName.trim().isEmpty()) {
               customerName[i] = newName;
            }

            System.out.println("Enter new Address (or press Enter to keep current): ");
            String newAddress = scanner.nextLine();
            if (!newAddress.trim().isEmpty()) {
               customerAddress[i] = newAddress;
            }

            System.out.println("Enter new Salary (or press Enter to keep current): ");
            String newSalaryStr = scanner.nextLine();
            if (!newSalaryStr.trim().isEmpty()) {
               double newSalary = Double.parseDouble(newSalaryStr);
               customerSalaries[i] = newSalary;
            }

            System.out.println("Customer details updated successfully!");
            return;
         }
      }
      System.out.println("Customer with ID " + updateId + " not found.");
      System.out.println();

   }







// ========================= Manage Products==========================

   static void manageProducts() {

      while (true) {
         System.out.println();
         System.out.println("===Product MANAGEMENT===");
         System.out.println("1. Add Product");
         System.out.println("2. View All Products");
         System.out.println("3. Search Products");
         System.out.println("4. Update Products");
         System.out.println("5. Update Stock");
         System.out.println("6. Back to Main Menu");
         System.out.print("Enter your choice: ");
         
         int choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline character

         switch (choice) {
            case 1:
               addProduct();
               break;
            case 2:
               viewAllProducts();
               break;
            case 3:
               searchProduct();
               break;
            case 4:
               updateProduct();
               break;
            case 5:
               updateStock();
               break;
            case 6:
               return;    // Go back to main menu
            default:
               System.out.println("Invalid choice! Please try again.");
               System.out.println();
         }
      }

      
      
   }


   // Method to add a new product
   static void addProduct() {

      if (productCount >= MAX_PRODUCTS) {
         System.out.println("Product limit reached. Cannot add more products.");
         return;
      }

      System.out.println("Enter Product Code: ");
      String code = scanner.nextLine();

      System.out.println("Enter Product Description: ");
      String description = scanner.nextLine();

      System.out.println("Enter Product Stock Quantity: ");
      int quantity = scanner.nextInt();

      System.out.println("Enter Product Unit Price: ");
      double price = scanner.nextDouble();

      productCodes[productCount] = code;
      productDescriptions[productCount] = description;
      productUnitPrice[productCount] = price;
      productQtyOnHand[productCount] = quantity;
      productCount++;

      System.out.println("Product added successfully!");
   }


   // Method to view all products
   static void viewAllProducts() {

      if (productCount == 0) {
         System.out.println("No products available.");
         return;
      }

      System.out.println("=== All Products ===");
      System.out.println();

      System.out.printf("%-10s %-30s %-10s %-8s%n","Code","Description","Price","Stock");
      System.out.println("-".repeat(70));

      for (int i = 0; i < productCount; i++) {
         System.out.printf("%-10s %-30s LKR %-10.2f %-8d%n",
               productCodes[i], productDescriptions[i], productUnitPrice[i], productQtyOnHand[i]);
      }
      System.out.println();
   }

   //Method to search products

   static void searchProduct() {
      System.out.println("Enter the product code to search:");
      String searchCode = scanner.nextLine();

      for (int i=0; i<productCount; i++){
         if (productCodes[i].equalsIgnoreCase(searchCode)) {
            System.out.printf("Product found: %-10s %-30s LKR %-10.2f %-8d%n",
                  productCodes[i], productDescriptions[i], productUnitPrice[i], productQtyOnHand[i]);
            return;
         }
      }
      System.out.println("Product with code " + searchCode + " not found.");
   }


   //Method to update product

   static void updateProduct() {

      System.out.println("Enter the product code to update:");
      String updateCode = scanner.nextLine();


      for (int i = 0;i<productCount;i++) {

         if (productCodes[i].equals(updateCode)){
            System.out.println("Current Details:");
            System.out.printf("%-10s %-30s LKR %-10.2f %-8d%n",
                  productCodes[i], productDescriptions[i], productUnitPrice[i], productQtyOnHand[i]);
            System.out.println();

            System.out.println("Enter new details:");

            System.out.println("Enter new Product Description (or press enter to keep current description): ");
            String newDescription = scanner.nextLine();

            if (!newDescription.trim().isEmpty()) {
               productDescriptions[i] = newDescription;
            }

            System.out.println("Enter new Product Unit Price (or press -1 to keep current price): ");
            Double priceInput = scanner.nextDouble();

            if (priceInput != -1) {
               productUnitPrice[i] = priceInput;
            }

            System.out.println("Enter new Product Stock Quantity (or press ente-1 to keep current quantity): ");
            int newQuantityInput = scanner.nextInt();

            if (newQuantityInput != -1) {
               productQtyOnHand[i] = newQuantityInput;
            }

            System.out.println("Product updated successfully!");
            return;
         }

      }

       System.out.println("Product with code " + updateCode + " not found.");

}


   //Method to update stock

   static void updateStock() {
      System.out.println("Enter the product code to update stock:");
      String updateCode = scanner.nextLine();

      for (int i = 0; i < productCount; i++) {
         if (productCodes[i].equals(updateCode)) {
            System.out.println("Current Stock Quantity: " + productQtyOnHand[i]);
            System.out.println("Quantity to add (or negative to subtract): ");
            int change = scanner.nextInt();

            if (productQtyOnHand[i] + change < 0) {
               System.out.println("Insufficient stock available.");
               return;
            }

            productQtyOnHand[i] += change;
            System.out.println("Stock updated successfully! New Stock Quantity: " + productQtyOnHand[i]);
            return;
         }
      }

      System.out.println("Product with code " + updateCode + " not found.");
   }




     
  // =========================== PROCESS ORDERS =======================================

 static void processOrders() {

   if (customerCount == 0) {
      System.out.println("There is no customer to process! please add a customer first.");
      return;
   }

   if (productCount == 0) {
      System.out.println("There are no products available for order processing! Please add products first.");
      return;
   }

   System.out.println("Enter order Id: ");
   int orderId = scanner.nextInt();
   scanner.nextLine(); // Consume newline character

   // Check for duplicate order ID
   for (int i=0; i<orderCount; i++) {
      if (orderIds[i] == orderId) {
         System.out.println("Order ID already exists. Please enter a unique Order ID.");
         return;
      }
   }

   System.out.println("Enter customer Id: ");
   int customerId = scanner.nextInt();

   //veridfy customer exists
   boolean customerExists = false;
   for (int i = 0; i < customerCount; i++) {
      if (customerIds[i] == customerId) {
         customerExists = true;  
         break;
      }
   }

   if (!customerExists){
      System.out.println("Customer with ID " + customerId + " not found.");
      return;
   }

   String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
   double totalAmount = 0;

   System.out.println("\nAdding items to order (enter 'Done' as product code to finish)");

   while (true) {
      System.out.println("Enter Product Code: ");
      String productCode = scanner.nextLine();

      if (productCode.equalsIgnoreCase("Done")) {
         break;
      }

      int productIndex = -1;
      for (int i=0;i< productCount;i++) {
         if (productCodes[i].equalsIgnoreCase(productCode)) {
            productIndex = i;
            break;
         }
      }

      if (productIndex == -1) {
         System.out.println("Product with code " + productCode + " not found.");
         continue;
      }

      System.out.println("Product: "+productDescriptions[productIndex]);
      System.out.println("Available Stock: " + productQtyOnHand[productIndex]);
      System.out.println("Unit Price: LKR " + productUnitPrice[productIndex]);   

      System.out.println("Enter Quantity: ");
      int quantity = scanner.nextInt();
      scanner.nextLine(); // Consume newline character

      if (quantity <= 0) {
         System.out.println("Invalid quantity. Please enter a positive number.");
         continue;
      }

      if (quantity > productQtyOnHand[productIndex]) {
         System.out.println("Insufficient stock available.");
         continue;
      }

      // ADD to the order
      if (orderDetailCount >= MAX_ORDER_DETAILS) {
         System.out.println("Order detail limit reached. Cannot add more items to the order.");
         return;
      }

      detailOrderIds[orderDetailCount] = orderId;
      detailProductCodes[orderDetailCount] = productCode;
      detailDates[orderDetailCount] = currentDate;
      detailQty[orderDetailCount] = quantity;
      detailUnitPrice[orderDetailCount] = productUnitPrice[productIndex];

      double itemTotal = quantity * productUnitPrice[productIndex];
      totalAmount += itemTotal;
      

      //update stock
      productQtyOnHand[productIndex] -= quantity;
      orderDetailCount++;

      System.out.printf("Added : %d x %s = LKR %.2f%n", quantity, productDescriptions[productIndex], itemTotal);
      System.out.printf("Order processed successfully! Total Amount: LKR %.2f%n", totalAmount);

   }

   if (totalAmount > 0) {
      orderIds[orderCount] = orderId;
      orderDate[orderCount] = currentDate;
      orderAmount[orderCount] = totalAmount;
      orderCustomerId[orderCount] = customerId;
      orderCount++;
      System.out.printf("Order processed successfully! Total Amount: LKR %.2f%n", totalAmount);

      //print receipt -->
      printReceipt(orderId);
   }else {
      System.out.println("No items added to the order. Order not processed.");
      return;
   }

  
}

// ================  Utilities ==================

static void printReceipt(int orderId) {
   System.out.println("\n"+"=".repeat(50));
   System.out.println("               RECEIPT             ");
   System.out.println("=".repeat(50));

   // find order
   for (int i = 0; i < orderCount; i++) {
      if (orderIds[i] == orderId) {
         System.out.printf("Order Id: "+ orderIds[i]);
         System.out.println("Date: "+orderDate[i]);

         //find customer
         for (int j=0; j<customerCount;j++){
            if (customerIds[j] == orderCustomerId[i]) {
               System.out.println("Customer Name: "+ customerName[j]);
               break;
            }
         }

         System.out.println("-".repeat(50));
         System.out.printf("%-20s %-5s %-10s %-15s%n", "Product Code", "Qty", "Price", "Total");
         System.out.println("-".repeat(50));

         double total = 0;
         for (int k=0; k< orderDetailCount; k++) {
            if (detailOrderIds[k] == orderId) {
               //product description
               String description = "";
               for (int m=0; m<productCount; m++) {
                  if (productCodes[m].equals(detailProductCodes[k])) {
                     description = productDescriptions[m];
                     break;
                  }
               }

               double itemTotal = detailQty[k] * detailUnitPrice[k];
               total += itemTotal;

               System.out.printf("%-20s %-5d LKR %-10.2f LKR %-15.2f%n",
                     description.length() > 20 ? description.substring(0, 20) : description,
                     detailQty[k], detailUnitPrice[k], itemTotal);
            }
         }

         System.out.println("-".repeat(50));
         System.out.printf("Total: LKR %.2f%n", total);
         System.out.println("-".repeat(50));
         System.out.println();
         break;
      }
   }

}



// ================ VIEW ORDERS ==================

static void viewOrders() {
   if (orderCount == 0) {
      System.out.println("No orders available.");
      return;
   }

   System.out.println("\n=== All Orders ===");
   System.out.printf ("%-8s %-12s %-12d %-20s %-20s %-10s%n","order Id","Order Date","Customer Id","customer Name","Amount");
   System.out.println("-".repeat(80));

   for (int i = 0; i < orderCount; i++) {
      String customersName ="";
      if (customerIds[i] == orderCustomerId[i]){
         customersName = customerName[i];
         break;

      }

      System.out.printf("%-8d %-12d %-12d %-20s %-20s %-10.2f%n",
            orderIds[i],
            orderDate[i],
            orderCustomerId[i],
            customersName,
            orderDate[i],
            orderAmount[i]);



   }

   System.out.println("\nEnter Order Id to view details (or 0 to return)");
   int orderId = scanner.nextInt();

   if (orderId == 0) {
      return;
   }

   // Find and display order details
   for (int i = 0; i < orderCount; i++) {
      if (orderIds[i] == orderId) {
         System.out.printf("Order Id: %d%n", orderIds[i]);
         System.out.printf("Order Date: %d%n", orderDate[i]);
         System.out.printf("Customer Id: %d%n", orderCustomerId[i]);
         System.out.printf("Amount: LKR %.2f%n", orderAmount[i]);
         return;
      }
   }

   System.out.println("Order not found.");
}




// ==================== GENERATE REPORTS =======================

static void generateReports() {
   while (true) {
      System.out.println("\n=== REPORTS MENU ===");
      System.out.println("1. Sales Summary");
      System.out.println("2. Product Sales Report");
      System.out.println("3. Customer Purchase Report");
      System.out.println("4. Low Stock Alert");
      System.out.println("5. Back to Main Menu");
      System.out.print("Enter your choice: ");


      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline character

      switch (choice) {
         case 1:
            
            generateSalesSummaryReport();
            break;
         case 2:
            
            generateProductSalesReport();
            break;
         case 3:
            
            generateCustomerPurchaseReport();
            break;
         case 4:
            
            generateLowStockAlert();
            break;
         case 5:
            return; // Back to Main Menu
         default:
            System.out.println("Invalid choice! Please try again.");
      }
   }

}


// Generate Sales Summary Report

static void generateSalesSummaryReport(){
   if (orderCount == 0) {
      System.out.println("No orders to summarize.");
      return;
   }

   double totalSales = 0;
   int totalOrders = orderCount;

   for (int i = 0; i < totalOrders; i++) {
      totalSales += orderAmount[i];
      
   }

   double averageOrderValue = totalSales / totalOrders;

   System.out.println("\n=== SALES SUMMARY REPORT ===");
   System.out.printf("Total Sales: LKR %.2f%n", totalSales);
   System.out.printf("Total Orders: %d%n", totalOrders);
   System.out.printf("Average Order Value: LKR %.2f%n", averageOrderValue);
}


// Generate Product Sales Report

static void generateProductSalesReport() {
   if (orderDetailCount == 0) {
      System.out.println("No product sales data available.");
      return;
   }

   System.out.println("\n=== PRODUCT SALES REPORT ===");
   System.out.printf("%-15s %-20s %-10s %-10s%n","Code", "Description", "sold Qty", "Revenue");

   for (int i = 0; i < productCount; i++) {
      int totalSold = 0;
      double totalRevenue = 0;

      for (int j = 0; j < orderDetailCount; j++) {
         if (detailProductCodes[j].equals(productCodes)) {
            totalSold += detailQty[j];
            totalRevenue += detailQty[j] * detailUnitPrice[j];
            
         }
      }

      System.out.printf("%-15d %-20s %-10d %-10.2f%n",
            productCodes[i],
            productDescriptions[i],
            totalSold,
            totalRevenue);
   }


}



// Generate Customer Purchase Report

static void generateCustomerPurchaseReport() {
   if (orderCount == 0) {
      System.out.println("No orders to report.");
      return;
   }


   System.out.println("\n=== CUSTOMER PURCHASE REPORT ===");
   System.out.printf("%-15s %-20s %-10s %-10s%n", "Customer ID", "Customer Name", "Total Orders", "Total Spent");
   System.out.println("-".repeat(50));

   for (int i = 0; i < customerCount; i++) {
      int orderCounter = 0;
      double totalSpent = 0;

      for (int j=0; j<orderCount; j++) {
         if (orderCustomerId[j] == customerIds[i]) {
            orderCounter++;
            totalSpent += orderAmount[j];
         }
      }
      if (orderCounter > 0) {
         System.out.printf("%-15d %-20s %-10d LKR %-10.2f%n",
               customerIds[i],
               customerName[i],
               orderCounter,
               totalSpent);
      }


   }




}


// Generate Low Stock Alert

static void generateLowStockAlert() {
   System.out.println("Enter minimum stock level for alert : ");
   int minimumStockLevel = scanner.nextInt();
   

   System.out.println("\n=== LOW STOCK ALERT ===");
   System.out.printf("%-15s %-20s %-10s%n", "Product Code", "Description", "Stock Level");
   System.out.println("-".repeat(50));

   boolean lowStockFound = false;
   for (int i=0; i<productCount;i++) {
      if (productQtyOnHand[i] <= minimumStockLevel){
         System.out.printf("%-15d %-20s %-10d%n",
               productCodes[i],
               productDescriptions[i],
               productQtyOnHand[i]);

         lowStockFound = true;
      }
   }
   if (!lowStockFound) {
      System.out.println("All products are above the minimum stock level.");
   }

}
   
















// ============================ Main Menu =============================

public static void main(String[] args) {

      initializeSampleData();

      System.out.println("Welcome to the app!");
      System.out.println();

      while (true) {

         displayMainMenu();
         


          
         int choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline character

         switch (choice) {
            case 1:
               manageCustomers();
               break;
            case 2:
               manageProducts(); 
               break;
            case 3:
               processOrders();
               break;
            case 4:
               viewOrders();
               break;
            case 5:
               generateReports(); // Call report generation methods
               break;
            case 6:
               System.out.println("Thank you for using POS System!");
               return;  
            default:
               System.out.println("Invalid choice! Please try again.");
         }






      }


   }


 











}

