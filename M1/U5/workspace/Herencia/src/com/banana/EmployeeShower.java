package com.banana;

public class EmployeeShower {

	public static void main(String[] args) {
		Employee[] empleados={
				new Employee(1, "Juan", new Address("GVCC", 859, "03450", "Bcn", "Ctyn"),new Department(1, "Marketing", "E1")),
				new Employee(2, "Roberta", new Address("PgG", 18, "023450", "Bcn", "Ctyn"),new Department(1, "Development", "E2")),
				new Employee(3, "Pedra", new Address("AG", 69, "013450", "Bcn", "Ctyn"),new Department(1, "Management", "E3")),
				new Programmer(4, "Gabriel", new Address("AD", 34, "012345", "Bcn", "Ctyn"), new Department(4, "Development", "E2"), new String[]{"html", "css"}, 9, 6, "bueno"),
				new Marketer(5, "Sergi", new Address("AM", 345, "012345", "Bcn", "Ctyn"), new Department(1, "Marketing", "E1"), "SSNN", true)
		};
				
		for (Employee aEmployee : empleados) {
			System.out.println( aEmployee.showData() );//muestra los datos en consola
		}
		
	}

}
