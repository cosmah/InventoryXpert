package com.inventoryxpert.application.views.people.employees;

import java.util.List;

import com.inventoryxpert.application.backend.entity.Employee;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

public class ActionsForm extends FormLayout {

        private Employee employee;

        private TextField nameField = new TextField("Employee Name");
        private TextField addressField = new TextField("Employee Address");
        private TextField phoneField = new TextField("Employee Phone");
        private TextField emailField = new TextField("Employee Email");
        private TextField nextOfKinField = new TextField("Employee Next Of Kin");
        private TextField nextOfKinPhoneField = new TextField("Employee Next Of Kin Phone");
        private TextField nextOfKinAddressField = new TextField("Employee Next Of Kin Address");
        private TextField nextOfKinRelationshipField = new TextField("Employee Next Of Kin Relationship");
        private TextField nextOfKinOccupationField = new TextField("Employee Next Of Kin Occupation");
        // TextField nextOfKinGenderField = new TextField("Employee Next Of Kin
        // Gender");
        private ComboBox<String> nextOfKinGenderField = new ComboBox<>("Next of kin Gender");

        private DatePicker dobField = new DatePicker("Employee Date Of Birth");
        // TextField employeeGenderField = new TextField("Employee Gender");
        private ComboBox<String> employeeGenderField = new ComboBox<>("Employee Gender");

        private TextField employeeOccupationField = new TextField("Employee Occupation");
        // TextField employeeMaritalStatusField = new TextField("Employee Marital
        // Status");
        private ComboBox<String> employeeMaritalStatusField = new ComboBox<>("Employee Marital Status");

        private TextField employeeNationalityField = new TextField("Employee Nationality");
        private TextField employeeStateOfOriginField = new TextField("Employee State Of Origin");
        private TextField employeeTinField = new TextField("Employee Tin");

        private Button save = new Button("Save");
        private Button delete = new Button("Delete");
        private Button close = new Button("Cancel");

        private Binder<Employee> binder = new Binder<>(Employee.class);

