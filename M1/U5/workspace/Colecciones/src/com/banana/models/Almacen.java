package com.banana.models;

import java.util.HashMap;
import java.util.Map;

public class Almacen {
	Map<String, Maquillaje> cosmeticos;

	public Almacen() {
		this.cosmeticos = new HashMap<String, Maquillaje>();
	}

	public boolean almacenar(Maquillaje unMaquillaje) {
		this.cosmeticos.put(unMaquillaje.getCodigo(), unMaquillaje);
		return true;
	}

	public Maquillaje retirar(String unCodigo) {
		if (this.cosmeticos != null && unCodigo.trim() != "") {
			Maquillaje elMaquillajeARetirar = this.cosmeticos.get(unCodigo);
			this.cosmeticos.remove(unCodigo);
			return elMaquillajeARetirar;
		} else
			return null;
	}

	public void muestraLosCosmeticos() {
		for(Map.Entry m : this.cosmeticos.entrySet() ){
			System.out.println(m.getKey()+" / "+ m.getValue() +" / "+ ((Maquillaje)m.getValue()).getMarca() );
		}
	}

}