package com.web_banking_application.banking.dto;

public class UsersDto {
	private long userId;
	private String first_Name;
	private String last_Name;
	private String email;
	private String password;
	private long mobile;
	public long getuserId() {
		return userId;
	}
	public void setId(long userId) {
		this.userId = userId;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public UsersDto(long userId, String first_Name, String last_Name, String email, String password, long mobile) {
		super();
		this.userId = userId;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	public UsersDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}