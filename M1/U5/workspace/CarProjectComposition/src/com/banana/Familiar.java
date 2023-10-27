package com.banana;

public class Familiar extends Car {
	int volumenMaletero;
	int consumopor100;
	
	public Familiar(String marca, String tipo, int velocidad,int volumenMaletero,int consumopor100) {
		super(marca, tipo, velocidad);
		this.volumenMaletero=volumenMaletero;
		this.consumopor100=consumopor100;
	}

}
