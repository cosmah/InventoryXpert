package com.inventoryxpert.application.views.Invoicing;

import com.vaadin.flow.component.textfield.NumberField;
import com.inventoryxpert.application.backend.entity.InvoiceLine;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.data.converter.Converter;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;

@Route(value = "Purchase", layout = MainLayout.class)
public class Purchase extends VerticalLayout {
    private Grid<InvoiceLine> grid = new Grid<>(InvoiceLine.class);
    private Binder<InvoiceLine> binder = new Binder<>(InvoiceLine.class);

    public Purchase() {
        add(grid);
        configureGrid();
    }

    private void configureGrid() {
        Editor<InvoiceLine> editor = grid.getEditor();
        editor.setBinder(binder);

        TextField productCodeField = new TextField();
        binder.bind(productCodeField, InvoiceLine::getProductCode, InvoiceLine::setProductCode);
        grid.addColumn(InvoiceLine::getProductCode).setHeader("Product Code").setEditorComponent(productCodeField);

        TextField productNameField = new TextField();
        binder.bind(productNameField, InvoiceLine::getProductName, InvoiceLine::setProductName);
        grid.addColumn(InvoiceLine::getProductName).setHeader("Product Name").setEditorComponent(productNameField);

        TextField productDescriptionField = new TextField();
        binder.bind(productDescriptionField, InvoiceLine::getProductDescription, InvoiceLine::setProductDescription);
        grid.addColumn(InvoiceLine::getProductDescription).setHeader("Product Description")
                .setEditorComponent(productDescriptionField);

        NumberField quantityField = new NumberField();
        binder.forField(quantityField)
                .withConverter(
                        new Converter<Double, Integer>() {
                            @Override
                            public Result<Integer> convertToModel(Double fieldValue, ValueContext context) {
                                if (fieldValue == null) {
                                    return Result.ok(null);
                                } else {
                                    return Result.ok(fieldValue.intValue());
                                }
                            }

                            @Override
                            public Double convertToPresentation(Integer modelValue, ValueContext context) {
                                if (modelValue == null) {
                                    return null;
                                } else {
                                    return Double.valueOf(modelValue);
                                }
                            }
                        })
                .bind(InvoiceLine::getQuantity, InvoiceLine::setQuantity);
        grid.addColumn(InvoiceLine::getQuantity).setHeader("Quantity").setEditorComponent(quantityField);
        
        NumberField unitPriceField = new NumberField();
        binder.forField(unitPriceField)
            .bind(InvoiceLine::getUnitPrice, InvoiceLine::setUnitPrice);
        grid.addColumn(InvoiceLine::getUnitPrice).setHeader("Unit Price").setEditorComponent(unitPriceField);
        
        NumberField totalPriceField = new NumberField();
        binder.forField(totalPriceField)
            .bind(InvoiceLine::getTotalPrice, InvoiceLine::setTotalPrice);
        grid.addColumn(InvoiceLine::getTotalPrice).setHeader("Total Price").setEditorComponent(totalPriceField);
        grid.addItemDoubleClickListener(event -> {
            editor.editItem(event.getItem());
        });

        editor.addCloseListener(event -> {
            if (editor.isBuffered()) {
                editor.save();
                // Save the updated item to the database here
            }
        });
    }
}