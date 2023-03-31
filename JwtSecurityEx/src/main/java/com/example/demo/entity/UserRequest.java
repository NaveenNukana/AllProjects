package com.example.demo.entity;
//package com.example.demo.entity;

//package com.example.demo.model;
import lombok.Data;
@Data
public class UserRequest {
	private String username;
	private String password;
	public UserRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getusername() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}