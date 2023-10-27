package com.banana.model;

public class Student implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String firstName = null;
	private String lastName = null;
	private int age = 0;

	public Student() {
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}