package com.cutomer.sanitize.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cutomer.sanitize.entity.TermsConditions;
import com.cutomer.sanitize.exception.TermsConditonsException;
import com.cutomer.sanitize.service.TermsConditionsService;

@RestController
@RequestMapping("/v1")
public class TermsConditionsController {
	
	@Autowired
	private TermsConditionsService service;
	
	@PostMapping("/addTermCondition")
	public ResponseEntity<?> addTermsConditions(@RequestBody TermsConditions termsConditions)
	{
		TermsConditions savedtermsConditions = service.addTermsCondition(termsConditions);
		if(savedtermsConditions == null)
		{
			throw new TermsConditonsException("Terms And Conditions creation failed");
		}
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("status", "success");
		body.put("message", "Terms And Conditions created Successfully");
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	
	@GetMapping("/termCondition/{category}")
	public ResponseEntity<?> readTermsConditions(@PathVariable String category)
	{
		if(category ==null || category.isEmpty())
		{
			throw new TermsConditonsException("Please enter the category value");
		}
		TermsConditions termsCondition = service.getTermsConditions(category);
		Map<String, Object> body = new LinkedHashMap<>();
		if(termsCondition != null)
		{
			body.put("status", "success");
			body.put("termsCondition", termsCondition);
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		body.put("message", "No Data found for the given category "+category);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	
	
	

}
