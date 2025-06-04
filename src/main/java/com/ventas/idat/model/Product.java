package com.ventas.idat.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

//@Entity
@Document(collection = "products")
public class Product {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Product() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        String var10000 = String.valueOf(this.id);
        return "Product [id=" + var10000 + ", name=" + this.name + ", description=" + this.description + ", price="
                + this.price + ", stock=" + this.stock + "]";
    }
}
