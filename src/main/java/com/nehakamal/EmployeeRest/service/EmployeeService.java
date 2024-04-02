package com.nehakamal.EmployeeRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.hibernate.ObjectNotFoundException;

//import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.nehakamal.EmployeeRest.dao.EmployeeDAO;
import com.nehakamal.EmployeeRest.model.Address;
import com.nehakamal.EmployeeRest.model.Employee;
import com.nehakamal.EmployeeRest.repository.EmployeeRepository;
import com.nehakamal.EmployeeRest.repository.AddressRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Autowired 
	private AddressRepository addressRepository;
	
	
	public List<Employee> FindAllEmployee(){
		return employeeRepository.findAll();
		
	}
	
	public Optional<Employee> findEmployeeById(Long id){
		return employeeRepository.findById(id);
	}
	
	
	
	

	
	public Employee updateEmployee(Employee employee) {
		
		Optional<Employee> existingEmployee = employeeRepository.findById(employee.getId());
		
		
		if (existingEmployee.isPresent()) {
			
			Employee emp = existingEmployee.get();
			
			emp.setId(employee.getId());
			
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setDeptName(employee.getDeptName());
			emp.setEmail(employee.getEmail());
			return employeeRepository.save(emp);
		}else {
			throw new NoSuchElementException("No Found");
		}
			

		
		
		
		
		
		
	  
	}
	public String deleteEmployee(Long id) {
		employeeRepository.deleteById((long) id);
		return "employee removed "+ id;
	}
	
	
	private boolean isEmailAlreadyPresent(String email) {
		Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);
		return employeeOptional.isPresent();
	}
	
	public ResponseEntity<?> saveEmployee(Employee employee) {
		if(isEmailAlreadyPresent(employee.getEmail())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email already exists");
		}
		return ResponseEntity.ok(employeeRepository.save(employee));
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> saveEmployees(Employee employees){
		return (List<Employee>) employeeRepository.save(employees);
	}
	
	
}
