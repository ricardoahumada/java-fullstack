package com.netmind.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import com.netmind.util.PropertyValues;

public class PropertiesTest {

	@Test
	public void test() {
		PropertyValues pv = new PropertyValues();
		Properties prop;
		try {
			prop = pv.getPropValues();
			System.out.println( prop.getProperty("user") );
			assertTrue(prop.getProperty("user").contains("sqltrainer"));
		} catch (IOException e) {
			fail("Excepci�n al leer propiedades: "+ e);
		}
		
		
	}

}
