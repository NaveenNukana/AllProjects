package com.example.demo.Service;


import java.util.Optional;


import com.example.demo.entity.User;
public interface IUserService {
	
	 Integer saveUser(User user);
	
	 Optional<User> findByUserName(String users);
	
	
}