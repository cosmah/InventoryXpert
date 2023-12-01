package com.inventoryxpert.application.views.people.customers;

import com.inventoryxpert.application.backend.service.CustomerService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@PageTitle("Add Customer")
@Route(value = "Customer", layout = MainLayout.class)
public class AddCustomer extends VerticalLayout{
private final CustomerService customerService;


    
}
