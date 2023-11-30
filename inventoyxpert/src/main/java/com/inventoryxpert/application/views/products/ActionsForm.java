package com.inventoryxpert.application.views.products;
import com.inventoryxpert.application.backend.entity.Product;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.LocalDateToDateConverter;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.shared.Registration;
import java.util.List;


public class ActionsForm extends FormLayout {
        private Product product;
        private TextField nameField = new TextField("Product Name");
        private TextField codeField = new TextField("Product Code");
        private TextField descriptionField = new TextField("Product Description");
        private TextField quantityField = new TextField("Quantity");
        private TextField priceField = new TextField("Price");
        private TextField resalePriceField = new TextField("Resale price");
        private TextField supplierField = new TextField("Supplier");
        private DatePicker startingDateField = new DatePicker("Starting Date");
        private Button save = new Button("Save");
        private Button delete = new Button("Delete");
        private Button close = new Button("Cancel");
        private Binder<Product> binder = new Binder<>(Product.class);
        public ActionsForm(List<Product> all) {
                addClassName("contact-form");

                //binder.bindInstanceFields(this);

                // Add the explicit binding code here:

                binder.forField(nameField).asRequired().bind(Product::getProductName, Product::setProductName);
                binder.forField(codeField).asRequired().bind(Product::getProductCode, Product::setProductCode);
                binder.forField(descriptionField).bind(Product::getProductDescription, Product::setProductDescription);
                binder.forField(quantityField)
                        .asRequired()
                        .withConverter(
                                new StringToIntegerConverter("Must enter a number"))
                        .bind(Product::getQuantity, Product::setQuantity);
                binder.forField(priceField)
                        .asRequired()
                        .withConverter(
                                new StringToDoubleConverter("Must enter a number"))
                        .bind(Product::getPrice, Product::setPrice);
                binder.forField(resalePriceField)
                        .withConverter(
                                new StringToDoubleConverter("Must enter a number"))
                        .bind(Product::getResalePrice, Product::setResalePrice);
                binder.forField(supplierField).bind(Product::getSupplier, Product::setSupplier);
                binder.forField(startingDateField)
                        .asRequired()
                        .withConverter(
                                new LocalDateToDateConverter())
                        .bind(Product::getStartingDate, Product::setStartingDate);
                add(nameField, codeField, descriptionField, quantityField, priceField,
                        resalePriceField, supplierField, startingDateField,
                        createButtonsLayout());
        }
        private Component createButtonsLayout() {
                save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
                delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
                close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                save.addClickShortcut(Key.ENTER);
                close.addClickShortcut(Key.ESCAPE);

                save.addClickListener(event -> validateAndSave());
                delete.addClickListener(event -> fireEvent(new DeleteEvent(this, product)));
                close.addClickListener(event -> fireEvent(new CloseEvent(this)));

                binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

                return new HorizontalLayout(save, delete, close);
        }
        public void setProduct(Product product) {
                this.product = product;
                binder.setBean(product);
            }
        public static abstract class ActionsFormEvent extends ComponentEvent<ActionsForm> {
                private Product product;
                protected ActionsFormEvent(ActionsForm source, Product product) {
                        super(source, false);
                        this.product = product;
                }
                public Product getProduct() {
                        return product;
                }
        }
        public static class SaveEvent extends ActionsFormEvent {
                SaveEvent(ActionsForm source, Product product) {
                        super(source, product);
                }
        }
        public static class DeleteEvent extends ActionsFormEvent {
                DeleteEvent(ActionsForm source, Product product) {
                        super(source, product);
                }
        }
        public static class CloseEvent extends ActionsFormEvent {
                CloseEvent(ActionsForm source) {
                        super(source, null);
                }
        }
        public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                      ComponentEventListener<T> listener) {
                return getEventBus().addListener(eventType, listener);
        }
        private void validateAndSave() {
                try {
                        binder.writeBean(product);
                        fireEvent(new SaveEvent(this, product));
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
