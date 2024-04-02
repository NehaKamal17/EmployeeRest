package com.nehakamal.EmployeeRest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.nehakamal.EmployeeRest.dao.EmployeeDAO;
import com.nehakamal.EmployeeRest.model.Employee;
import com.nehakamal.EmployeeRest.service.EmployeeService;
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	
// have to create mappings in this controller and create the same methods in serv
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable("id") Long id){
		Optional<Employee> employee =employeeService.findEmployeeById(id);
		return ResponseEntity.ok().body(employee);
	}
	
	@GetMapping
	public List<Employee> FindAllEmployee(){
		return employeeService.FindAllEmployee();
	}
	

	
	@PostMapping("/saveEmployee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		ResponseEntity<?> saveEmployee=employeeService.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveEmployee);
			
	}

	
	@PutMapping("/update")
	public  ResponseEntity<Optional<Employee>> updateEmployee(@RequestBody Employee employee){
		Optional<Employee> updatEmployee=Optional.ofNullable(employeeService.updateEmployee(employee));
		return ResponseEntity.ok().body(updatEmployee);
		
	}
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
		 employeeService.deleteEmployee(id);
		 return ResponseEntity.noContent().build();
		}
	}

