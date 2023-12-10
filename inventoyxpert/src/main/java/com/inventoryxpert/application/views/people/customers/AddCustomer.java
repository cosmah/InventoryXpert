package com.inventoryxpert.application.views.people.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.inventoryxpert.application.backend.entity.Customer;
import com.inventoryxpert.application.backend.entity.Employee;
import com.inventoryxpert.application.backend.service.CustomerService;
import com.inventoryxpert.application.backend.service.EmployeeService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

@PageTitle("Add Customer")
@Route(value = "Customer", layout = MainLayout.class)
public class AddCustomer extends VerticalLayout {

    private final CustomerService customerService;
    private final EmployeeService employeeService;

    @Autowired
    public AddCustomer(CustomerService customerService, EmployeeService employeeService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        setSpacing(false);

        FormLayout formLayout = new FormLayout();
        TextField nameField = new TextField("Customer Name");
        TextField addressField = new TextField("Customer Address");
        TextField phoneField = new TextField("Customer Phone");
        TextField emailField = new TextField("Customer Email");
        ComboBox<Employee> contactPersonField = new ComboBox<>("Customer Contact Person");
        TextField tinField = new TextField("Customer Tin");

        // Fetch employees and set them as the items of the ComboBox
        List<Employee> employees = employeeService.findAll();
        contactPersonField.setItems(employees);
        // Define how to display the employees in the ComboBox
        contactPersonField.setItemLabelGenerator(Employee::getEmployeeName);

        Button button = new Button("Add Customer");
        formLayout.add(nameField, addressField, phoneField, emailField, contactPersonField, tinField, button);

        button.addClickListener(e -> {
            Employee selectedEmployee = contactPersonField.getValue();
            Customer customer = customerService.save(null, nameField.getValue(), addressField.getValue(),
                    phoneField.getValue(), emailField.getValue(), selectedEmployee, Integer.parseInt(tinField.getValue()));
            if (customer != null) {
                Notification.show("Customer Added");
            } else {
                Notification.show("Failed to add customer");
            }
        
            nameField.clear();
            addressField.clear();
            phoneField.clear();
            emailField.clear();
            contactPersonField.clear();
            tinField.clear();
        });

        add(formLayout);
    }

}