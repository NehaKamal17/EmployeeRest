package com.nehakamal.EmployeeRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.nehakamal.EmployeeRest.model.Address;
import com.nehakamal.EmployeeRest.model.Employee;
import com.nehakamal.EmployeeRest.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired 
	private AddressRepository addressRepository;
	
	
	
	public List<Address> FindAddress(){
		return addressRepository.findAll();
		
	}
	
	public Optional<Address> FindAddressById(long id){
		return addressRepository.findById(id);
	}
	
	
	
	
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
		
	}
	
	
     public Address updateAddress(Address address) {
		
		Optional<Address> existingAddress = addressRepository.findById(address.getAddId());
	
		if (existingAddress.isPresent()) {
			
			Address ads= existingAddress.get();
			
			ads.setAddId(address.getAddId());
			
			
			ads.setAddress(address.getAddress());
			
			return addressRepository.save(ads);
		}else {
			throw new NoSuchElementException("No Found");
		}
		
     }
		
		public String deleteAddress(Long id) {
			addressRepository.deleteById((long) id);
			return "address removed "+ id;
		}
		
		
			   
}