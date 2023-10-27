package com.banana;

public class EmployeeShower {

	public static void main(String[] args) {
		Employee[] empleados={
				new Employee(1, "Juan", new Address("GVCC", 859, "03450", "Bcn", "Ctyn"),new Department(1, "Marketing", "E1")),
				new Employee(2, "Roberta", new Address("PgG", 18, "023450", "Bcn", "Ctyn"),new Department(1, "Development", "E2")),
				new Employee(3, "Pedra", new Address("AG", 69, "013450", "Bcn", "Ctyn"),new Department(1, "Management", "E3"))
		};
		
		for (Employee aEmployee : empleados) {
			System.out.println( aEmployee.showData() );
		}
		
	}

}
