package com.cutomer.sanitize.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cutomer.sanitize.entity.TermsConditions;
import com.cutomer.sanitize.repository.TermsConditionsRepository;

@Service
public class TermsConditionsService {

	@Autowired
	private TermsConditionsRepository repository;

	public TermsConditions addTermsCondition(TermsConditions termsConditions) {
		TermsConditions savedtermsConditions = repository.save(termsConditions);
		return savedtermsConditions;

	}

	public TermsConditions getTermsConditions(String category) {
		TermsConditions termsConditions = repository.findByCategory(category);
		return termsConditions;

	}

}
