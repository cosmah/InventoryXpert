package com.inventoryxpert.application.views.people.customers;

import java.util.List;
import com.vaadin.flow.component.combobox.ComboBox;
import com.inventoryxpert.application.backend.entity.Employee;
import com.inventoryxpert.application.backend.service.EmployeeService;
import com.inventoryxpert.application.backend.entity.Customer;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;

public class ActionsForm extends FormLayout {
    private Customer customer;
    private EmployeeService employeeService;
    private Employee employee;

    private TextField nameField = new TextField("Customer Name");
    private TextField emailField = new TextField("Customer Email");
    private TextField phoneField = new TextField("Customer Phone");
    private TextField addressField = new TextField("Customer Address");
    private ComboBox<Employee> contactPersonField = new ComboBox<>("Customer Contact Person");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button close = new Button("Cancel");

    private Binder<Customer> binder = new Binder<>(Customer.class);

    public ActionsForm(List<Customer> all, EmployeeService employeeService) {
        addClassName("contact-form");
        /// Fetch the list of employees from the database and set it as the items of the
        /// ComboBox
        List<Employee> employees = employeeService.findAll();
        contactPersonField.setItems(employees);
        contactPersonField.setItemLabelGenerator(Employee::getEmployeeName);

        // Add the explicit binding code here:

        binder.forField(nameField)
                .withNullRepresentation("")
                .asRequired()
                .bind(Customer::getCustomerName, Customer::setCustomerName);

        binder.forField(emailField)
                .withNullRepresentation("")
                .asRequired()
                .bind(Customer::getCustomerEmail, Customer::setCustomerEmail);

        binder.forField(phoneField)
                .withNullRepresentation("")
                .bind(Customer::getCustomerPhone, Customer::setCustomerPhone);

        binder.forField(addressField)
                .withNullRepresentation("")
                .bind(Customer::getCustomerAddress, Customer::setCustomerAddress);

        binder.forField(contactPersonField)
                .bind(Customer::getCustomerContactPerson, Customer::setCustomerContactPerson);

        binder.bindInstanceFields(this);

        add(
                nameField,
                emailField,
                phoneField,
                addressField,
                contactPersonField,
                createButtonsLayout());
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, customer)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(customer);
            fireEvent(new SaveEvent(this, customer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        binder.setBean(customer);
    }

    public static abstract class ActionsFormEvent extends ComponentEvent<ActionsForm> {
        private Customer customer;

        protected ActionsFormEvent(ActionsForm source, Customer customer) {
            super(source, false);
            this.customer = customer;
        }

        public Customer getCustomer() {
            return customer;
        }
    }

    public static class SaveEvent extends ActionsFormEvent {
        SaveEvent(ActionsForm source, Customer customer) {
            super(source, customer);
        }
    }

    public static class DeleteEvent extends ActionsFormEvent {
        DeleteEvent(ActionsForm source, Customer customer) {
            super(source, customer);
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

}
