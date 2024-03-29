package com.banana.controllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banana.db.DBConnector;
import com.banana.models.Maquillaje;
import com.banana.models.Usuario;

@WebServlet("/lista_maquillajes")
public class ListaMaquillajesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("ListaMaquillajesServlet");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misession= (HttpSession)request.getSession();
		
		if( misession.getAttribute("usuario")!=null ){
			Usuario elUsuario=(Usuario) misession.getAttribute("usuario");
			DBConnector dbc= DBConnector.getInstance();
			List<Maquillaje> listaMaquillajes = dbc.getUserMakeups( elUsuario.getUid() );
			request.setAttribute("listaMaquillajesAMostrar", listaMaquillajes);
			
			request.getRequestDispatcher("plantilla_maquillajes.jsp").forward(request, response);
		}else{
			misession.invalidate();
			response.sendRedirect("login");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ESTOY EN POST!!");
		doGet(request, response);
	}

}
