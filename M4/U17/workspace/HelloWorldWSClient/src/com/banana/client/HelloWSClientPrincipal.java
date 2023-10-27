package com.banana.client;

import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.banana.HelloInterface;
import com.banana.HelloInterfaceProxy;

public class HelloWSClientPrincipal {

	public static void main(String[] args) throws RemoteException  {
		HelloInterface helloInterface = new HelloInterfaceProxy("http://localhost:8080//HelloWorldWS/HelloImplementationService");
		String myresult=helloInterface.hello("Ricardo 245");
		
		System.out.println("Resultado: " + myresult);
		
		Pattern p = Pattern.compile("(hola|ricardo)");
		Matcher m = p.matcher(myresult.toLowerCase());
		
		while (m.find()) {
			System.out.println("Encontrado: " + m.group() );
		}
		
		p = Pattern.compile("\\d+");
		m = p.matcher(myresult.toLowerCase());
		if(!m.find())System.out.println("Sin número!! ");
		else System.out.println("Con número!!: "+ m.group());
		
	}

}
