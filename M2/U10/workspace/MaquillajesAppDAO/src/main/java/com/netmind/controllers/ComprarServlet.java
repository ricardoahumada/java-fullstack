package com.netmind.controllers;

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

import com.netmind.db.CompraDAO;
import com.netmind.db.CompraDAOImpl;
import com.netmind.db.MaquillajeDAO;
import com.netmind.db.MaquillajeDAOImpl;
import com.netmind.models.Compra;
import com.netmind.models.Maquillaje;
import com.netmind.models.Usuario;

@WebServlet("/comprar")
public class ComprarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession misession = (HttpSession) request.getSession();

		if (misession.getAttribute("usuario") != null) {
			MaquillajeDAO mDAO=(MaquillajeDAO)MaquillajeDAOImpl.getInstance();
			List<Maquillaje> listaMaquillajes = mDAO.getMaquillajes();
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
				MaquillajeDAO mDAO=(MaquillajeDAO)MaquillajeDAOImpl.getInstance();
				CompraDAO cDAO=(CompraDAO)CompraDAOImpl.getInstance();

				Calendar today = Calendar.getInstance();
				Date todayDate = today.getTime();
				
				Maquillaje unMaq= mDAO.getMaquillaje(cosmetico);

				Compra nuevaCompra = new Compra(0, elUsuario, unMaq, cantidad, todayDate);

				if (!cDAO.insertCompra(nuevaCompra)) {
					request.setAttribute("error", "No se ha podido terminar el proceso :-(. Vuelve a intentarlo...");
					doGet(request, response);
				} else {
					request.getRequestDispatcher("lista_maquillajes").forward(request, response);
				}
				
			} else {
				request.setAttribute("error", "Selecciona un cosm�tico e indica una cantidad igual o mayor a uno");
				doGet(request, response);
			}
		} else {
			misession.invalidate();
			response.sendRedirect("login");
		}
	}

}
