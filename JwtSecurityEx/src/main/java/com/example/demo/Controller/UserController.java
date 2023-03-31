package com.example.demo.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.IUserService;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRequest;
import com.example.demo.entity.UserResponse;
import com.example.demo.util.JwtUtil;

@RestController
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private JwtUtil util;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/save")
	public ResponseEntity<String>saveUser(@RequestBody User user){
		Integer id=service.saveUser(user);
		String body="User '"+id+" ' saved";
		//return new ResponseEntity<String>(body,HttpStatus.OK);
		return ResponseEntity.ok(body);
	}
	
	
//valiadate user and generate token(Login)
	@PostMapping("/login")
public ResponseEntity<UserResponse>loginUser(@RequestBody UserRequest request){
		
		//validate un/pwd with database
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
	String token=util.GenerateToken(request.getusername());
	return ResponseEntity.ok(new UserResponse(token,"Success! Generated by Naveen"));
	
	
	
}
	
	//3.after login only
	@PostMapping("/welcome")
	public ResponseEntity<String> accessData(Principal p){
		return ResponseEntity.ok("hello user!"+p.getName());
	}
}