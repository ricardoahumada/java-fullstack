package com.banana;

public class LetterCounter {

	public static void main(String[] args) {
		String[] nombres={"Joan","Marta","Edu","María Verónica","Diana Carolina"};
		
		for(String unNombre:nombres){
			System.out.println( unNombre+":"+unNombre.length() );
		}
		
		for(int i=0;i<nombres.length;i++){
			System.out.println( nombres[i]+":"+ nombres[i].length());
		}
		
	}

}
