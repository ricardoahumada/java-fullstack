package com.banana.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.banana.db.dao.CustomerDAO;
import com.banana.db.dao.CustomerDAOImpl;
import com.banana.pojos.Customer;

public class DBTests {
	private static Logger logger=Logger.getLogger("DBTests");
	
	@BeforeClass
	public static void setUpClass() throws Exception {
        // rcarver - setup the jndi context and the datasource
        try {
            // Create initial context
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.naming.java.javaURLContextFactory");
            System.setProperty(Context.URL_PKG_PREFIXES, 
                "org.apache.naming");            
            InitialContext ic = new InitialContext();

            ic.createSubcontext("java:");
            ic.createSubcontext("java:/comp");
            ic.createSubcontext("java:/comp/env");
            ic.createSubcontext("java:/comp/env/jdbc");
           
            // Construct DataSource
            MysqlDataSource  ds = new MysqlDataSource ();
            ds.setURL("jdbc:mysql://127.0.0.1:3306/sqltraining");
            ds.setUser("sqltrainer");
            ds.setPassword("trainer");
            
            ic.bind("java:/comp/env/jdbc/sqltrainer", ds);
        } catch (NamingException ex) {
        	logger.log(Level.SEVERE,ex.getMessage());
        	ex.printStackTrace();
        }
        
    }
	
	/*@Test
	public void testDAO() {
		try {
			CustomerDAO cDao = CustomerDAOImpl.getInstance();
			List<Customer> listaCusts=cDao.getAllCustomers();
			
			System.out.println("Cargando customers: "+listaCusts.size());
			assertTrue( listaCusts!=null && listaCusts.size()>0 );
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception: "+e.getMessage());
		} 
		
		
	}*/
	
	@Test
	public void testDAOIf() {
		try {
			/*CustomerDAOIf cDao = new CustomerDAOIfImpl();
			List<Customer> listaCusts=cDao.getAllCustomers();*/
			
			CustomerDAO cDao = CustomerDAOImpl.getInstance();
			List<Customer> listaCusts=cDao.getAllCustomersPool();
			
			System.out.println("Cargando customers testDAOIf: "+listaCusts.size());
			assertTrue( listaCusts!=null && listaCusts.size()>0 );
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception: "+e.getMessage());
		} 
		
		
	}
	
	

}
