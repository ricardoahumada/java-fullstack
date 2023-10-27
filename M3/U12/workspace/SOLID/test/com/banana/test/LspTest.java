package com.banana.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.banana.pojos.shape.Rectangle;
import com.banana.pojos.shape.Square;
import com.banana.util.Client;

public class LspTest {
	
	@Test
	public void testRectangleArea() {
		Rectangle r = new Rectangle();
        Client c = new Client();
		
        assertTrue(c.areaVerifier(r));
	}
	
	@Test
	public void testSquareArea() {
		Square s = new Square();
        Client c = new Client();
		
        assertTrue(c.areaVerifier(s));
	}

}
