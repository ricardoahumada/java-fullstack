package com.banana.controllers;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession misession= (HttpSession)request.getSession();
		
		if( misession.getAttribute("idUsuario")!=null ){
			request.getRequestDispatcher("/lista_maquillajes").forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String contrasena = request.getParameter("password");
				
		if( email.equals("pepe@e.es") && contrasena.equals("lucas") ){
			HttpSession misession= (HttpSession)request.getSession();
			misession.setAttribute("idUsuario", "pepe@e.es");
			
			request.getRequestDispatcher("/lista_maquillajes").forward(request, response);
		}else{
			request.setAttribute("mierror", "Email y contraseña erroneos");
			doGet(request, response);
		}
		
	}

}
