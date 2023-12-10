package com.inventoryxpert.application.views.terms;

import com.inventoryxpert.application.backend.entity.Term;
import com.inventoryxpert.application.backend.service.TermsService;
import com.inventoryxpert.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Terms")
@Route(value = "Add Terms", layout = MainLayout.class)
public class Terms extends VerticalLayout{

    private final TermsService  termsService;

    public Terms(TermsService termsService){
        this.termsService = termsService;
        setSpacing(false);

        FormLayout formLayout = new FormLayout();
        TextField termsNamField = new TextField("Terms");
        TextField termsDaysField = new TextField("Number of Days");

        Button button = new Button("Add Terms");
        formLayout.add(termsNamField, termsDaysField, button);

        button.addClickListener(e -> {
            Term terms = termsService.save(null,
            termsNamField.getValue(), Integer.parseInt(termsDaysField.getValue()));

            if (terms != null) {
                Notification.show("Terms Added");
            }else{
                Notification.show("Failed to add product");
            }

            termsNamField.clear();
            termsDaysField.clear();
        });

        add(formLayout);
    }


    
}
