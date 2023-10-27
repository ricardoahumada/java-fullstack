package com.banana.db.dao;

import java.util.List;

import com.banana.pojos.Customer;

public abstract class CustomerDAO extends DAO{
	public abstract void connect() throws Exception;
	public abstract List<Customer> getAllCustomers() throws Exception;
	public abstract List<Customer> getAllCustomersPool() throws Exception;
	public abstract boolean updateCustomer(Customer customer);
	public abstract boolean deleteCustomer(Customer customer);
	public abstract int addCustomer(Customer customer);
	
}
