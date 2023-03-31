 package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.EmployeeService;
import com.example.demo.vo.EmployeeRequest;

@RestController

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/emp")
	public String saveEmployee( @RequestBody EmployeeRequest employeeRequest) {
		return employeeService.saveEmployee(employeeRequest);
	}

}
