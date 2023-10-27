package com.banana;

public class Condicionales {

	public static void main(String[] args) {

		int x = 2, y = 3, z = 4;

		y = 2;

		if (x == y)
			System.out.println("x es igual a y");
		else
			System.out.println("x NO es igual a y");

		if (x != y)
			System.out.println("x NO es igual a y");
		else
			System.out.println("x es igual a y");

		if (x > y && y > z)
			System.out.println("x es la mayor");
		else if (x < y && y < z)
			System.out.println("x es la menor");
		else
			System.out.println("No se que es x");

		String valor = (x > y) ? "x es mayor" : "x es menor";
		System.out.println(valor);

		String texto = "Nada de nada";
		String valorAComp = "Hola";
		System.out.println( (texto.equals(valorAComp) ? "La variable vale " : "La variable NO vale ") + valorAComp );

	}

}
