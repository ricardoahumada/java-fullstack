package com.banana.modelos.employees;

import com.banana.modelos.Address;
import com.banana.modelos.Department;

public class Marketer extends Employee {
	String channel;
	boolean knowHowToDesign;
	public Marketer(int id, String name, Address address, Department department, String channel,
			boolean knowHowToDesign) {
		super(id, name, address, department);
		this.channel = channel;
		this.knowHowToDesign = knowHowToDesign;
	}
	
	
}
