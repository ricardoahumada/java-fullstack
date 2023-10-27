package com.banana;

public class WordCounter {

	public static void main(String[] args) {
		String[] nombres={"Joan","Marta","Edu","María Verónica","Diana Carolina"};
		
		int numLetras=0;
		try{
			if(args!=null && args.length>0) numLetras=Integer.parseInt(args[0]);
		}catch(Exception e){
			System.out.println("Debes introducir un número :-/!");
		}finally {
			System.out.println("Esto se ejecuta hay error o no");
		}
		
		if(numLetras>0) for(String unNombre:nombres){
			if(unNombre.length()==numLetras) System.out.println(
					"El texto con "+numLetras+" letras es "+unNombre);
		}

	}

}
