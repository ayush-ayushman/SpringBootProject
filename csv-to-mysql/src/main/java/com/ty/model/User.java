package com.ty.model;

public class User {
	private int id;
	private String name;
	private String email;
	private String city;
	private long phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public User() {
		
	}
	public User(int id, String name, String email, String city, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
		this.phone = phone;
	}
	
	

}
