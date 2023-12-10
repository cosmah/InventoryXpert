package com.inventoryxpert.application.views.dashboard;


import java.util.List;

import com.inventoryxpert.application.backend.entity.Product;
import com.inventoryxpert.application.backend.service.ProductService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.BoxSizing;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

@PageTitle("Dashboard | InventoryXpert")
@Route(value = "dashboard", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class DashboardView extends Main {

    private ProductService productService;

    public DashboardView(ProductService productService) {
        addClassName("dashboard-view");
        this.productService = productService;

        // Create a new VerticalLayout
        VerticalLayout layout = new VerticalLayout();
        layout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        // Create a header
        H1 header = new H1("Inventory Analysis");
        layout.add(header);

        // Create a new Chart object
        Chart chart = new Chart(ChartType.PIE);

        // Get the Configuration object
        Configuration conf = chart.getConfiguration();

        // Create a new DataSeries object
        DataSeries dataSeries = new DataSeries();

        // Get all products from the ProductService
        List<Product> products = productService.findAll();

        // Add a DataSeriesItem for each product
        for (Product product : products) {
            dataSeries.add(new DataSeriesItem(product.getProductName(), product.getQuantity()));
        }

        // Add the DataSeries to the Configuration
        conf.setSeries(dataSeries);

        // Add the Chart to the layout
        layout.add(chart);

        // Create a VerticalLayout for the figures
        VerticalLayout figuresLayout = new VerticalLayout();

        // Add the total stock per item to the figuresLayout
        for (Product product : products) {
            figuresLayout.add(new Span(product.getProductName() + ": " + product.getQuantity()));
        }

        // Create a new HorizontalLayout for the entire view
        HorizontalLayout viewLayout = new HorizontalLayout();

        // Add the layout and the figuresLayout to the viewLayout
        viewLayout.add(layout, figuresLayout);

        // Add the viewLayout to the view
        add(viewLayout);
    }
}