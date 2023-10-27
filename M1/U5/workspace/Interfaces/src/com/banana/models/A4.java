package com.banana.models;

public class A4 implements Printable {

	@Override
	public void print(String mean) {
		System.out.println("Imprimiendo A4 en "+mean);
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
