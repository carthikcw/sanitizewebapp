package com.cutomer.sanitize.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cutomer.sanitize.entity.Customer;
import com.cutomer.sanitize.repository.CustomerRepository;
import com.cutomer.sanitize.util.AES;
import com.cutomer.sanitize.util.PasswordEncrypt;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer createCustomer(Customer customer) {

		/*
		 * String contactnumber = customer.getPrimaryNumber(); String salt =
		 * PasswordEncrypt.getSalt(30); String mySecurephonenuber =
		 * PasswordEncrypt.generateSecurePassword(contactnumber, salt);
		 * customer.setPrimaryNumber(mySecurephonenuber);
		 */
		Customer createdCustomer = customerRepository.save(customer);
		return createdCustomer;
	}

	public List<Customer> getCustomers(LocalDateTime startDate, LocalDateTime endDate) {
		List<Customer> customers = customerRepository.findByDateBetween(startDate, endDate);
		return customers;
	}

	
	void m2()
	{
		String providedPassword = "myPassword123";
        
        // Encrypted and Base64 encoded password read from database
        String securePassword = "HhaNvzTsVYwS/x/zbYXlLOE3ETMXQgllqrDaJY9PD/U=";
        
        // Salt value stored in database 
        String salt = "EqdmPh53c9x33EygXpTpcoJvc4VXLK";
        
        boolean passwordMatch = PasswordEncrypt.verifyUserPassword(providedPassword, securePassword, salt);
        
        if(passwordMatch) 
        {
            System.out.println("Provided user password " + providedPassword + " is correct.");
        } else {
            System.out.println("Provided password is incorrect");
        }
	}
}
