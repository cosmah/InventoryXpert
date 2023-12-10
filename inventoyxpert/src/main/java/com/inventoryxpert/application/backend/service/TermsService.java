package com.inventoryxpert.application.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventoryxpert.application.backend.repository.TermsRepository;
import com.inventoryxpert.application.views.terms.Terms;

@Service
public class TermsService {

    private final TermsRepository termsRepository;

    public List<Terms> findAll() {
        return termsRepository.findAll();
    }

    public List<Terms> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return termsRepository.findAll();
        } else {
            return termsRepository.search(stringFilter);
        }
    }
    
}
