package com.banana.models;

import java.util.Set;

public class Employee {
	private int id;
	private String firstName, lastName;
	private Department departamento;
	private Set<Role> roles;
	
	public Employee(){}
	
	public Employee(String firstName, String lastName,Department dep) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.departamento=dep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Department getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Department departamento) {
		this.departamento = departamento;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
