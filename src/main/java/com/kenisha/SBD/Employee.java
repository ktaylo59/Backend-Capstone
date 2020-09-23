package com.kenisha.SBD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="new_employee")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name= "emp_id")
    private Long id;
 public Long getId() {
		return id;
	}
@Column(name="firstName")
    private String firstName;
 @Column(name="lastName")
    private String lastName;
 @Column(name="email")
    private String email;
 @Column(name="password")
 private String password;
    public Employee() {
    	
    }
public Employee(String firstName, String lastName, String email, Long id, String password) {
	
	this.id= id;
	this.firstName= firstName;
	this.lastName = firstName;
	this.email = email;
	this.password = password;
	
}
    
    public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
	public Long id() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
		
	}


