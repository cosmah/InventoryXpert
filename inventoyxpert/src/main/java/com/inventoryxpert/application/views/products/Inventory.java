package com.inventoryxpert.application.views.products;


import com.inventoryxpert.application.backend.entity.Product;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Products")
@Route(value = "inventory", layout = MainLayout.class)
public class Inventory extends VerticalLayout {

    private Grid<Product> grid = new Grid<>(Product.class);

    public Inventory(){
        addClassNames("listView");
        setSizeFull();
        configureGrid();

        add(grid);
    }

    private void configureGrid() {
        grid.addClassName("product-grid");
        grid.setSizeFull();

        grid.addColumn(Product::getProductCode).setHeader("Product Code");
        grid.addColumn(Product::getProductName).setHeader("Product Name");
        //grid.addColumn(Product::getProductDescription).setHeader("Description");
        grid.addColumn(Product::getSupplier).setHeader("Supplier");
        grid.addColumn(Product::getQuantity).setHeader("Quantity");
        grid.addColumn(Product::getPrice).setHeader("Price");
        grid.addColumn(Product::getResalePrice).setHeader("Resale Price");

    }




}
