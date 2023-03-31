package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.vo.EmployeeRequest;

@Service

public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
    private DepartmentRepository departmentRepository;
	@Transactional
	public String saveEmployee(EmployeeRequest employeeRequest) {
		Department department =new Department();
		department.setDepartName(employeeRequest.getDepartmentName());
		department.setDepatCode(employeeRequest.getDepartmentName());
		
		Long departmentId =departmentRepository.save(department).getDepartId();
		Employee employee=null;
//	    Employee employee =new  Employee();
	    employee.setEmpName(employeeRequest.getEmpName());
	    employee.setEmail(employeeRequest.getEmail());
	    employee.setDepartmentId(departmentId);
	     
	    employeeRepository.save(employee);
	    return "employee is saved with Employee ID : "+employee.getEmpId();
	}

}
