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

public class Product {
    private String productId;        // SKU like "AV1051"
    private String productName;      // Product name
    private double productPrice;     // Product price
    private String department;       // Department name

    // Constructor with all fields
    public Product(String productId, String productName, double productPrice, String department) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.department = department;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
