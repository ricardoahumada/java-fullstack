package com.banana.model;

public class User {
	private String name="";
	private double percentage=0;
	private int rollNo=0;
	
	public User(String name,double d,int rollNo){
		this.name=name;
		this.percentage=d;
		this.rollNo=rollNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		rollNo = rollNo;
	}
	
	
}
