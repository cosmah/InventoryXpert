package com.inventoryxpert.application.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventoryxpert.application.backend.entity.Terms;

@Repository
public interface TermsRepository extends JpaRepository<Terms, Long>{
    @Query ("SELECT t FROM Terms t WHERE LOWER(t.termsName) LIKE LOWER(CONCAT('%', :stringFilter, '%'))")
    List<Terms> search(@Param("stringFilter") String stringFilter);
}
