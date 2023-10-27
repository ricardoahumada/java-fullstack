package com.banana;

public class CarTester {

	public static void main(String[] args) {
		final int DISTANCIA = 100;

		Car audi = new Car("Audi", "berlina", 250);
		Car ferrari = new Car("Ferrari", "deportivo", 350);
		Car citroen = new Car("Citröen", "monovolumen", 200);
		Car lambo = new Car("Lamborghini", "guay", 400);

		Car[] coches = { audi, ferrari, citroen, lambo };

		Car quickerCar = null;
		for (Car aCar : coches) {
			if (quickerCar != null) {
				quickerCar = aCar.calcTime(DISTANCIA) < quickerCar.calcTime(DISTANCIA) ? aCar : quickerCar;
			} else
				quickerCar = aCar;
		}

		System.out.println("The quicker is:" + quickerCar.getMarca());

		for (Car aCar : coches) {
			if (quickerCar != null) {
				quickerCar = aCar.avanzar(DISTANCIA) < quickerCar.avanzar(DISTANCIA) ? aCar : quickerCar;
			} else
				quickerCar = aCar;
		}

		System.out.println("The quicker is:" + quickerCar.getMarca());

	}

}
