package com.banana.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;

import com.banana.models.Department;
import com.banana.models.Employee;
import com.banana.models.Role;  

@WebServlet("/")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		
		Department d1 = new Department("Marketing", "Barcelona");
		
		Role r1=new Role("Programador", "Descripción de programador");
		Role r2=new Role("Marketer", "Descripción de Marketer");
		
		Set<Role> roles=new HashSet<Role>();
		roles.add(r1);
		roles.add(r2);
		
		Employee e1 = new Employee("Ricarda","Juarez",d1);
		e1.setRoles(roles);
		session.persist(e1);

		t.commit();
		session.close();

		System.out.println("successfully saved");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
