package com.mobileapp.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateStudentDetailsRequest {
	@NotNull(message="FirstName can not be null")
	@Size(min = 2,message = "FirstName must not be less than 2 characters")
	private String firstName;
	@NotNull(message="LastName can not be null")
	@Size(min = 2,message = "LastName must not be less than 2 characters")
	private String lastName;
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

}
