package com.banana;

public class Car {
	private String marca;
	private String tipo;
	private int velocidad;
	private boolean parado;
	
	public Car(String marca,String tipo,int velocidad) {
		this.marca=marca;
		this.tipo=tipo;
		this.velocidad=velocidad;
		this.parado=true;
	}
	
	public double avanzar(int kms){
		this.parado=false;
		double time=0;
		double distancia_recorrida=0;
		while(distancia_recorrida<kms && !this.parado){
			time = time + (double)1/(double)this.velocidad;
			distancia_recorrida++;
		}
		this.parado=true;
		
		return time;
	}
	
	public double calcTime(int kms){
		double time=(double)kms/(double)this.velocidad;
		return time;
	}
	
	public boolean parar(){
		this.parado=true;
		return this.parado;
	}
	
	//Setters y getters
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public boolean isParado() {
		return parado;
	}

	public void setParado(boolean parado) {
		this.parado = parado;
	}
	
	
	
	
}
