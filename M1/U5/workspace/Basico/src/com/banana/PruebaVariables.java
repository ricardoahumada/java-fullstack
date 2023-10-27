package com.banana;

public class PruebaVariables {

	public static void main(String[] args) {
		int numero = 23;
		int otroNumero =35;
		int resultado=0;
		
		float numFlot = 2.3f;
		double numDoub=3.4;
		double resultDoub;
		
		resultado= numero+otroNumero;
		resultado++;
		
		System.out.println(numero +"+"+ otroNumero +"="+resultado);
		
		resultDoub = numFlot+numDoub;
		System.out.println(numFlot +"+"+ numDoub +"="+resultDoub);
		
	}

}
