package com.inventoryxpert.application.views.products;

import com.inventoryxpert.application.backend.entity.Product;
import com.inventoryxpert.application.backend.service.ProductService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Binder.BindingBuilder;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageTitle("Products")
@CssImport("./themes/inventoryxpert/views/inventory.css")
@Route(value = "inventory", layout = MainLayout.class)
public class Inventory extends VerticalLayout {

    private Grid<Product> grid = new Grid<>(Product.class);
    private final ProductService productService;
    private TextField filterText = new TextField();
    //private Binder<Product> binder = new Binder<>(Product.class);
    private ActionsForm form;

    @Autowired
    public Inventory(ProductService productService) {
        this.productService = productService;

        addClassNames("listView");
        setSizeFull();

        configureFilter();
        configureGrid();

        // Create the ActionsForm instance
        form = new ActionsForm(productService.findAll());

        // Add event listeners to the ActionsForm
        form.addListener(ActionsForm.SaveEvent.class, this::saveProduct);
        form.addListener(ActionsForm.DeleteEvent.class, this::deleteProduct);
        form.addListener(ActionsForm.CloseEvent.class, e -> closeEditor());

        // Fetch data from ProductService and set it in the grid
        populateGrid();

        // Add the form and grid to the layout
        Div content = new Div(grid, form);
        content.addClassName("content");
        content.setSizeFull();
        add(filterText, content);

        updateList();
        closeEditor();
    }

    private void deleteProduct(ActionsForm.DeleteEvent event) {
        productService.delete(event.getProduct());
        updateList();
        closeEditor();

    }

    //saveContact method
    private void saveProduct(ActionsForm.SaveEvent event) {
        productService.save(event.getProduct());
        updateList();
        closeEditor();
    }


    private void updateList() {
        List<Product> products = productService.findAll(filterText.getValue());
        grid.setItems(products);
    }

    private void configureFilter() {
        filterText.setPlaceholder("Filter products");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());
    }

    private void configureGrid() {
        grid.addClassName("product-grid");
        grid.setSizeFull();

        grid.setColumns("productCode", "productName", "quantity",
                "price", "resalePrice", "supplier");

        grid.asSingleSelect().addValueChangeListener(event ->
                editProduct(event.getValue()));
    }

    private void editProduct(Product product) {
        if (product == null) {
            closeEditor();
        } else {
            form.setProduct(product);
            form.setVisible(true);
            addClassName("editing");

        }
    }

    private void closeEditor() {
        form.setProduct(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void populateGrid() {
        // Fetch the list of products from the ProductService
        // Replace findAll() with your method to retrieve products
        // Ensure your ProductService fetches data correctly from the repository
        List<Product> productList = productService.findAll();

        // Set the fetched data in the grid
        grid.setItems(productList);

        //configure size
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
