package com.banana.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banana.db.DBConnector;
import com.banana.models.Compra;
import com.banana.models.Maquillaje;
import com.banana.models.Usuario;

@WebServlet("/comprar")
public class ComprarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession misession = (HttpSession) request.getSession();

		if (misession.getAttribute("usuario") != null) {
			request.getRequestDispatcher("comprar.jsp").forward(request, response);
		} else {
			misession.invalidate();
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession misession = (HttpSession) request.getSession();

		if (misession.getAttribute("usuario") != null) {
			Usuario elUsuario=(Usuario) misession.getAttribute("usuario");
			DBConnector dbc= DBConnector.getInstance();
			
			Calendar today = Calendar.getInstance();
			today.clear(Calendar.HOUR); today.clear(Calendar.MINUTE); today.clear(Calendar.SECOND);
			Date todayDate = today.getTime();
			
			Compra nuevaCompra = new Compra(0, elUsuario.getUid(), 1, 4, todayDate);
			
			if( !dbc.insertCompra(nuevaCompra) ){
				request.setAttribute("error", "No se ha podido comprar!!");
				doGet(request, response);
			}else{
				request.getRequestDispatcher("lista_maquillajes").forward(request, response);
			}
		} else {
			misession.invalidate();
			response.sendRedirect("login");
		}
	}

}
