package com.banana.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.banana.db.dao.CustomerDAO;
import com.banana.db.dao.CustomerDAOImpl;
import com.banana.pojos.Customer;

/**
 * Servlet implementation class PoolConnectServlet
 */
@WebServlet("/poolconnect")
public class PoolConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;
    private Connection connection;
    private Statement statement;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PoolConnectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        try {
            // Get DataSource
            Context initContext  = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/sqltrainer");
 
             
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet resultSet = null;
		List<Customer> listacustomers=null;
        try {
        	
        	//aDAO.connect();
        	
            // Get Connection and Statement
            /*connection = dataSource.getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM customers";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
            }*/
        	
        	CustomerDAO aDAO= CustomerDAOImpl.getInstance();
        	listacustomers=aDAO.getAllCustomersPool();
            
            request.setAttribute("customers", listacustomers);
    		request.getRequestDispatcher("showselect.jsp").forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try { if(null!=resultSet)resultSet.close();} catch (SQLException e) 
            {e.printStackTrace();}
            try { if(null!=statement)statement.close();} catch (SQLException e) 
            {e.printStackTrace();}
            try { if(null!=connection)connection.close();} catch (SQLException e) 
            {e.printStackTrace();}
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
