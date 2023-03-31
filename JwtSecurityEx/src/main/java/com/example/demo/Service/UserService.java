package com.example.demo.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	public UserRepository repository;
	
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	public void saveOrUpdate(User user) {
		repository.save(user);
		
	}
}