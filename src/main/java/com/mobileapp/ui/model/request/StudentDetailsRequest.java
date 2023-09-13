package com.mobileapp.ui.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudentDetailsRequest {
	@NotNull(message="FirstName can not be null")
	@Size(min = 2,message = "FirstName must not be less than 2 characters")
	private String firstName;
	@NotNull(message="LastName can not be null")
	@Size(min = 2,message = "LastName must not be less than 2 characters")
	private String lastName;
	@NotNull(message="userID can not be null")
	private String userId;
	@NotNull(message="email can not be null")
	@Email
	private String email;
	@NotNull(message="password can not be null")
	@Size(min = 8,max = 16,message = "Password length should be greater than 8 and less than 16")
	private String password;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
