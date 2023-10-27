package com.banana;

public class Student {
	private int id;
	String name;
	String surname;
	int edad;
	String sexo;
	
	public Student(){
		
	}
	
	public Student(int sid){
		// cargar de ddbb objecto student con id "sid"
	}
	
	public Student(int id, String unName, String unSurname, int unaEdad, String unSexo) {
		this.id=id;
		this.name=unName;
		this.surname=unSurname;
		this.edad=unaEdad;
		this.sexo=unSexo;
	}
	
	String sayCompleteName(){
		return this.name +" "+ this.surname;
	}
	
	String sayCompleteName(String lang){
		if(lang.equals("es")) return this.name +" "+ this.surname;
		else return this.surname +", "+ this.name;
	}
	
	boolean duWantToApply(){
		if(this.edad>14) return true;
		else return false;
	}
	
	void changeYourData(String aName,String aSurname){
		this.name=aName;
		this.surname=aSurname;
	}
	
	//Setters y getters
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
