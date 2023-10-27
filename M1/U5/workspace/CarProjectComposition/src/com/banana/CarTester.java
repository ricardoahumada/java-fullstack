package com.banana;

public class CarTester {

	public static void main(String[] args) {
		final int DISTANCIA = 100;

		Car reanult = new Familiar("Renaul", "monovolumen", 250,200,5);
		Car ferrari = new Deportivo("Ferrari", "deportivo", 350,200,3200);
		Car rover = new Todoterreno("Land Rover", "todoterreno", 200,2);

		Car[] coches = { reanult, ferrari, rover };

		Car quickerCar = null;

		for (Car aCar : coches) {
			if (quickerCar != null) {
				quickerCar = aCar.avanzar(DISTANCIA) < quickerCar.avanzar(DISTANCIA) ? aCar : quickerCar;
			} else
				quickerCar = aCar;
		}

		System.out.println("The quicker is:" + quickerCar.getMarca());

	}

}
