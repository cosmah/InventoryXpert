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
    private Double price;
    private Integer quantity;
    private Date startingDate;
    private String supplier;
    private Double resalePrice;

    public Product(){
    }

    public Product(Long id, String productName, String productCode, String productDescription, Double price,Double resalePrice, Integer quantity, Date startingDate, String supplier) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.price = price;
        this.resalePrice = resalePrice;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
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

    public Double getResalePrice(Double aDouble) {
        return resalePrice;
    }

    public void setResalePrice(Double resalePrice) {
        this.resalePrice = resalePrice;
    }
}
