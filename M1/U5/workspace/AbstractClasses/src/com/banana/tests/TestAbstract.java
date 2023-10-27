package com.banana.tests;

import com.banana.models.Animal;
import com.banana.models.Humano;
import com.banana.models.Leon;

public class TestAbstract {
	
	public static void main(String[] args) {
		Animal unLeon = new Leon();
		Animal unHumano = new Humano();
		
		unLeon.respirar();
		unLeon.emitirOnomatopeya();
		unLeon.mover(100);
		unLeon.morir();
		
		unHumano.respirar();
		unHumano.emitirOnomatopeya();
		unHumano.mover(100);
		unHumano.morir();
	}
	
}
