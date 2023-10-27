package com.banana.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banana.db.DBConnector;
import com.banana.db.DBConnectorSingle;
import com.banana.pojos.Customer;

/**
 * Servlet implementation class ConnectServlet
 */
@WebServlet("/connect")
public class ConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("ConnectServlet");
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> listacustomers=null;
		
		// TODO Auto-generated method stub
		try {
			//DBConnector myconnector= new DBConnector();
			//listacustomers=myconnector.executeSELECT();
			
			DBConnectorSingle myConnectorSingle = DBConnectorSingle.getInstance();
			listacustomers=myConnectorSingle.executeSELECT();
		} catch (Exception e) {
			response.getWriter().append("Excepción: "+e.getMessage());
		}
		
		request.setAttribute("customers", listacustomers);
		request.getRequestDispatcher("showselect.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
