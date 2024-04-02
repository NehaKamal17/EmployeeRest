package com.nehakamal.EmployeeRest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="t_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addId;
	
	
	@Column(name="address")
	private String address;
	
	
	@ManyToOne
	private Employee employee;


	


	public Address(long addId, String address, Employee employee) {
		super();
		this.addId = addId;
		this.address = address;
		this.employee = employee;
	}




	public Address() {
		super();
	}


	

	public long getAddId() {
		return addId;
	}


	public void setAddId(long addId) {
		this.addId = addId;
	}



	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
}
