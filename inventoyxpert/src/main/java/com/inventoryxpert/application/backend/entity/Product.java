package com.inventoryxpert.application.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String productCode;
    private String productDescription;
    private String price;
    private String quantity;
    private Date startingDate;
    private String supplier;

    public Product(){
    }

    public Product(Long id, String productName, String productCode, String productDescription, String price, String quantity, Date startingDate, String supplier) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = quantity;
        this.startingDate = startingDate;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
