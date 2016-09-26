package com.onlineretail.model;

public class User {
	private Integer userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String DOB;
	private String password;
	private String phoneNo;
	private String role;
	public String getMiddleName() {
		return middleName;
	}

	public User(Integer userId, String firstName, String middleName,
			String lastName, String emailId, String dOB, String password,
			String phoneNo, String role, String status) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		DOB = dOB;
		this.password = password;
		this.phoneNo = phoneNo;
		this.role = role;
		this.status = status;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	private String status;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDateOfBirth() {
		return DOB;
	}

	public void setDob(String dob) {
		this.DOB = DOB;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNo;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNo = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
