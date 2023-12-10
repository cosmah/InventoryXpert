package com.inventoryxpert.application.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventoryxpert.application.backend.entity.Term;

@Repository
public interface TermsRepository extends JpaRepository<Term, Long>{
    @Query ("SELECT t FROM Term t WHERE LOWER(t.termsName) LIKE LOWER(CONCAT('%', :stringFilter, '%'))")
    List<Term> search(@Param("stringFilter") String stringFilter);
}
