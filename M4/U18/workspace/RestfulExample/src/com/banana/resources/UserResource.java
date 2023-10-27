package com.banana.resources;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.banana.models.User;
import com.banana.models.Message;

@Path("/usuarios")
public class UserResource {

	private static List<User> misUsuarios;

	static {
		misUsuarios = new ArrayList<User>();

		misUsuarios.add(new User(1, "Ric", "AG", "r@e.es"));
		misUsuarios.add(new User(2, "Juana", "Juanasson", "j@e.es"));
		misUsuarios.add(new User(3, "Pepa", "Pepasson", "p@e.es"));
	}

	// -------------------------------------------------------

	/* GET|POST /usuarios */
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserList() {
		return this.misUsuarios;
	}

	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message insertUsuario(User nuevoUser) {
		this.misUsuarios.add(nuevoUser);
		return new Message("Usuario añadido");
	}

	/* GET|PUT|DELETE /usuarios/{uid} */
	@Path("/{uid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("uid") int uid) {

		User unUser = new User();
		unUser.setUid(uid);
		unUser.setEmail("r@e.es");
		unUser.setName("Robert " + uid);
		unUser.setSurname("Redford " + uid);

		return unUser;
	}
	
	@Path("/{uid}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateUser(@PathParam("uid") int uid,User aUser) {
		for (User user : misUsuarios) {
			if(user.getUid()==uid){
				misUsuarios.remove(user);
				misUsuarios.add(aUser);
				break;
			}
		}

		return new Message("Usuario modificado");
	}
	
	@Path("/{uid}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteUser(@PathParam("uid") int uid) {
		for (User user : misUsuarios) {
			if(user.getUid()==uid){
				misUsuarios.remove(user);
				break;
			}
		}

		return new Message("Usuario borrado");
	}
	

}
