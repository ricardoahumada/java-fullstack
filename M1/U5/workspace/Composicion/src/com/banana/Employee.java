package com.banana;

public class Employee {
	private int id;
	private String name;
	private Address address;
	private Department department;

	public Employee(int id, String name, Address address, Department department) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.department = department;
	}

	void fillAddress(String street, int number, String cp, String city, String country) {
		this.address = new Address(street, number, cp, city, country);
	}

	public String showData() {
		String datos = "";
		// System.out.println(this.address);
		datos = "("+this.id + ") " + this.name
				+"\n==============================="
				+ (this.address != null ? "\nAddress:" + this.address.getCompleteAddress() : "Sin dirección")
				+ (this.department != null ? "\nDepartment:" + this.department.getCompleteData() : "Sin dirección") + "\n";
		
		return datos;
	}

}
