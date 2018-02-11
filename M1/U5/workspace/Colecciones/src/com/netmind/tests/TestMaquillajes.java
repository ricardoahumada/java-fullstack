package com.netmind.tests;

import com.netmind.models.Almacen;
import com.netmind.models.Maquillaje;
import com.netmind.models.Persona;

public class TestMaquillajes {

	public static void main(String[] args) {
		Persona diana = new Persona();
		Almacen unAlmacen = new Almacen();
		
		Maquillaje maxFactor = new Maquillaje("Max Factor","labios",20);
		Maquillaje lOreal = new Maquillaje("L'Oreal","pelo",30);
		Maquillaje esteer = new Maquillaje("Esteer Lauder","pelo",50);
		
		/*A�adimos al almacen*/
		unAlmacen.almacenar(maxFactor);
		unAlmacen.almacenar(lOreal);
		unAlmacen.almacenar(esteer);
		
		unAlmacen.muestraLosCosmeticos();
		
		/*El usuario colecciona*/
		diana.coleccionarCosmetico(maxFactor);
		diana.coleccionarCosmetico(lOreal);
		diana.coleccionarCosmetico(esteer);
		
		diana.checkCosmeticos();
		
		System.out.println(diana.pagar());
	}

}
