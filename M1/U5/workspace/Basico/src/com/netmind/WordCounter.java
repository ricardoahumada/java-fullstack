package com.netmind;

public class WordCounter {

	public static void main(String[] args) {
		String[] nombres={"Joan","Marta","Edu","Mar�a Ver�nica","Diana Carolina"};
		
		int numLetras=0;
		try{
			if(args!=null && args.length>0) numLetras=Integer.parseInt(args[0]);
		}catch(Exception e){
			System.out.println("Debes introducir un n�mero :-/!");
		}finally {
			System.out.println("Esto se ejecuta hay error o no");
		}
		
		if(numLetras>0) for(String unNombre:nombres){
			if(unNombre.length()==numLetras) System.out.println(
					"El texto con "+numLetras+" letras es "+unNombre);
		}

	}

}
