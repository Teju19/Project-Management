package com.projectmanagement.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DirectorRequestDto {

	@NotEmpty(message="director name cannot be empty")
	private String directorName;
	
	@NotEmpty(message="phone no cannot be empty")
	@Size(min=10,max=10,message="phone no should be 10 digits")
	private String phoneNo;
	
	@Email(message="email entered is wrong")
	private String email;
	
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
