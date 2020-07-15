package com.cutomer.sanitize.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cutomer.sanitize.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	//@Query("select c from customer_tab  c where c.date >=:fromdatae and c.date<=:todate")
	//public List<Customer> findRequestsBetweenDates(@Param("fromdatae") String fromdatae,@Param("todate") String todate);
	//@Query("select c from customer_tab c where c.date >=:start and c.date <=:end")
	
	 List<Customer> findByDateBetween(LocalDateTime startDate,LocalDateTime endDate);
	// List<Customer> findAllByDateLessThanEqualAndEndDateGreaterThanEqual()

}
