package com.pluralsight;

import java.util.ArrayList;

public class SearchInventory {

    public static void main(String[] args) {

        // Step 1: Create a new ArrayList to store Product objects
        ArrayList<Product> products = new ArrayList<>();

        Product product1 = new Product("Handwoven Basket", 11, 45.99, "Kenya");
        Product product2 = new Product("Wooden Elephant Sculpture", 12, 79.99, "South Africa");
        Product product3 = new Product("African Beaded Necklace", 13, 30.00, "Nigeria");
        Product product4 = new Product("Kente Cloth Scarf", 14, 55.00, "Ghana");
        Product product5 = new Product("Zulu Beaded Earrings", 15, 25.50, "South Africa");

        // Adding products to the inventory list
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        // Step 3: Display the inventory (print the list of products)
        System.out.println("Inventory:");
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Name: " + product.getProductName());
            System.out.println("Price: $" + product.getProductPrice());
            System.out.println("Origin: " + product.getProductOrigin());
            System.out.println();
        }

        // Step 4: Check if a specific product exists in the inventory by ID
        int searchProductId = 11; // Searching for the product with ID 11 (Handwoven Basket)
        boolean found = false; // Flag to check if product is found

        // Loop through the products to find a match by ID
        for (Product product : products) {
            if (product.getProductId() == searchProductId) {
                // Manually printing the found product's details
                System.out.println("\nProduct found:");
                System.out.println("Product ID: " + product.getProductId());
                System.out.println("Name: " + product.getProductName());
                System.out.println("Price: $" + product.getProductPrice());
                System.out.println("Origin: " + product.getProductOrigin());
                found = true; // Mark as found
                break; // Exit the loop as we found the product
            }
        }

        // If the product was not found, print this message
        if (!found) {
            System.out.println("\nProduct with ID " + searchProductId + " not found.");
        }
    }
}
