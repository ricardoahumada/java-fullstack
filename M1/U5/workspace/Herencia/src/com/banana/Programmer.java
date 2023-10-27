package com.banana;

import java.util.Iterator;

public class Programmer extends Employee {

	String[] lenguajes;
	int gradoDeFrikismo;
	int estadoCalvicie;
	String gradoSocializacion;

	public Programmer(int id, String name, Address address, Department department, String[] lenguajes,int gradoDeFrikismo, int estadoCalvicie, String gradoSocializacion) {
		super(id, name, address, department);
		
		this.lenguajes=lenguajes;
		this.gradoDeFrikismo=gradoDeFrikismo;
		this.gradoSocializacion=gradoSocializacion;
		this.estadoCalvicie=estadoCalvicie;
	}

	
	@Override
	public String showData() {
		String ownData="";
		
		if(this.lenguajes!=null) for(String aLang:this.lenguajes){
			ownData+=aLang+":";
		}
		
		ownData+="\n"+this.gradoDeFrikismo+":"+this.estadoCalvicie+":"+this.gradoSocializacion+"\n";
		
		return super.showData()+ownData;
	}
	
	
}
