package com.inventoryxpert.application.backend.entity;


import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee customerContactPerson;
    private int customerTin;

    public Customer() {
    }

    public Customer(Long id, String customerName, String customerAddress, String customerPhone, String customerEmail, Employee customerContactPerson, int customerTin) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerContactPerson = customerContactPerson;
        this.customerTin = customerTin;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Employee getCustomerContactPerson() {
        return customerContactPerson;
    }

    public int getCustomerTin() {
        return customerTin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerContactPerson(Employee customerContactPerson) {
        this.customerContactPerson = customerContactPerson;
    }

    public void setCustomerTin(int customerTin) {
        this.customerTin = customerTin;
    }

    @Override
public String toString() {
    return "Customer{" +
            "id=" + id +
            ", customerName='" + customerName +
            ", customerAddress='" + customerAddress +
            ", customerPhone='" + customerPhone +
            ", customerEmail='" + customerEmail +
            ", customerContactPerson='" + (customerContactPerson != null ? customerContactPerson.getEmployeeName() : null) +
            ", customerTin='" + customerTin +
            '}';
}

}
