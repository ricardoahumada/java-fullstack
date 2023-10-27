package com.banana;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloImplementation implements HelloInterface {
	@WebMethod
	public String hello(String aname) {
		return "<valor>"+aname+"</valor>";
	}
	
	@WebMethod
	public String getXML(String xmlid){
		return "<libreria>"+
	"<libro id=\"1\">"+
		"<titulo>El silencio de los corderos</titulo>"+
		"<autor>No lo se</autor>"+
	"</libro>"+
	"<libro id=\"2\">"+
		"<titulo>El silencio de los corderos</titulo>"+
		"<autor>No lo se</autor>"+
	"</libro>"+
	"<libro id=\"3\">"+
		"<titulo>El silencio de los corderos</titulo>"+
		"<autor>No lo se</autor>"+
	"</libro>"+
	"<libro id=\"4\">"+
		"<titulo>El silencio de los corderos</titulo>"+
		"<autor>No lo se</autor>"+
	"</libro>"+
"</libreria>";
		
	}
	
}
