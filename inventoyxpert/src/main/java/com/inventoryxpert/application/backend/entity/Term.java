package com.inventoryxpert.application.backend.entity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String termsName;
    private int termsDays;


    public Term() {
    }

    public Term(Long id, String termsName, int termsDays) {
        this.id = id;
        this.termsName = termsName;
        this.termsDays = termsDays;
    }

    public Long getId() {
        return id;
    }

    public String getTermsName() {
        return termsName;
    }

    public int getTermsDays() {
        return termsDays;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTermsName(String termsName) {
        this.termsName = termsName;
    }


    public void setTermsDays(int termsDays) {
        this.termsDays = termsDays;
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", termsName='" + termsName + '\'' +
                ", termsDays=" + termsDays +
                '}';
    }
}
