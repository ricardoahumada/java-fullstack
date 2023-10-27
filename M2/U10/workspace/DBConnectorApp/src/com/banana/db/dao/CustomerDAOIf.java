package com.banana.db.dao;

import java.sql.SQLException;
import java.util.List;

import com.banana.pojos.Customer;

public interface CustomerDAOIf {
	public List<Customer> getAllCustomers() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(Customer customer);
	public int addCustomer(Customer customer);
}
