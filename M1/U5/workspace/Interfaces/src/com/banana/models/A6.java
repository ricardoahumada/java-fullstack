package com.banana.models;

public class A6 implements Printable {

	@Override
	public void print(String mean) {
		System.out.println("Haciendo zoom para que se vea a pantalla completa");
		System.out.println("Imprimiendo A6 en "+mean);
	}

	@Override
	public boolean cut() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Printable clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