        public ActionsForm(List<Employee> all) {
                addClassName("contact-form");
                nextOfKinGenderField.setItems("Male", "Female", "Other");
                employeeGenderField.setItems("Male", "Female", "Other");
                employeeMaritalStatusField.setItems("Single", "Married", "Divorced", "Widowed", "Other");

                binder.forField(nameField).withNullRepresentation("").asRequired().bind(Employee::getEmployeeName,
                                Employee::setEmployeeName);
                binder.forField(addressField).withNullRepresentation("").asRequired().bind(Employee::getEmployeeAddress,
                                Employee::setEmployeeAddress);
                binder.forField(phoneField).withNullRepresentation("").asRequired().bind(Employee::getEmployeePhone,
                                Employee::setEmployeePhone);
                binder.forField(emailField).withNullRepresentation("").asRequired().bind(Employee::getEmployeeEmail,
                                Employee::setEmployeeEmail);
                binder.forField(nextOfKinField).withNullRepresentation("").asRequired().bind(
                                Employee::getEmployeeNextOfKin,
                                Employee::setEmployeeNextOfKin);
                binder.forField(nextOfKinPhoneField).withNullRepresentation("").asRequired().bind(
                                Employee::getEmployeeNextOfKinPhone,
                                Employee::setEmployeeNextOfKinPhone);
                binder.forField(nextOfKinAddressField).withNullRepresentation("").asRequired().bind(
                                Employee::getEmployeeNextOfKinAddress,
                                Employee::setEmployeeNextOfKinAddress);
                binder.forField(nextOfKinRelationshipField).withNullRepresentation("").asRequired().bind(
                                Employee::getEmployeeNextOfKinRelationship,
                                Employee::setEmployeeNextOfKinRelationship);
                binder.forField(nextOfKinOccupationField).withNullRepresentation("").asRequired().bind(
                                Employee::getEmployeeNextOfKinOccupation,
                                Employee::setEmployeeNextOfKinOccupation);
                binder.forField(nextOfKinGenderField).withNullRepresentation("").asRequired().bind(
                                Employee::getEmployeeNextOfKinGender,
                                Employee::setEmployeeNextOfKinGender);
                binder.forField(dobField)
                                .withNullRepresentation(null)
                                .asRequired()
                                .bind(Employee::getEmployeeDateOfBirth, Employee::setEmployeeDateOfBirth);
                binder.forField(employeeGenderField).withNullRepresentation("").asRequired().bind(
                                Employee::getEmployeeGender,
                                Employee::setEmployeeGender);
                binder.forField(employeeOccupationField).withNullRepresentation("").asRequired().bind(
                                Employee::getEmployeeOccupation,
                                Employee::setEmployeeOccupation);
                binder.forField(employeeMaritalStatusField).withNullRepresentation("").asRequired().bind(
                                Employee::getEmployeeMaritalStatus,
                                Employee::setEmployeeMaritalStatus);
                binder.forField(employeeNationalityField).withNullRepresentation("").asRequired().bind(
                                Employee::getEmployeeNationality,
                                Employee::setEmployeeNationality);
                binder.forField(employeeStateOfOriginField).withNullRepresentation("").asRequired().bind(
                                Employee::getEmployeeStateOfOrigin,
                                Employee::setEmployeeStateOfOrigin);
                                binder.forField(employeeTinField)
                                .withNullRepresentation("")
                                .withConverter(
                                    str -> str.isEmpty() ? null : Integer.parseInt(str), // Converts the String from the field to an Integer for the Employee object
                                    integer -> integer == null ? "" : String.valueOf(integer) // Converts the Integer from the Employee object to a String for the field
                                )
                                .bind(Employee::getEmployeeTin, Employee::setEmployeeTin);
                
                
                                // Add the fields to the form layout
                add(nameField, addressField, phoneField, emailField, nextOfKinField, nextOfKinPhoneField,
                                nextOfKinAddressField,
                                nextOfKinRelationshipField, nextOfKinOccupationField, nextOfKinGenderField, dobField,
                                employeeGenderField, employeeOccupationField, employeeMaritalStatusField,
                                employeeNationalityField,
                                employeeStateOfOriginField, employeeTinField,
                                createButtonsLayout());
        }

        private Component createButtonsLayout() {
                save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
                delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
                close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                save.addClickShortcut(Key.ENTER);
                close.addClickShortcut(Key.ESCAPE);

                save.addClickListener(event -> validateAndSave());
                delete.addClickListener(event -> fireEvent(new DeleteEvent(this, employee)));
                close.addClickListener(event -> fireEvent(new CloseEvent(this)));

                binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

                return new HorizontalLayout(save, delete, close);

        }

        private void validateAndSave() {
                try {
                        binder.writeBean(employee);
                        fireEvent(new SaveEvent(this, employee));
                } catch (ValidationException e) {
                        e.printStackTrace();
                }

        }
        public void setEmployee(Employee employee) {
                this.employee = employee;
                binder.readBean(employee);
        }

        public static abstract class EmployeeFormEvent extends ComponentEvent<ActionsForm> {
                private Employee employee;

                protected EmployeeFormEvent(ActionsForm source, Employee employee) {
                        super(source, false);
                        this.employee = employee;
                }

                public Employee getEmployee() {
                        return employee;
                }
        }

        public static class SaveEvent extends EmployeeFormEvent {
                SaveEvent(ActionsForm source, Employee employee) {
                        super(source, employee);
                }
        }

        public static class DeleteEvent extends EmployeeFormEvent {
                DeleteEvent(ActionsForm source, Employee employee) {
                        super(source, employee);
                }
        }

        public static class CloseEvent extends EmployeeFormEvent {
                CloseEvent(ActionsForm source) {
                        super(source, null);
                }
        }

        public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                        ComponentEventListener<T> listener) {
                return getEventBus().addListener(eventType, listener);
        }
}
