import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ncm.DAO.ClienteDAO;
import com.ncm.DAO.DAOFactory;
import com.ncm.modelos.Cliente;

public class TestClienteDAO extends Testbanana {
	private static Logger logger = Logger.getLogger("TestClienteDAO");

	@BeforeClass
	public static void setUpClass() {
		setUpContext();
	}

	@Test
	public void testListaClientes() {

		logger.log(Level.INFO, "Entrando al test...");

		try {
			ClienteDAO cDAO = (ClienteDAO) DAOFactory.getDao("cliente");
			// logger.log(Level.INFO,"obtenido Factory...");
			List<Cliente> listaDeCliente = cDAO.getClientesForUser(1);
			logger.log(Level.INFO, "listaDeCliente..." + listaDeCliente);
			assertTrue(listaDeCliente != null && !listaDeCliente.isEmpty());

		} catch (Exception ex) {
			fail();
			ex.printStackTrace();
			System.out.println("Error en DAO:" + ex);
		}

		logger.log(Level.INFO, "Fin de test...");
	}

	@Test
	public void testCrearCliente() {

		logger.log(Level.INFO, "Entrando al test...");

		try {
			ClienteDAO cDAO = (ClienteDAO) DAOFactory.getDao("cliente");
			boolean cid = false;
			Cliente aCliente = new Cliente();
			aCliente.setPropietario(1);
			aCliente.setNombre("N1");
			aCliente.setDireccion("D1");
			aCliente.setTelefono(1234567);
			aCliente.setMovil(1234567);
			aCliente.setEmail("E1@gmail.com");
			aCliente.setStatus(1);
			aCliente.setEmpresa("Empresa1");
			aCliente.setNif("1234567B");
			aCliente.setPais("Pais1");

			// logger.log(Level.INFO,"obtenido Factory...");
			cid = (boolean) cDAO.createClienteForUser(aCliente, aCliente.getPropietario());
			logger.log(Level.INFO, "IdCliente... " + cid);
			assertTrue(cid != false);

		} catch (Exception ex) {
			fail();
			ex.printStackTrace();
			System.out.println("Error en DAO:" + ex);
		}

		logger.log(Level.INFO, "Fin de test...");
	}
	

	
	
	@Test
	public void testUpdateCliente() {

		logger.log(Level.INFO, "Entrando al test...");

		try {
			ClienteDAO cDAO = (ClienteDAO) DAOFactory.getDao("cliente");
			boolean cid = false;
			Cliente aCliente = new Cliente();
			aCliente.setCid(4);
			aCliente.setPropietario(1);
			aCliente.setNombre("vvvvbbN1");
			aCliente.setDireccion("bbD1");
			aCliente.setTelefono(1234567);
			aCliente.setMovil(1234567);
			aCliente.setEmail("bbE1@gmail.com");
			aCliente.setStatus(1);
			aCliente.setEmpresa("bbEmpresa1");
			aCliente.setNif("bb1234567B");
			aCliente.setPais("bbPais1");

			// logger.log(Level.INFO,"obtenido Factory...");
			cid = (boolean) cDAO.updateClienteForUser(aCliente, aCliente.getPropietario());
			logger.log(Level.INFO, "IdCliente... " + cid);
			assertTrue(cid != false);

		} catch (Exception ex) {
			fail();
			ex.printStackTrace();
			System.out.println("Error en DAO:" + ex);
		}

		logger.log(Level.INFO, "Fin de test...");
	}
		
	
	
	
	

	@Test
	public void testDeleteCliente() {

		logger.log(Level.INFO, "Entrando al test...");
		boolean borrado = false;
		try {
			ClienteDAO cDAO = (ClienteDAO) DAOFactory.getDao("cliente");
			// logger.log(Level.INFO,"obtenido Factory...");
			borrado = cDAO.deleteClienteForUser(5, 1);
			logger.log(Level.INFO, "Borrado... " + borrado);
			assertTrue(borrado != false);

		} catch (Exception ex) {
			fail();
			ex.printStackTrace();
			System.out.println("Error en DAO:" + ex);
		}

		logger.log(Level.INFO, "Fin de test...");
	}

	
	
}