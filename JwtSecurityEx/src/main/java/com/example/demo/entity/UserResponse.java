package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	
	private String token;
	private String message;
	public UserResponse(String token2, String string) {
		// TODO Auto-generated constructor stub
	}
}