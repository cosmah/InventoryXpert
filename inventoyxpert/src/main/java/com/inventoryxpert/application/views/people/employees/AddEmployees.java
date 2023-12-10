package com.inventoryxpert.application.views.people.employees;

import java.time.ZoneId;
import java.util.Date;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

import com.inventoryxpert.application.backend.entity.Employee;
import com.inventoryxpert.application.backend.service.EmployeeService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.pro.licensechecker.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

@PageTitle("Add Employee")
@Route(value = "Employee", layout = MainLayout.class)
public class AddEmployees extends VerticalLayout {

    private final EmployeeService employeeService;

    @Autowired
    public AddEmployees(EmployeeService employeeService) {
        this.employeeService = employeeService;
        setSpacing(false);

        FormLayout formLayout = new FormLayout();
        TextField nameField = new TextField("Employee Name");
        TextField addressField = new TextField("Employee Address");
        TextField phoneField = new TextField("Employee Phone");
        TextField emailField = new TextField("Employee Email");
        TextField nextOfKinField = new TextField("Employee Next Of Kin");
        TextField nextOfKinPhoneField = new TextField("Employee Next Of Kin Phone");
        TextField nextOfKinAddressField = new TextField("Employee Next Of Kin Address");
        TextField nextOfKinRelationshipField = new TextField("Employee Next Of Kin Relationship");
        TextField nextOfKinOccupationField = new TextField("Employee Next Of Kin Occupation");
        //TextField nextOfKinGenderField = new TextField("Employee Next Of Kin Gender");
        ComboBox<String> nextOfKinGenderField = new ComboBox<>("Next of kin Gender");
        nextOfKinGenderField.setItems("Male", "Female", "Other");
        DatePicker dobField = new DatePicker("Employee Date Of Birth");
        // TextField employeeGenderField = new TextField("Employee Gender");
        ComboBox<String> employeeGenderField = new ComboBox<>("Employee Gender");
        employeeGenderField.setItems("Male", "Female", "Other");
        TextField employeeOccupationField = new TextField("Employee Occupation");
        //TextField employeeMaritalStatusField = new TextField("Employee Marital Status");
        ComboBox<String> employeeMaritalStatusField = new ComboBox<>("Employee Marital Status");
        employeeMaritalStatusField.setItems("Single", "Married", "Divorced", "Widowed", "Other");
        TextField employeeNationalityField = new TextField("Employee Nationality");
        TextField employeeStateOfOriginField = new TextField("Employee State Of Origin");
        TextField employeeTinField = new TextField("Employee Tin");

        Button button = new Button("Add Employee");
        formLayout.add(nameField, addressField, phoneField, emailField, nextOfKinField, nextOfKinPhoneField,
                nextOfKinAddressField, nextOfKinRelationshipField, nextOfKinOccupationField, nextOfKinGenderField,
                dobField, employeeGenderField, employeeOccupationField, employeeMaritalStatusField,
                employeeNationalityField, employeeStateOfOriginField, employeeTinField, button);
        // Date dob =
        // Date.from(dobField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

        button.addClickListener(e -> {
            Date dob = java.sql.Date.valueOf(dobField.getValue());

            int employeeTin;
            try {
                employeeTin = Integer.parseInt(employeeTinField.getValue());
            } catch (NumberFormatException ex) {
                Notification.show("Invalid TIN. Please enter a valid number.");
                return;
            }

            Employee employee = employeeService.save(
                    null, nameField.getValue(),
                    addressField.getValue(), phoneField.getValue(),
                    emailField.getValue(), nextOfKinField.getValue(),
                    nextOfKinPhoneField.getValue(), nextOfKinAddressField.getValue(),
                    nextOfKinRelationshipField.getValue(), nextOfKinOccupationField.getValue(),
                    nextOfKinGenderField.getValue(), dob, employeeGenderField.getValue(),
                    employeeOccupationField.getValue(), employeeMaritalStatusField.getValue(),
                    employeeNationalityField.getValue(), employeeStateOfOriginField.getValue(),
                    employeeTin);

            if (employee != null) {
                Notification.show("Employee Added");
            } else {
                Notification.show("Failed to add employee");
            }

            nameField.clear();
            addressField.clear();
            phoneField.clear();
            emailField.clear();
            nextOfKinField.clear();
            nextOfKinPhoneField.clear();
            nextOfKinAddressField.clear();
            nextOfKinRelationshipField.clear();
            nextOfKinOccupationField.clear();
            nextOfKinGenderField.clear();
            dobField.clear();
            employeeGenderField.clear();
            employeeOccupationField.clear();
            employeeMaritalStatusField.clear();
            employeeNationalityField.clear();
            employeeStateOfOriginField.clear();
            employeeTinField.clear();
        });

        add(formLayout);
    }

}
