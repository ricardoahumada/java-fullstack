package com.banana;

public class Deportivo extends Car {
	private int kmsCambioRueda;
	private double peso;//en kilos
	
	public Deportivo(String marca, String tipo, int velocidad,int kmsCambioRueda,double peso) {
		super(marca, tipo, velocidad);
		this.kmsCambioRueda=kmsCambioRueda;
		this.peso=peso;
	}
	
	@Override
	public double avanzar(int kms) {
		setParado(false);
		double time=0;
		double distancia_recorrida=0;
		while(distancia_recorrida < kms && !getParado() && distancia_recorrida < this.kmsCambioRueda){
			time = time + (double)1/(double)getVelocidad();
			distancia_recorrida+=2000/peso;
		}
		setParado(true);
		
		return time;
	}
}
