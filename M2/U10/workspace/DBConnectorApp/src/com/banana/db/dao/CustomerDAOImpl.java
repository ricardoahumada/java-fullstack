package com.banana.db.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import com.banana.pojos.Customer;

public class CustomerDAOImpl extends CustomerDAO{
	private static CustomerDAOImpl instance = null;
	private static Logger logger=Logger.getLogger("CustomerDAOImpl");
	
	protected CustomerDAOImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
	}

	public static CustomerDAO getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		if (instance == null) {
			instance = new CustomerDAOImpl();
		}

		return instance;
	}
	
	public void connect() throws Exception{
		Connection connection = dataSource.getConnection();
	}
	
	@Override
	public List<Customer> getAllCustomers() throws Exception {
		ArrayList<Customer> listaRespuesta=new ArrayList<Customer>();
		// Load the Connector/J driver
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement stmt = conn.createStatement();
		
		Customer acustomer=null;
		
		//stmt.executeUpdate("INSERT INTO mytable " + "VALUES (2, 'Dna', 'Log', '0')");
		ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
		while (rs.next()) {
			acustomer=new Customer();
			acustomer.id = rs.getInt("CustomerID");
			acustomer.name= rs.getString("CustomerName");
			acustomer.ContactName = rs.getString("ContactName");
			acustomer.address = rs.getString("Address");
			acustomer.City = rs.getString("City");
			acustomer.PostalCode = rs.getString("PostalCode");
			acustomer.Country = rs.getString("Country");
		    
			listaRespuesta.add(acustomer);
		}
		rs.close();
		stmt.close();
		conn.close();

		return listaRespuesta;
	}
	
	public List<Customer> getAllCustomersPool() throws Exception {
		ArrayList<Customer> listaRespuesta=new ArrayList<Customer>();
		// Load the Connector/J driver
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		
		Customer acustomer=null;
		
		//stmt.executeUpdate("INSERT INTO mytable " + "VALUES (2, 'Dna', 'Log', '0')");
		logger.log(Level.INFO, "*****In getAllCustomersPool..");
		ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
		while (rs.next()) {
			acustomer=new Customer();
			acustomer.id = rs.getInt("CustomerID");
			acustomer.name= rs.getString("CustomerName");
			acustomer.ContactName = rs.getString("ContactName");
			acustomer.address = rs.getString("Address");
			acustomer.City = rs.getString("City");
			acustomer.PostalCode = rs.getString("PostalCode");
			acustomer.Country = rs.getString("Country");
		    
			listaRespuesta.add(acustomer);
		}
		rs.close();
		stmt.close();
		conn.close();

		return listaRespuesta;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

}
