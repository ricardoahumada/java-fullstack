package com.banana.model;

public class TipoEmpleado {
	public boolean vendedor;
	public boolean encargado;
	
	public TipoEmpleado(boolean es_vendedor){
		if(es_vendedor) {this.vendedor=true;this.encargado=false;}
		else {this.vendedor=false;this.encargado=true;}
	}
}
