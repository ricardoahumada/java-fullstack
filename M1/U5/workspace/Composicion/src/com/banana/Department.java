package com.banana;

public class Department {
	private int did;
	private String name;
	private String location;
	
	public Department(int did, String name, String location){
		this.did=did;
		this.name=name;
		this.location=location;
	}
	
	public String getCompleteData() {
		return this.did+"/"+this.name+"/"+this.location;
	}

}
