package com.nehakamal.EmployeeRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nehakamal.EmployeeRest.model.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findAllByEmployeeId(Long employeeId);
	
}


