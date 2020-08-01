package com.cutomer.sanitize.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cutomer.sanitize.entity.TermsConditions;

public interface TermsConditionsRepository extends JpaRepository<TermsConditions, Integer>{
	
	TermsConditions findByCategory(String category);
}
