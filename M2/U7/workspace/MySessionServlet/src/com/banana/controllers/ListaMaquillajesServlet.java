package com.banana.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banana.models.Maquillaje;

@WebServlet("/lista_maquillajes")
public class ListaMaquillajesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misession= (HttpSession)request.getSession();
		
		if( misession.getAttribute("idUsuario")!=null ){
			Maquillaje[] listaMaquillajes = {
					new Maquillaje("Max Factor", "labios", 10),
					new Maquillaje("LOreal", "cabello", 20),
					new Maquillaje("Esteer Lauder", "ojos", 30)
			};
			
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
