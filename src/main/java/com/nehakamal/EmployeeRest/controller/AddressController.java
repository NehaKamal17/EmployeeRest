package com.nehakamal.EmployeeRest.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
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

import com.nehakamal.EmployeeRest.model.Address;
import com.nehakamal.EmployeeRest.model.Employee;
import com.nehakamal.EmployeeRest.repository.AddressRepository;
import com.nehakamal.EmployeeRest.repository.EmployeeRepository;
import com.nehakamal.EmployeeRest.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	
	@Autowired
	private AddressService addressservice;
	
	@GetMapping("/{id}")
	public  ResponseEntity<Optional<Address>> FindAddressById(@PathVariable("id") Long id){
		Optional<Address> address= addressservice.FindAddressById(id);
		return ResponseEntity.ok().body(address);

	}
	
	
	@GetMapping
	public List<Address> FindAddress(){
		return addressservice.FindAddress();
		
		
	}
	@PostMapping("/saveAddress")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
		Address saveAddress= addressservice.saveAddress(address);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAddress);
			
	}
	

	@PutMapping("/update")
	public ResponseEntity<Optional<Address>> updateAddress(@RequestBody Address address){
		Optional<Address> updateAddress=Optional.ofNullable(addressservice.updateAddress(address));
		return ResponseEntity.ok().body(updateAddress);
		
		
	}
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<Address> deleteAddress(@PathVariable Long id) {
			addressservice.deleteAddress(id);
			return ResponseEntity.noContent().build();
		}
	

}
