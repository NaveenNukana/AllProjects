package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@SpringBootApplication
@Component
public class JwtSecurityExApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityExApplication.class, args);
	}

}
