package com.banana.models;

public class Leon extends Animal {

	@Override
	public void emitirOnomatopeya() {
		System.out.println("Arrrrggggg");
	}

	@Override
	public boolean mover(int metros) {
		int metrosRecorridos=1;
		while (metrosRecorridos<metros) {
			System.out.println("Leon moviendo..."+metrosRecorridos);
			metrosRecorridos*=2;
		}
		
		System.out.println("Leon movido...");
		return true;
	}

}
