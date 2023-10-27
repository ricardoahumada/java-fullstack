package com.banana.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.banana.model.TipoEmpleado;

public class EmpleadoBRTest {

	/*@Test
	public void testCalculaSalarioBruto() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculaSalarioNeto() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testCalculaSalarioBruto1() {
		EmpleadoBR ebr = new EmpleadoBR();

		float resultadoReal = ebr.calculaSalarioBruto(new TipoEmpleado(true), 2000.0f, 8.0f);
		float resultadoEsperado = 1360.0f;
		assertEquals(resultadoEsperado, resultadoReal, 0.01f);
	}

}
