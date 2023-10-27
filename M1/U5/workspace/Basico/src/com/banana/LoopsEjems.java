package com.banana;

public class LoopsEjems {

	public static void main(String[] args) {
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		
		for(int i=0;i<months.length;i++){
			//System.out.println("for:"+months[i]);
		}
		
		System.out.println("");
		
		for(String unMes:months){
			//System.out.println("for-each:"+unMes);
		}
		
		String valorConcatenado ="";
		for(int i=0;i<months.length;i++){
			//if(i!=months.length-1) valorConcatenado+=months[i]+", ";
			//else valorConcatenado+=months[i];
			
			valorConcatenado+=months[i]+((i!=months.length-1)?", ":"");
		}
		
		System.out.println(valorConcatenado);
		
	}

}
