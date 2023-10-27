package com.banana.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.banana.pojos.Customer;

public class CustomerDAOIfImpl implements CustomerDAOIf {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/sqltraining";
	private static final String user = "sqltrainer";
	private static final String password = "trainer";
	private static Logger logger = Logger.getLogger("DBConnectorSingle");

	@Override
	public List<Customer> getAllCustomers() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		ArrayList<Customer> listaRespuesta = new ArrayList<Customer>();
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement stmt = conn.createStatement();

		Customer acustomer = null;

		// stmt.executeUpdate("INSERT INTO mytable " + "VALUES (2, 'Dna', 'Log',
		// '0')");
		ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
		while (rs.next()) {
			acustomer = new Customer();
			acustomer.id = rs.getInt("CustomerID");
			acustomer.name = rs.getString("CustomerName");
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
