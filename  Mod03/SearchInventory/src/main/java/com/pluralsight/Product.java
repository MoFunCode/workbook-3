package com.pluralsight;

public class Product {

    private String productName;
    private int productId;
    private double productPrice;
    private String productOrigin;

    // Constructor to initialize the product's details
    public Product(String productName, int productId, double productPrice, String productOrigin) {
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productOrigin = productOrigin;
    }

    // Getters and setters for product attributes
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductOrigin() {
        return productOrigin;
    }

    public void setProductOrigin(String productOrigin) {
        this.productOrigin = productOrigin;
    }

}

