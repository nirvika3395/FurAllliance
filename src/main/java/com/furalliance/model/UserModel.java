package com.furalliance.model;

import java.time.LocalDate;

public class UserModel {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private LocalDate dob;
	private String gender;
	private String email;
	private String number;
	private String password;
	private String imageUrl;
	private boolean isAdmin;
	private boolean isActive;

	// Default constructor
	public UserModel() {
	}

	// Constructor for login
	public UserModel(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	// Full constructor
	public UserModel(String firstName, String lastName, String userName, LocalDate dob, String gender, String email,
			String number, String password, String imageUrl, boolean isAdmin, boolean isActive) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.number = number;
		this.password = password;
		this.imageUrl = imageUrl;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}

	// Partial constructor for registration (without isAdmin/isActive flags)
	public UserModel(String firstName, String lastName, String userName, LocalDate dob, String gender, String email,
			String number, String password, String imageUrl) {
		this(firstName, lastName, userName, dob, gender, email, number, password, imageUrl, false, true);
	}

	// Constructor for lightweight view (profile info)
	public UserModel(String firstName, String lastName, String userName, String email, String number) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.number = number;
	}

	// Constructor for admin/active status
	public UserModel(boolean isAdmin, boolean isActive) {
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isActive() {
		return false;
	}

	public void setActive(boolean boolean1) {
		// TODO Auto-generated method stub
		
	}
	
}