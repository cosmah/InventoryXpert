package com.inventoryxpert.application.views.people.customers;

import java.util.List;

import com.inventoryxpert.application.backend.entity.Customer;
import com.inventoryxpert.application.backend.service.CustomerService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Customers")
@CssImport("./themes/inventoryxpert/views/inventory.css")
@Route(value = "customers", layout = MainLayout.class)
public class Customers extends VerticalLayout{

    private Grid<Customer> grid = new Grid<>(Customer.class);
    private final CustomerService customerService;
    private TextField filterText = new TextField();

    public Customers(CustomerService customerService) {
        this.customerService = customerService;

        addClassNames("listView");
        setSizeFull();

        configureGrid();
        populateGrid();

        add(filterText, grid);
        updateList();
    }

    private void populateGrid() {
        List<Customer> customers = customerService.findAll();
        grid.setItems(customers);

        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateList() {
        List<Customer> customers = customerService.findAll(filterText.getValue());
        grid.setItems(customers);
    }

    private void configureGrid() {
        grid.addClassName("product-grid");
        grid.setSizeFull();

        grid.setColumns("customerName", 
        "customerEmail", "customerPhone", "customerAddress",
        "customerContactPerson");
    }
}