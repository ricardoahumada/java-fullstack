package com.banana.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banana.pojos.Customer;

public class DBConnector {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/connector";
	private static final String user = "admin7TCylCw";
	private static final String password = "n3NrUEq4-AJC";
	
	public DBConnector() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	}
	
	public List<Customer> executeSELECT() throws Exception{
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
		stmt.close();
		conn.close();

		return listaRespuesta;
		
	}
}
