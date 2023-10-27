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
			DBConnector dbc = DBConnector.getInstance();
			List<Maquillaje> listaMaquillajes = dbc.getMakeupsOptions();
			request.setAttribute("listaMaquillajesAMostrar", listaMaquillajes);

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

			int cosmetico = request.getParameter("cosmetico") != null
					? Integer.parseInt(request.getParameter("cosmetico")) : 0;
			int cantidad = request.getParameter("cantidad") != null
					? Integer.parseInt(request.getParameter("cantidad")) : 0;

			if (cosmetico > 0 && cantidad > 0) {

				Usuario elUsuario = (Usuario) misession.getAttribute("usuario");
				DBConnector dbc = DBConnector.getInstance();

				Calendar today = Calendar.getInstance();
				Date todayDate = today.getTime();
				
				Maquillaje unMaq= dbc.getCosmetico(cosmetico);

				Compra nuevaCompra = new Compra(0, elUsuario, unMaq, cantidad, todayDate);

				if (!dbc.insertCompra(nuevaCompra)) {
					request.setAttribute("error", "No se ha podido terminar el proceso :-(. Vuelve a intentarlo...");
					doGet(request, response);
				} else {
					request.getRequestDispatcher("lista_maquillajes").forward(request, response);
				}
				
			} else {
				request.setAttribute("error", "Selecciona un cosmético e indica una cantidad igual o mayor a uno");
				doGet(request, response);
			}
		} else {
			misession.invalidate();
			response.sendRedirect("login");
		}
	}

}
