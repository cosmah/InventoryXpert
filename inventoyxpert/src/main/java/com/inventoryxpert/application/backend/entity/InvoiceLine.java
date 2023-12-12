package com.inventoryxpert.application.backend.entity;

import jakarta.persistence.*;

@Entity
public class InvoiceLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;
    private String productCode;
    private String productDescription;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;

    // Default constructor
    public InvoiceLine() {
    }

    public InvoiceLine(Long id, String productName, String productCode, String productDescription, Integer quantity, Double unitPrice, Double totalPrice) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    // Getters and setters...

    @Override
    public String toString() {
        return "InvoiceLine{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}