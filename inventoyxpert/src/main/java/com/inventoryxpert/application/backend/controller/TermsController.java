package com.inventoryxpert.application.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryxpert.application.backend.service.TermsService;
import com.inventoryxpert.application.views.terms.Terms;

@RestController
public class TermsController {

    private final TermsService service;

    @Autowired
    public TermsController(TermsService service) {
        this.service = service;
    }

    @GetMapping("/terms")
    public List<Terms> getTerms() {
        return service.findAll();
    }


    
}
