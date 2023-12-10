package com.inventoryxpert.application.backend.entity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Terms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String termsName;
    private int termsDays;


    public Terms() {
    }

    public Terms(Long id, String termsName, int termsDays) {
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
        return "Terms{" +
                "id=" + id +
                ", termsName='" + termsName + '\'' +
                ", termsDays=" + termsDays +
                '}';
    }
}
