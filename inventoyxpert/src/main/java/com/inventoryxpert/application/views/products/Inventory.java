package com.inventoryxpert.application.views.products;

import com.inventoryxpert.application.backend.entity.Product;
import com.inventoryxpert.application.backend.service.ProductService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageTitle("Products")
@Route(value = "inventory", layout = MainLayout.class)
public class Inventory extends VerticalLayout {

    private Grid<Product> grid = new Grid<>(Product.class);
    private final ProductService productService;

    @Autowired
    public Inventory(ProductService productService) {
        this.productService = productService;

        addClassNames("listView");
        setSizeFull();
        configureGrid();

        add(grid);

        // Fetch data from ProductService and set it in the grid
        populateGrid();
    }

    private void configureGrid() {
        grid.addClassName("product-grid");
        grid.setSizeFull();

        grid.setColumns("productCode", "productName", "quantity",
                "price", "resalePrice", "supplier");
    }

    private void populateGrid() {
        // Fetch the list of products from the ProductService
        // Replace findAll() with your method to retrieve products
        // Ensure your ProductService fetches data correctly from the repository
        List<Product> productList = productService.findAll();

        // Set the fetched data in the grid
        grid.setItems(productList);
    }
}
