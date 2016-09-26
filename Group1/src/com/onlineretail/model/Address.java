package com.onlineretail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	
	@Id
	@Column(name="address_id ")
	private Integer addressId;
	
	@Column(name="user_id")
	private Integer userId; 
	
	@Column(name="house_no")
	private Integer houseNumber;
	
	@Column(name="Street")
	private String street;
	
	@Column(name="landmark")
	private String landmark;
	
	@Column(name="city")
	private String city;
	
	@Column(name="State")
	private String state;
	
	@Column(name="pincode")
	private Long pincode;
	 
	public Address(){}

	public Address(Integer addressId, Integer userId, Integer houseNumber,
			String street, String landmark, String city, String state,
			Long pincode) {
		super();
		this.addressId = addressId;
		this.userId = userId;
		this.houseNumber = houseNumber;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	

	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
}
