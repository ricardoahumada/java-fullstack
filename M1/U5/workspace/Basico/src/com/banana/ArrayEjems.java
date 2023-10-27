package com.banana;

public class ArrayEjems {

	public static void main(String[] args) {
		String[] alumnos = {"Joan","Jordi","Marta","Edu"};
		int[] meses = new int[12];
		
		System.out.println( meses.length );
		
		System.out.println( alumnos.toString() );
		
		System.out.println( "Primer elemento:" + alumnos[0] );
		System.out.println( "Primer elemento:" + alumnos[alumnos.length-1] );
		
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		String[] days = {"mon","tue","wed","thu","fri","sat","sun"};
		
		System.out.println( months[0]+" "+months[10]+" "+months[6]+" "+months[11]+" "+months[2] );
		System.out.println( days[0]+" "+days[4]+" "+days[1]);

	}

}
