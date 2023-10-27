package com.banana.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.banana.model.User;

/**
 * Servlet implementation class JSONServlet
 */
@MultipartConfig
@WebServlet("/JSONServlet")
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> listaUsuarios = new ArrayList<User>();
		listaUsuarios.add(new User("Juan",23.4,236));
		listaUsuarios.add(new User("Luisa",45.8,149));
		listaUsuarios.add(new User("Pedro",12.9,24));
		
		ObjectMapper mapper = new ObjectMapper();
		
		String arrayToJson =  mapper.writeValueAsString(listaUsuarios);
    	System.out.println("1. Convert List of person objects to JSON :");
    	System.out.println(arrayToJson);
		
    	response.setContentType("application/json");
    	response.getWriter().print(arrayToJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
