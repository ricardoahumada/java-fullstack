package com.banana;

public class Todoterreno extends Car {
	private int numeroCambios;
	private String currentMode;
	
	public Todoterreno(String marca, String tipo, int velocidad,int numeroCambios) {
		super(marca, tipo, velocidad);
		this.numeroCambios=numeroCambios;
		this.currentMode="urban";
	}

	@Override
	public double avanzar(int kms) {
		setParado(false);
		double time=0;
		double distancia_recorrida=0;
		while(distancia_recorrida<kms && !getParado()){
			time = time + (double)1/(double)getVelocidad();
			distancia_recorrida+=this.currentMode=="urban"?1:0.5;
		}
		setParado(true);
		
		return time;
	}

	//setters y getters
	public String getCurrentMode() {
		return currentMode;
	}

	public void setCurrentMode(String currentMode) {
		this.currentMode = currentMode;
	}
	
}
