package com.inventoryxpert.application.views.people.customers;

import java.util.List;

import com.inventoryxpert.application.backend.entity.Customer;
import com.inventoryxpert.application.backend.service.CustomerService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
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
    private ActionsForm form;

    public Customers(CustomerService customerService) {
        this.customerService = customerService;

        addClassNames("listView");
        setSizeFull();

        configureGrid();
        populateGrid();

        form = new ActionsForm(customerService.findAll());

        form.addListener(ActionsForm.SaveEvent.class, this::saveCustomer);
        form.addListener(ActionsForm.DeleteEvent.class, this::deleteCustomer);
        form.addListener(ActionsForm.CloseEvent.class, e -> closeEditor());

        Div content = new Div(grid, form);
        content.addClassName("content");

        add(filterText, content);
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

        grid.asSingleSelect().addValueChangeListener(evt -> editCustomer(evt.getValue()));
    }

    private void deleteCustomer(ActionsForm.DeleteEvent event) {
        customerService.delete(event.getCustomer());
        updateList();
        closeEditor();
    }

    private void saveCustomer(ActionsForm.SaveEvent event) {
        customerService.save(event.getCustomer());
        updateList();
        closeEditor();
    }

    private void closeEditor() {
        form.setCustomer(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void editCustomer(Customer customer) {
        if (customer == null) {
            closeEditor();
        } else {
            form.setCustomer(customer);
            form.setVisible(true);
            addClassName("editing");
        }
    }


}