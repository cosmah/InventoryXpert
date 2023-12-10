package com.inventoryxpert.application.backend.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Taxes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    
    
}
