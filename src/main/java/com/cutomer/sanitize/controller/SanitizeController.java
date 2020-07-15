package com.cutomer.sanitize.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cutomer.sanitize.entity.Customer;
import com.cutomer.sanitize.exception.InvalidDatesException;
import com.cutomer.sanitize.request.SearchData;
import com.cutomer.sanitize.service.CustomerService;
import com.cutomer.sanitize.util.AES;

@RestController
@RequestMapping("/v1")
public class SanitizeController {

	@Autowired
	private CustomerService CustomerService;

	@PostMapping("/getRequests")
	public ResponseEntity<?> getAllRequest(@Valid @RequestBody SearchData searchdata) {
		LocalDate fromdate = LocalDate.parse(searchdata.getFromDate());
		LocalDate todate = LocalDate.parse(searchdata.getToDate());
		LocalDate todayDate = LocalDate.now();
		if (fromdate.isAfter(todayDate)) {
			throw new InvalidDatesException("fromDate cannot be greater  than Todays Date");
		}
		if (todate.isAfter(todayDate)) {
			throw new InvalidDatesException("Todate cannot be greater  than Todays Date");
		}
		if (fromdate.isAfter(todate)) {
			throw new InvalidDatesException("fromDate  cannot be greater  than toDate");
		}
		if (todate.isBefore(fromdate)) {
			throw new InvalidDatesException("toDate  cannot be lesser than fromDate");
		}
		LocalDateTime fromdatetime = fromdate.atStartOfDay();
		LocalDateTime todatetime = todate.atTime(LocalTime.MAX);
		List<Customer> customers = CustomerService.getCustomers(fromdatetime, todatetime);
		if (customers.size() > 0) {
			customers.forEach(cust->
			{
				cust.setPrimaryNumber(AES.decrypt(cust.getPrimaryNumber(),"sanitize"));
				cust.setSecondaryNumber(AES.decrypt(cust.getSecondaryNumber(),"sanitize"));
			});
			Map<String, Object> body = new LinkedHashMap<>();
			body.put("status", "success");
			body.put("requests", customers);
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		Map<String, Object> body = new HashMap<>();
		body.put("message",
				"No Requests Found Between " + searchdata.getFromDate() + "," + searchdata.getToDate() + " dates");
		return new ResponseEntity<>(body, HttpStatus.OK);

	}

	@PostMapping("/requestWash")
	public ResponseEntity<?> createRequest(@Valid @RequestBody Customer customer) {
		customer.setPrimaryNumber(AES.encrypt(customer.getPrimaryNumber(), "sanitize"));
		customer.setSecondaryNumber(AES.encrypt(customer.getSecondaryNumber(), "sanitize"));
		Customer createdCustomer = CustomerService.createCustomer(customer);
		String customerid = createdCustomer.getCustomerId();
		if (customerid != null) {
			Map<String, Object> body = new LinkedHashMap<>();
			body.put("status", "success");
			body.put("message",
					"Thankyou, Your Request Id is " + customerid + ". Our team will contact you in short time");
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		return new ResponseEntity<>("There is a problem while saving the record", HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
