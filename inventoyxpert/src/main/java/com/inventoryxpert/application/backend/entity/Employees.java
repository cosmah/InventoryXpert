package com.inventoryxpert.application.backend.entity;

import java.util.Date;

import com.github.javaparser.ast.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeName;
    private String employeeAddress;
    private String employeePhone;
    private String employeeEmail;
    private String employeeNextOfKin;
    private String employeeNextOfKinPhone;
    private String employeeNextOfKinAddress;
    private String employeeNextOfKinRelationship;
    private String employeeNextOfKinOccupation;
    private String employeeNextOfKinGender;
    private Date   employeeDateOfBirth;
    private String employeeGender;
    private String employeeOccupation;
    private String employeeMaritalStatus;
    private String employeeNationality;
    private String employeeStateOfOrigin;
    private int    employeeTin;

    public Employees(Long id, String employeeName, String employeeAddress, String employeePhone, String employeeEmail,
                     String employeeNextOfKin, String employeeNextOfKinPhone, String employeeNextOfKinAddress,
                     String employeeNextOfKinRelationship, String employeeNextOfKinOccupation, String employeeNextOfKinGender,
                     Date employeeDateOfBirth, String employeeGender, String employeeOccupation, String employeeMaritalStatus,
                     String employeeNationality, String employeeStateOfOrigin, int employeeTin) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeNextOfKin = employeeNextOfKin;
        this.employeeNextOfKinPhone = employeeNextOfKinPhone;
        this.employeeNextOfKinAddress = employeeNextOfKinAddress;
        this.employeeNextOfKinRelationship = employeeNextOfKinRelationship;
        this.employeeNextOfKinOccupation = employeeNextOfKinOccupation;
        this.employeeNextOfKinGender = employeeNextOfKinGender;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeGender = employeeGender;
        this.employeeOccupation = employeeOccupation;
        this.employeeMaritalStatus = employeeMaritalStatus;
        this.employeeNationality = employeeNationality;
        this.employeeStateOfOrigin = employeeStateOfOrigin;
        this.employeeTin = employeeTin;
    }

    public Employees() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeNextOfKin() {
        return employeeNextOfKin;
    }

    public void setEmployeeNextOfKin(String employeeNextOfKin) {
        this.employeeNextOfKin = employeeNextOfKin;
    }

    public String getEmployeeNextOfKinPhone() {
        return employeeNextOfKinPhone;
    }

    public void setEmployeeNextOfKinPhone(String employeeNextOfKinPhone) {
        this.employeeNextOfKinPhone = employeeNextOfKinPhone;
    }

    public String getEmployeeNextOfKinAddress() {
        return employeeNextOfKinAddress;
    }

    public void setEmployeeNextOfKinAddress(String employeeNextOfKinAddress) {
        this.employeeNextOfKinAddress = employeeNextOfKinAddress;
    }

    public String getEmployeeNextOfKinRelationship() {
        return employeeNextOfKinRelationship;
    }

    public void setEmployeeNextOfKinRelationship(String employeeNextOfKinRelationship) {
        this.employeeNextOfKinRelationship = employeeNextOfKinRelationship;
    }

    public String getEmployeeNextOfKinOccupation() {
        return employeeNextOfKinOccupation;
    }

    public void setEmployeeNextOfKinOccupation(String employeeNextOfKinOccupation) {
        this.employeeNextOfKinOccupation = employeeNextOfKinOccupation;
    }

    public String getEmployeeNextOfKinGender() {
        return employeeNextOfKinGender;
    }

    public void setEmployeeNextOfKinGender(String employeeNextOfKinGender) {
        this.employeeNextOfKinGender = employeeNextOfKinGender;
    }

    public Date getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(Date employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeOccupation() {
        return employeeOccupation;
    }

    public void setEmployeeOccupation(String employeeOccupation) {
        this.employeeOccupation = employeeOccupation;
    }

    public String getEmployeeMaritalStatus() {
        return employeeMaritalStatus;
    }

    public void setEmployeeMaritalStatus(String employeeMaritalStatus) {
        this.employeeMaritalStatus = employeeMaritalStatus;
    }

    public String getEmployeeNationality() {
        return employeeNationality;
    }

    public void setEmployeeNationality(String employeeNationality) {
        this.employeeNationality = employeeNationality;
    }

    public String getEmployeeStateOfOrigin() {
        return employeeStateOfOrigin;
    }

    public void setEmployeeStateOfOrigin(String employeeStateOfOrigin) {
        this.employeeStateOfOrigin = employeeStateOfOrigin;
    }

    public int getEmployeeTin() {
        return employeeTin;
    }

    public void setEmployeeTin(int employeeTin) {
        this.employeeTin = employeeTin;
    }


    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeNextOfKin='" + employeeNextOfKin + '\'' +
                ", employeeNextOfKinPhone='" + employeeNextOfKinPhone + '\'' +
                ", employeeNextOfKinAddress='" + employeeNextOfKinAddress + '\'' +
                ", employeeNextOfKinRelationship='" + employeeNextOfKinRelationship + '\'' +
                ", employeeNextOfKinOccupation='" + employeeNextOfKinOccupation + '\'' +
                ", employeeNextOfKinGender='" + employeeNextOfKinGender + '\'' +
                ", employeeDateOfBirth=" + employeeDateOfBirth +
                ", employeeGender='" + employeeGender + '\'' +
                ", employeeOccupation='" + employeeOccupation + '\'' +
                ", employeeMaritalStatus='" + employeeMaritalStatus + '\'' +
                ", employeeNationality='" + employeeNationality + '\'' +
                ", employeeStateOfOrigin='" + employeeStateOfOrigin + '\'' +
                ", employeeTin=" + employeeTin +
                '}';
    }
}
