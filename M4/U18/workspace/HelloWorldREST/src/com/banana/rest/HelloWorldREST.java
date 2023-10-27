package com.banana.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.banana.model.User;

@Path("/hello")
public class HelloWorldREST {
	@Path("getxml")
	@GET
	@Produces("application/xml")
	public String hello(@QueryParam("name") String aname){
		return "<result>Hello: "+aname+"</result>";
	}
	
	@Path("gettxt")
	@GET
	@Produces("application/text")
	public String hellotxt(@QueryParam("name") String aname){
		return "Hello: "+aname;
	}
	
	@Path("getjson")
	@GET
	@Produces("application/json")
	public String hellojson(@QueryParam("name") String aname){
		return "{result:Hello "+aname+"}";
	}
	
	@Path("post")
	@POST
	@Produces("application/text")
	public String hellotrans(@QueryParam("name") String aname){
		return ("Hello: "+aname).toLowerCase();
	}
	
	@Path("getform")
	@POST
	@Produces("application/text")
	public String getform(@QueryParam("name") String aname){
		return ("Hello: "+aname).toLowerCase();
	}
	
	/*@Path("postuser")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<User> hellouser(User tUser){
		System.out.println(tUser);
		List<User> list = new ArrayList<User>();
        list.add(tUser);
        return list;
	}*/
}
