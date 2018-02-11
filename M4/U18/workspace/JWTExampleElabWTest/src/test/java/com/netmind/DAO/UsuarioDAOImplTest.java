package com.netmind.DAO;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.netmind.DAO.DAOFactory;
import com.netmind.DAO.UsuarioDAO;
import com.netmind.modelos.Usuario;
import com.netmind.test.TestNetmind;
import com.netmind.util.NoExisteException;;

public class UsuarioDAOImplTest extends TestNetmind {
	private static Logger logger = Logger.getLogger("UserResourceTest");

	@BeforeClass
	public static void setUpClass() {
		setUpContext();
	}

	@Test
	public void testGetUsuarioCase1() {

		logger.log(Level.INFO, "Entrando al test...");

		try {
			String email = "juan@gmail.com", pass = "md5_coded";

			UsuarioDAO uDAO = (UsuarioDAO) DAOFactory.getDao("usuario");
			Usuario u = uDAO.getUsuario(email, pass);
			logger.log(Level.INFO, "Usuario..." + u);
			assertTrue(u != null && !u.getEmail().equals(""));

		} catch (Exception ex) {
			fail();
			ex.printStackTrace();
			System.out.println("Error en DAO:" + ex);
		}

		logger.log(Level.INFO, "Fin de test...");
	}

	@Test
	public void testGetUsuarioByMailCase1() {

		logger.log(Level.INFO, "Entrando al test email null...");

		try {
			String email = null;

			UsuarioDAO uDAO = (UsuarioDAO) DAOFactory.getDao("usuario");
			Usuario u = uDAO.getUsuarioByMail(email);
			logger.log(Level.INFO, "Usuario..." + u);
			assertTrue(u == null);

		} catch (Exception ex) {
			fail();
			ex.printStackTrace();
			System.out.println("Error en DAO:" + ex);
		}

	}

	@Test
	public void testGetUsuarioByMailCase2() {

		logger.log(Level.INFO, "Entrando al test email SQL...");

		try {
			String email = "Select * from *";

			UsuarioDAO uDAO = (UsuarioDAO) DAOFactory.getDao("usuario");
			Usuario u = uDAO.getUsuarioByMail(email);
			logger.log(Level.INFO, "Usuario..." + u);
			assertTrue(u == null);

		} catch (Exception ex) {
			fail();
			ex.printStackTrace();
			System.out.println("Error en DAO:" + ex);
		}

	}

	@Test
	public void testGetUsuarioEmailNoexiste() {
		logger.log(Level.INFO, "Entrando al test email que no existe...");

		try {
			UsuarioDAO uDAO = (UsuarioDAO) DAOFactory.getDao("usuario");
			Usuario u = uDAO.getUsuario("e@e.es", "xxx");
			logger.log(Level.INFO, "Usuario..." + u);
			fail("No ha lanzado excepci�n con un error negativo");
		} catch (NoExisteException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			fail("Devuelve otra excepci�n");
		}
	}

	@Test
	public void testGetUsuario_EmailPassCorrect() {
		logger.log(Level.INFO, "Entrando al test EmailPassCorrect...");

		try {
			UsuarioDAO uDAO = (UsuarioDAO) DAOFactory.getDao("usuario");
			Usuario u = uDAO.getUsuario("juan@gmail.com", "md5_coded");
			logger.log(Level.INFO, "Usuario..." + u);
			assertTrue(u.getUid() == 1 && u.getNombre().equals("Juan") && u.getEmpresa().equals("Empresa SL"));
		} catch (Exception ex) {
			fail("Devuelve excepci�n:" + ex);
		}
	}
	
	@Test
	public void testGetUsuario_NullNull() {
		logger.log(Level.INFO, "Entrando al test NullNull...");

		try {
			UsuarioDAO uDAO = (UsuarioDAO) DAOFactory.getDao("usuario");
			Usuario u = uDAO.getUsuario(null, null);
			logger.log(Level.INFO, "Usuario..." + u);
			fail("No ha lanzado excepci�n con un error negativo");
		} catch (NoExisteException ex) {
			assertTrue(true);
		} catch (Exception ex) {
			fail("Devuelve otra excepci�n");
		}
	}

}
