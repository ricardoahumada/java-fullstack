package com.banana.models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	private int gradoCoquetitud;
	private List<Maquillaje> listaDeCosmeticos;
	
	public Persona(){
		this.listaDeCosmeticos = new ArrayList<Maquillaje>(); 
	}
	
	public List<Maquillaje> coleccionarCosmetico(Maquillaje unCosmetico){
		this.listaDeCosmeticos.add(unCosmetico);
		return this.listaDeCosmeticos;
	}
	
	public void checkCosmeticos() {
		for (Maquillaje maquillaje : this.listaDeCosmeticos) {
			System.out.println( maquillaje.showData() );
		}
	}
	
	public int pagar(){
		int precioPagado=0;
		for (Maquillaje maquillaje : this.listaDeCosmeticos) {
			precioPagado += maquillaje.comprar();
		}
		
		return precioPagado;
	}

	
}
