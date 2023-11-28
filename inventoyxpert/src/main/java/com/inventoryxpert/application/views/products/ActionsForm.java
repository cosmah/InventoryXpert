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
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

import java.util.List;

public class ActionsForm extends FormLayout {

        private Product product;

        TextField nameField = new TextField("Product Name");
        TextField codeField = new TextField("Product Code");
        TextField descriptionField = new TextField("Product Description");
        TextField quantityField = new TextField("Quantity");
        TextField priceField = new TextField("Price");
        TextField resalePriceField = new TextField("Resale price");
        TextField supplierField = new TextField("Supplier");
        DatePicker startingDateField = new DatePicker("Starting Date");

        Button save = new Button("Save");
        Button delete = new Button("Delete");
        Button close = new Button("Cancel");

        //DATA BINDER
        private Binder<Product> binder = new BeanValidationBinder<>(Product.class);

        public ActionsForm(List<Product> all){
            addClassName("contact-form");

            binder.bindInstanceFields(this);
            add(nameField, codeField,descriptionField, quantityField,priceField,
                    resalePriceField,supplierField,startingDateField,
                    createButtonsLayout());
        }

        //saving, deleting, and closing the form
        private Component createButtonsLayout() {
                save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
                delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
                close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                save.addClickShortcut(Key.ENTER);
                close.addClickShortcut(Key.ESCAPE);

                // The save button calls the validateAndSave method
                save.addClickListener(event -> validateAndSave());
                // The delete button fires a delete event and passes the currently-edited contact
                delete.addClickListener(event -> fireEvent(new DeleteEvent(this, binder.getBean())));
                // The cancel button fires a close event.
                close.addClickListener(event -> fireEvent(new CloseEvent(this)));
                // Validates the form every time it changes. If it is invalid, it disables the save button to
                // avoid invalid submissions
                binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

                return new HorizontalLayout(save, delete, close);
        }


        public void setProduct(Product product) {
                this.product = product;
                binder.readBean(product);
        }


        // Events
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
        // The addListener method uses Vaadin’s event bus to register the custom event types
        public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                      ComponentEventListener<T> listener) {
                return getEventBus().addListener(eventType, listener);
        }



        private void validateAndSave() {
                try {
                        //⑤ Write the form contents back to the original contact.
                        binder.writeBean(product);
                        //⑥ Fire a save event so the parent component can handle the action.
                        fireEvent(new SaveEvent(this, product));
                } catch (ValidationException e) {
                        e.printStackTrace();
                }
        }


}
