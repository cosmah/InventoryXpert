package com.inventoryxpert.application.backend.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.logging.*;
import com.inventoryxpert.application.backend.repository.TermsRepository;
import com.inventoryxpert.application.backend.entity.*;

@Service
public class TermsService {

    private static final Logger LOGGER = Logger.getLogger(TermsService.class
            .getName());


    private final TermsRepository termsRepository;

    public TermsService(TermsRepository termsRepository) {
        this.termsRepository = termsRepository;
    }

    public List<Term> findAll() {
        return termsRepository.findAll();
    }

    public List<Term> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return termsRepository.findAll();
        } else {
            return termsRepository.search(stringFilter);
        }
    }

    public long count() {
        return termsRepository.count();
    }

    public void delete(Term term) {
        if (term == null) {
            LOGGER.log(Level.SEVERE,
                    "Term is null. Are you sure you have connected your form to the application?");
            return;
        }
        termsRepository.delete(term);
    }

    public void save(Term term) {
        if (term == null) {
            LOGGER.log(Level.SEVERE,
                    "Term is null. Are you sure you have connected your form to the application?");
            return;
        }
        termsRepository.save(term);
    }

    public Term save(Long id, String termsName, int termsDays) {
        
        Term term = new Term();
        term.setId(id);
        term.setTermsName(termsName);
        term.setTermsDays(termsDays);

        return termsRepository.save(term);
    }

    public Collection<Term> getAllTerms() {
        return findAll();
    }

    
}
