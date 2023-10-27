package com.banana;

public class WordCounterJoan {

	public static void main(String[] args) {
		String[] myArray = { "Atún", "Salmón", "Trucha", "Dorada", "Panga", "Lucho", "Gamba", "Pulpo", "Cangrejo",
				"Almeja", "Pláncton" };
		int i = 0;
		int result = 0, longitud = 0;
		String myStrings = "";

		for (i = 0; i < myArray.length; i++) {

			longitud = myArray[i].length();
			myStrings = myArray[i];

			try {
				result = Integer.parseInt(args[0]);
			} catch (Exception e) {
				System.out.println("Hay un error en la definición de los argumentos");
			}

			if (result == longitud && myStrings.contains(args[1]))
				System.out
						.println("Este és el único string que contiene el substring 'a' y tiene 8 letras de 'length': "
								+ myArray[i] + " -> " + myArray[i].length());

		}

	}

}
