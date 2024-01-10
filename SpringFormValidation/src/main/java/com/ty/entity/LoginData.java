package com.ty.entity;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class LoginData {
	@javax.validation.constraints.NotBlank(message="user name can not be null")
	@Size(min=3, max=14,message="in between 3 to 14") 
	private String userName;
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="invalid email")
	private String email;
	public LoginData() {
		super();
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LoginData(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}
	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + "]";
	}
	

}
