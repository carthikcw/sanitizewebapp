package com.cutomer.sanitize.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity
@Table(name = "addr_tab")*/
public class Address {
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 */
	private int addressId;
	private String dno;
	private String street;
	private String area;
	private String district;
	private String state;
	private String pincode;
	

}
