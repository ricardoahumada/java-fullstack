package com.banana;

public class Address {
	private String street;
	private int number;
	private String cp;
	private String city;
	private String country;
	
	public Address(String street, int number, String cp, String city, String country) {
		this.street=street;
		this.number=number;
		this.cp=cp;
		this.city=city;
		this.country=country;
	}

	public String getCompleteAddress() {
		String result="";
		result = this.street+"/"+ this.number +"/"+this.cp+"/"+this.city+"/"+this.country;
		return result;
	}

}
