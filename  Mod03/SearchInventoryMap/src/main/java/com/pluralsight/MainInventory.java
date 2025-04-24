package com.pluralsight;
/*
 * Description:
 * This application demonstrates how to load products from an Inventory.csv file
 * and store them in a Map for easy search functionality.
 *
 * Features:
 * - Implements a loadInventory() method to read and parse the Inventory.csv file.
 * - Creates a Product object from each line in the CSV.
 * - Stores products in a Map using the product name as the key.
 * - Allows users to search for products by name.
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainInventory {

    public static void main(String[] args) {

        String filePath = "/Users/erimo/pluralsight/workbook-3/ Mod03/SearchInventoryMap/src/main/resources/products.csv";

        //Load the inventory data from CSV into a HashMap
        Map<String, Product> inventory = loadInventory(filePath);
        System.out.println("Loaded " + inventory.size() + " products from inventory file.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Search for your products by name.");


        while (true) {
            System.out.print("\nEnter product name to search (or 'exit' to quit): ");
            String searchTerm = scanner.nextLine();

            // Check if user wants to exit
            if (searchTerm.equalsIgnoreCase("exit")) {
              break;
            }

            Product foundProduct = inventory.get(searchTerm);

            if (foundProduct != null) {
                System.out.println("\n Product Found");
                System.out.println("SKU: " + foundProduct.getProductId());
                System.out.println("Name: " + foundProduct.getProductName());
                System.out.println("Price: $" + foundProduct.getProductPrice());
            } else {
                System.out.println("No product found with name: " + searchTerm);
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Product Search System!");
    }

    public static Map<String, Product> loadInventory(String filePath) {

        HashMap<String, Product> inventoryMap = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                // Make sure we have all required data fields
                if (parts.length == 4) {
                    try {
                        // Extract and clean up each field
                        String sku = parts[0].trim();
                        String name = parts[1].trim();
                        double price = Double.parseDouble(parts[2].trim());

                        // Extract the department if available
                        String department = "";
                        if (parts.length >= 4) {
                            department = parts[3].trim();
                        }

                        // Create a new Product object
                        Product product = new Product(sku, name, price, department);
                        inventoryMap.put(name, product);

                    } catch (NumberFormatException e) {
                        // This catches errors parsing numbers
                        System.err.println("Error parsing line: " + line);
                    }
                }
                else {
                    System.err.println("Invalid line: " + line);
                }
            }

            reader.close();

        } catch (IOException e) {
            System.err.println("Error reading inventory file: " + e.getMessage());
            e.printStackTrace();
        }

        return inventoryMap;
    }
}
