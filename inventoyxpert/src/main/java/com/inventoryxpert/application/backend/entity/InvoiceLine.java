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

   @ManyToOne
   @JoinColumn(name = "invoice_id")
   private Invoice invoice;

   public InvoiceLine() {
   }

   public InvoiceLine(Long id, String productName, String productCode, String productDescription, Integer quantity, Double unitPrice, Double totalPrice, Invoice invoice) {
       this.id = id;
       this.productName = productName;
       this.productCode = productCode;
       this.productDescription = productDescription;
       this.quantity = quantity;
       this.unitPrice = unitPrice;
       this.totalPrice = totalPrice;
       this.invoice = invoice;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }   
}
