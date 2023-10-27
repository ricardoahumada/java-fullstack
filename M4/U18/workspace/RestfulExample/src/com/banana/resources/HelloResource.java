package com.banana.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.banana.models.User;

@Path("/mundo")
public class HelloResource {
	
	@Path("/hola")
	@GET
	public String sayHello(){
		return "Hola mundo";
	}
	
	@Path("/adios")
	@GET
	public String sayGoodBye(){
		return "Adios mundo cruel";
	}
	
}
