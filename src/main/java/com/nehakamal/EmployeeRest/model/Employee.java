package com.nehakamal.EmployeeRest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="t_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="dept_name")
	private String deptName;
	
	
	@Column(name="email", unique = true)
	private String email;
	
	
	
//	//create foreign key column in employee table addressList_id
	
   
//   @JoinColumn(name="nameforthenewcolumn")
	
	 @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	
	 @JsonIgnoreProperties("employee")
     private List<Address> addressList;
	 
	 
	 
	 
	 
	 public Employee(Long id, String firstName, String lastName, String deptName, String email,
				List<Address> addressList) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.deptName = deptName;
			this.email = email;
			this.addressList = addressList;
		}



		public Employee() {
			super();
		}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getDeptName() {
		return deptName;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Address> getAddressList() {
		return addressList;
	}



	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}



	
	
	
	

	

	
	
	
	
	

	
	
}
