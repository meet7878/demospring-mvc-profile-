package com.Bean;

import org.hibernate.validator.constraints.NotBlank;

public class Loginbean {
	@NotBlank(message="Enter email")
	private String email;
	@NotBlank(message="enter passsword")
	private String password;
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
