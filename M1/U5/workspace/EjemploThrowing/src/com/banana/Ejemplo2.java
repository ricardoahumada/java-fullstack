package com.banana;

public class Ejemplo2 {

	public static void main(String[] args) {
		try {
			remplaza();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void remplaza() throws Exception{
		String unTexto = null;

		unTexto.replace("a", "A");

		System.out.println("He llegado al final");
	}

}
