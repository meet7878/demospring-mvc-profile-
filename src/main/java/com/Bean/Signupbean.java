package com.Bean;

import org.hibernate.validator.constraints.NotBlank;

public class Signupbean {
	Integer userid;
     @NotBlank(message = "please enter first name")
	private String firstName;
     @NotBlank(message = "please enter last name")
	private String lastName;
     @NotBlank(message="enter email")
	private String email;
     @NotBlank(message="enter password")
	private String password;
     @NotBlank(message="enter gender")
     private String gender;
     
     private String  usertype;
     
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
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
