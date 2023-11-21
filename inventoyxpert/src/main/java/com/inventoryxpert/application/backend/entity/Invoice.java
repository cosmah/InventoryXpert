package com.inventoryxpert.application.backend.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String invoiceNumber;

    @Temporal(TemporalType.DATE)
    private Date invoiceDate;

    private String customerName;
    private String customerAddress;

    private Double totalAmount;

    private String paymentTerms;

    public Invoice(Long id, String invoiceNumber, Date invoiceDate, String customerName, String customerAddress, Double totalAmount, String paymentTerms) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.totalAmount = totalAmount;
        this.paymentTerms = paymentTerms;
    }


    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }



}