package com.banana;

public class Ejemplo {

	public static void main(String[] args) {
		String unTexto=null;
		
		try {
			unTexto.replace("a", "A");
		} catch (Exception e) {
			System.out.println("Un error "+e+"!!!");
		}
		
		System.out.println("He llegado al final");
		
	}

}
