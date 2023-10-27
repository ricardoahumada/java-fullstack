package com.banana.models;

public class Humano extends Animal {

	@Override
	public void emitirOnomatopeya() {
		System.out.println("Hola como estás");
	}

	@Override
	public boolean mover(int metros) {
		int metrosRecorridos=0;
		while (metrosRecorridos<metros) {
			System.out.println("Humano moviendo..."+metrosRecorridos);
			metrosRecorridos+=1;
		}
		
		System.out.println("Humano movido...");
		return true;
	}

}
