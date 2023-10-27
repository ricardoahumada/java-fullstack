package com.banana;

public class TestStudent {

	public static void main(String[] args) {

		/*Student edwinS = new Student();

		edwinS.edad = 19;
		edwinS.id = 1;
		edwinS.name = "Edwin Sebastian";
		edwinS.sexo = "Hombre";
		edwinS.surname = "Perez";*/
		
		Student edwinS = new Student(1,"Edwin","Perez",19,"Hombre");
		
		System.out.println("Nombre y apellidos:" + edwinS.name + " " + edwinS.surname);

		Student dianaC = new Student();
		dianaC.edad = 20;
		//dianaC.id = 2;
		dianaC.setId(2);
		dianaC.name = "Diana Carolina";
		dianaC.sexo = "Mujer";
		dianaC.surname = "Ramone";
		
		//Student dianaC = new Student(2,"Diana Carolina","Ramone",10,"Mujer");

		System.out.println("Nombre y apellidos:" + dianaC.name + " " + dianaC.surname);

		System.out.println(edwinS.sayCompleteName());
		System.out.println(dianaC.sayCompleteName("en"));

		System.out.println("Quieres inscribirte? " + edwinS.duWantToApply());

		edwinS.edad = 13;

		System.out.println("Quieres inscribirte? " + edwinS.duWantToApply());

		dianaC.changeYourData("Diana", "Severina");
		System.out.println(dianaC.sayCompleteName());

	}

}
