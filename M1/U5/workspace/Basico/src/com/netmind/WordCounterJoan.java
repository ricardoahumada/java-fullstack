package com.netmind;

public class WordCounterJoan {

	public static void main(String[] args) {
		String[] myArray = { "At�n", "Salm�n", "Trucha", "Dorada", "Panga", "Lucho", "Gamba", "Pulpo", "Cangrejo",
				"Almeja", "Pl�ncton" };
		int i = 0;
		int result = 0, longitud = 0;
		String myStrings = "";

		for (i = 0; i < myArray.length; i++) {

			longitud = myArray[i].length();
			myStrings = myArray[i];

			try {
				result = Integer.parseInt(args[0]);
			} catch (Exception e) {
				System.out.println("Hay un error en la definici�n de los argumentos");
			}

			if (result == longitud && myStrings.contains(args[1]))
				System.out
						.println("Este �s el �nico string que contiene el substring 'a' y tiene 8 letras de 'length': "
								+ myArray[i] + " -> " + myArray[i].length());

		}

	}

}
