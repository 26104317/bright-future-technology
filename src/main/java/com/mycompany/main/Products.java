/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author Mudau Adaho
 * 26104317
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Products {
    Products() {

        

        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
        System.out.println("***************************************");
        while (true) { // keep showing the main menu until the user chooses to exit
            System.out.println("");
            System.out.print("Enter (1) to launch menu or any other key to exit ");
            String userInput = scanner.nextLine();
            System.out.println("");
            if ("1".equals(userInput.trim())) {
                switch (DisplayMenu()) { // DisplayMenu() returns the number the user picked
                    case 1:
                        CaptureProduct();
                        break;
                    case 2:
                        SearchProduct();
                        break;
                    case 3:
                        UpdateProduct();
                        break;
                    case 4:
                        DeleteProduct();
                        break;
                    case 5:
                        PrintProductReport();
                        break;
                    case 6:
                        ExitApplication();
                        break;
                }
            } else {
                ExitApplication();
            }
        }
    }


    private static Scanner scanner = new Scanner(System.in); // used to get user input
    private static ArrayList<ReportData> productList = new ArrayList<>(); // stores  products

    // Shows the menu options 
    public static int DisplayMenu() {
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new product.");
        System.out.println("(2) Search for a product.");
        System.out.println("(3) Update a product.");
        System.out.println("(4) Delete a product.");
        System.out.println("(5) Print report.");
        System.out.println("(6) Exit Application.");
        int menuChoice = 0;
        System.out.print("choice >> ");
        while (true) {
            menuChoice = scanner.nextInt();
            scanner.nextLine(); // clears the leftover newline left by nextInt()
            if (!(menuChoice > 0 && menuChoice < 7)) {
                System.out.print("Choice must be between 1 and 6");
                continue;
            }
            System.out.println("");
            return menuChoice;
        }
    }

    // Collects details for a new product and saves it
    public static void CaptureProduct() {
        System.out.println("CAPTURE A NEW PRODUCT");
        System.out.println("**************************");

        System.out.print("Enter the product code: ");
        String productCode = scanner.nextLine().trim();

        while (true) { // won't let the product code be left empty
            if (productCode.isEmpty()) {
                System.out.println("Product code cannot be empty");
                System.out.print("Enter the product code: ");
                productCode = scanner.nextLine().trim();
            } else {
                break;

                // exits the loop if the product code is not empty
            }
        }

        // reject the product if the code is already used 
        for (ReportData existingProduct : productList) {
            if (existingProduct.getProductCode().equalsIgnoreCase(productCode)) {
                System.out.println("Product " + existingProduct.getProductName() + " is already in the system");
                return;
            }
        }

        String productName;
        while (true) { // won't let the product name be left empty
            System.out.print("Enter the product name: ");
            productName = scanner.nextLine().trim();
            if (!productName.isEmpty()) {
                break;
            }
            System.out.println("Product name cannot be empty");
        }

        System.out.println("");
        System.out.println("Select the product category:");
        System.out.println("Desktop Computer - 1");
        System.out.println("Laptop - 2");
        System.out.println("Tablet - 3");
        System.out.println("Printer - 4");
        System.out.println("Gaming Console - 5");
        System.out.print("Product category >> ");

        int category;
        while (true) { // category must be one of the 5 listed options
            category = scanner.nextInt();
            scanner.nextLine();
            if (category < 1 || category > 5) {
                System.out.println("Category has to be between 1 and 5");
                continue;
            }
            break;
        }

        System.out.println("");
        System.out.print("Indicate the product warranty. Enter (1) for 6 months or any other key for 2 years. ");
        String warrantyInput = scanner.nextLine();
        double warrantyMonths;
        if ("1".equals(warrantyInput.trim())) {
            warrantyMonths = 6.0;
        } else {
            warrantyMonths = 24.0; // any input other than "1" defaults to 2 years or 24 months
        }

        System.out.println("");
        System.out.print("Enter the price for " + productName + " >> ");
        double price;
        while (true) { // price cannot be negative
            price = scanner.nextDouble();
            scanner.nextLine();
            if (price < 0) {
                System.out.println("Price cannot be NEGATIVE!!!!");
                System.out.print("Enter price >> ");
                continue;
            }
            break;
        }

        int stockLevel;
        while (true) { 
            // stock level cannot be negative
            System.out.print("Enter Stock level for " + productName + " >> ");
            stockLevel = scanner.nextInt();
            scanner.nextLine();
            if (stockLevel < 0) {
                System.out.println("Stock cannot be negative");
                continue;
            }
            break;
        }

        String supplier;
        while (true) { // won't let the supplier be left empty
            System.out.print("Enter the supplier for " + productName + " >> ");
            supplier = scanner.nextLine().trim();
            if (!supplier.isEmpty()) {
                break;
            }
            System.out.println("Supplier cannot be empty");
        }

        // bundle everything collected above into one ReportData object and store it
        ReportData newProduct = new ReportData(productCode, productName, warrantyMonths, category, price, stockLevel,
                supplier);
        SaveProduct(newProduct);
    }

    // Adds the new product to the list 
    public static void SaveProduct(ReportData newProduct) {
        productList.add(newProduct);
        System.out.println("Product details has been saved successfully!!!");
    }

    // Looks up a product by its code and prints its details if found
    public static void SearchProduct() {
        String productCode;
        while (true) {
            System.out.print("Please enter the product code to search: ");
            productCode = scanner.nextLine().trim();
            if (!productCode.isEmpty()) {  // if the product code is not empty, exit the loop
                break;

                // exits the loop
            }
            System.out.println("Product code cannot be empty"); // will be shown to user only when the product code is
                                                                // empty
        }

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductCode().equalsIgnoreCase(productCode)) {
                ReportData foundProduct = productList.get(i);
                System.out.println("*************************************************");
                System.out.println("PRODUCT SEARCH RESULTS");
                System.out.println("*************************************************");
                System.out.println("PRODUCT CODE: " + foundProduct.getProductCode());
                System.out.println("PRODUCT NAME: " + foundProduct.getProductName());
                System.out.println("PRODUCT WARRANTY: " + (foundProduct.getWarranty() / 12) + " years"); // stored in months, shown in years
                System.out.println("PRODUCT CATEGORY: " + CategName(foundProduct.getCategory()));
                System.out.println("PRODUCT PRICE: " + foundProduct.getPrice());
                System.out.println("PRODUCT STOCK LEVELS: " + foundProduct.getStockLevels());
                System.out.println("PRODUCT SUPPLIER: " + foundProduct.getSupplier());
                return; 
                // stop looking once we've found and printed the match
            }
        }
        System.out.println("The product cannot be located. Invalid Product");
    }

    // Finds a product by code and removes it
    public static void DeleteProduct() {

        String productCode;


        while (true) {
            System.out.print("Please enter the product code to delete: ");
            productCode = scanner.nextLine().trim();
            if (!productCode.isEmpty()) {
                break;
            }
            System.out.println("Product code cannot be empty");
        }
        boolean found = false;

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductCode().equalsIgnoreCase(productCode)) {
                found = true;
                System.out.println("Are you sure that you want to delete? (y) for yes, any other key to cancel");
                String confirm = scanner.nextLine();

                if ("y".equalsIgnoreCase(confirm.trim())) {
                    productList.remove(i);
                    System.out.println("Product deleted successfully");
                } else {
                    System.out.println("Cancellation successful");
                }

                break; 
                // stop searching once the matching code has been handled
            }
        }

        if (!found) {
            System.out.println("The product was not found in the system");
        }

    }

    // Finds a product by code 
    public static void UpdateProduct() {
        String productCode;
        while (true) {
            System.out.print("Please enter the product code to update: ");
            productCode = scanner.nextLine().trim();
            if (!productCode.isEmpty()) {
                break;
            }
            System.out.println("Product code cannot be empty");
        }
        boolean found = false;

        for (int i = 0; i < productList.size(); i++) {
            ReportData productToUpdate = productList.get(i);
            if (productToUpdate.getProductCode().equalsIgnoreCase(productCode)) {
                found = true;

                // warranty update 
                System.out.print("Update the warranty? (y) Yes, (n) No ");
                while (true) {
                    String warrantyChoiceInput = scanner.nextLine().trim().toLowerCase();
                    if (warrantyChoiceInput.isEmpty()) {
                        System.out.print("Please enter 'y' or 'n': ");
                        continue;
                    }
                    char warrantyChoice = warrantyChoiceInput.charAt(0);

                    if (warrantyChoice == 'y') {
                        System.out.print(
                                "Indicate the new product warranty. Enter (1) for 6 months or any other key for 2 years. ");
                        String warrantyInput = scanner.nextLine();
                        if ("1".equals(warrantyInput.trim())) {
                            productToUpdate.setWarranty(6.0);
                        } else {
                            productToUpdate.setWarranty(24.0);
                        }
                        break;
                    } else if (warrantyChoice == 'n') {
                        System.out.println("It won't be changed then");
                        break;
                    } else {
                        System.out.print("Invalid character entered! Try again (y/n): ");
                    }
                }

                //price update
                System.out.print("Update the price? (y) Yes, (n) No ");
                while (true) {
                    String priceChoiceInput = scanner.nextLine().trim().toLowerCase();
                    if (priceChoiceInput.isEmpty()) {
                        System.out.print("Please enter 'y' or 'n': ");
                        continue;
                    }
                    char priceChoice = priceChoiceInput.charAt(0);

                    if (priceChoice == 'y') {
                        while (true) {
                            System.out.print("Enter the new price for " + productToUpdate.getProductName() + " >> ");
                            double newPrice = scanner.nextDouble();
                            scanner.nextLine();
                            productToUpdate.setPrice(newPrice);
                            break;
                        }
                        break;
                    } else if (priceChoice == 'n') {
                        System.out.println("Okay, Moving on");
                        break;
                    } else {
                        System.out.print("Invalid character entered! Try again (y/n): ");
                    }
                }

                // stock level update
                System.out.print("Update the stock level? (y) Yes, (n) No ");
                while (true) {
                    String stockChoiceInput = scanner.nextLine().trim().toLowerCase();

                    if (stockChoiceInput.isEmpty()) {
                        System.out.print("Please enter 'y' or 'n': ");
                        continue;
                    }

                    char stockChoice = stockChoiceInput.charAt(0);

                    if (stockChoice == 'y') {
                        while (true) {
                            System.out.print(
                                    "Enter the new stock level for " + productToUpdate.getProductName() + " >> ");
                            int newStock = scanner.nextInt();
                            scanner.nextLine();

                            if (newStock >= 0) {
                                productToUpdate.setStockLevels(newStock);
                                break;
                            } else {
                                System.out.println("Stock cannot be negative.");
                            }
                        }
                        break;
                    } else if (stockChoice == 'n') {
                        System.out.println("Stock level was not changed.");
                        break;
                    } else {
                        System.out.print("Invalid character entered! Enter (y) for Yes or (n) for No: ");
                    }
                }

                System.out.println("Product details updated successfully.");
                break; // stop searching once the product has been updated
            }
        }

        if (!found) {
            System.out.println("Product not found");
        }
    }

    // Prints every product in the list plus totals 
    public static void PrintProductReport() {
        System.out.println("PRODUCT REPORT");
        System.out.println("=====================================================================================");

        if (productList.isEmpty()) {
            System.out.println("No products available.");
            System.out.println("");
            return;
        }

        double totalValue = 0.0;
        for (int i = 0; i < productList.size(); i++) {
            ReportData product = productList.get(i);
            double productValue = product.getPrice() * product.getStockLevels(); // value of this product = price * stock on hand
            totalValue += productValue;
            System.out.println("PRODUCT " + (i + 1));
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("PRODUCT CODE >> " + product.getProductCode());
            System.out.println("PRODUCT NAME >> " + product.getProductName());
            System.out.println("PRODUCT WARRANTY >> " + (product.getWarranty() / 12) + " years");
            System.out.println("PRODUCT CATEGORY >> " + CategName(product.getCategory()));
            System.out.println("PRODUCT PRICE >> " + product.getPrice());
            System.out.println("PRODUCT STOCK LEVELS >> " + product.getStockLevels());
            System.out.println("PRODUCT SUPPLIER >> " + product.getSupplier());
            System.out.println("-------------------------------------------------------------------------------------");
        }

        System.out.println("==================================================================================");
        System.out.println("TOTAL PRODUCT COUNT: " + productList.size());
        System.out.println("TOTAL PRODUCT VALUE: R " + totalValue);
        System.out.println("AVERAGE PRODUCT VALUE: R " + (totalValue / productList.size()));
        System.out.println("==================================================================================");
    }

    // Ends the program
    public static void ExitApplication() {
        System.out.println("END,Have a great day!");
        System.exit(0);
    }

    // Converts the numeric category code (1-5) into its display name
    public static String CategName(int category) {
        switch (category) {
            case 1:
                return "Desktop Computer";
            case 2:
                return "Laptop";
            case 3:
                return "Tablet";
            case 4:
                return "Printer";
            case 5:
                return "Gaming Console";
            default:
                return "";

        }
    }
}
