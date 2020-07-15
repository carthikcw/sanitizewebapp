package com.cutomer.sanitize.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer_tab")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	 @GenericGenerator(name = "customer_Id", strategy =
			  "com.cutomer.sanitize.util.CustomerIdGenerator")
	@GeneratedValue(generator = "customer_Id")
	@Column(name="customer_Id")
	private String customerId;
	@NotEmpty(message="vehicleType cannot be empty")
	private String vehicleType;
	@NotEmpty(message="washingType cannot be empty")
	private String washingType;
	@NotEmpty(message="primaryNumber cannot be empty")
	private String primaryNumber;
	private String secondaryNumber;
	@NotEmpty(message="userLocation cannot be empty")
	private String userLocation;
	// private Address userLocation;
	private String userMessage;
	private String orderStatus;
	private LocalDateTime date;
	private String isValidUser;
	
	
	public Customer() {
		super();
	}


	public Customer(String customerId, String vehicleType, String washingType, String primaryNumber,
			String secondaryNumber, String userLocation, String userMessage, String orderStatus, LocalDateTime date,
			String isValidUser) {
		super();
		this.customerId = customerId;
		this.vehicleType = vehicleType;
		this.washingType = washingType;
		this.primaryNumber = primaryNumber;
		this.secondaryNumber = secondaryNumber;
		this.userLocation = userLocation;
		this.userMessage = userMessage;
		this.orderStatus = orderStatus;
		this.date = date;
		this.isValidUser = isValidUser;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public String getWashingType() {
		return washingType;
	}


	public void setWashingType(String washingType) {
		this.washingType = washingType;
	}


	public String getPrimaryNumber() {
		return primaryNumber;
	}


	public void setPrimaryNumber(String primaryNumber) {
		this.primaryNumber = primaryNumber;
	}


	public String getSecondaryNumber() {
		return secondaryNumber;
	}


	public void setSecondaryNumber(String secondaryNumber) {
		this.secondaryNumber = secondaryNumber;
	}


	public String getUserLocation() {
		return userLocation;
	}


	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}


	public String getUserMessage() {
		return userMessage;
	}


	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public String getIsValidUser() {
		return isValidUser;
	}


	public void setIsValidUser(String isValidUser) {
		this.isValidUser = isValidUser;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", vehicleType=" + vehicleType + ", washingType=" + washingType
				+ ", primaryNumber=" + primaryNumber + ", secondaryNumber=" + secondaryNumber + ", userLocation="
				+ userLocation + ", userMessage=" + userMessage + ", orderStatus=" + orderStatus + ", date=" + date
				+ ", isValidUser=" + isValidUser + "]";
	}
}
