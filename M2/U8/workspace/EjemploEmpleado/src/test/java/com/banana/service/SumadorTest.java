package com.banana.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumadorTest {

	@Test
	public void validaSuma(){
		int a=1,b=2;
		assertTrue( a+b==new Sumador().suma(a, b) );
	}
	
	@Test
	public void validaNegSuma(){
		int a=1,b=2;
		assertNotEquals(4,new Sumador().suma(a, b));
	}
	
}
