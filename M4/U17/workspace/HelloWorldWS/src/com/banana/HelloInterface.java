package com.banana;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding
public interface HelloInterface {
	@WebMethod
	public String hello(String anme);
	
	@WebMethod
	public String getXML(String xmlid);
}
