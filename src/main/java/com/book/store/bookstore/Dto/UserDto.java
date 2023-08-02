package com.book.store.bookstore.Dto;



import java.io.Serializable;


public class UserDto  {
    private int id;
    private String name;
    private String email;
    private String saltedPassword;
    private String address;
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
	public String getSaltedPassword() {
		return saltedPassword;
	}
	public void setSaltedPassword(String saltedPassword) {
		this.saltedPassword = saltedPassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
}
