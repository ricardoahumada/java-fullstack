package com.banana.models;

public abstract class Animal {
	
	public abstract void emitirOnomatopeya();
	public abstract boolean mover(int metros);
	
	public void respirar(){
		System.out.println("respirando...");
	}
	
	public void morir(){
		System.out.println("muerto!...");
	}
	
}
