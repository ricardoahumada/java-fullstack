package com.netmind.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import com.netmind.models.Compra;
import com.netmind.models.Maquillaje;

public final class CompraDAOImpl extends CompraDAO {
	private static Logger logger = Logger.getLogger("CompraDAOImpl");

	private static CompraDAOImpl instance = null;

	public static CompraDAOImpl getInstance() {
		if (instance == null) {
			instance = new CompraDAOImpl();
		}
		return instance;
	}

	@Override
	public Compra getCompra(int cid) {
		Compra compraADevolver = null;

		try {
			Connection conn = this.datasource.getConnection();
			// ordenes sql
			String sql = "SELECT c.* FROM compra c WHERE c.cid=? LIMIT 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cid);
			
			UsuarioDAO uDAO=(UsuarioDAO)UsuarioDAOImpl.getInstance();
			MaquillajeDAO mDAO=(MaquillajeDAO)MaquillajeDAOImpl.getInstance();

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {

				compraADevolver = new Compra(cid,
						uDAO.getUsuario(rs.getInt("usuario")),
						mDAO.getMaquillaje(rs.getInt("cosmetico")), 
						rs.getInt("cantidad"), 
						rs.getDate("fecha"));
			}

			pstm.close();
			conn.close();

			logger.info("Conexi�n exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexi�n de BBDD:" + e);
			compraADevolver = null;
		}

		return compraADevolver;
	}

	@Override
	public boolean delCompra(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertCompra(Compra nuevaCompra) {
		boolean exito = false;

		try {

			Connection conn = this.datasource.getConnection();

			try {
				conn.setAutoCommit(false);

				// INSERTAR EN COMPRA
				String sql = "INSERT INTO compra VALUES(NULL,?,?,?,?)";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, nuevaCompra.getUsuario().getUid());
				pstm.setInt(2, nuevaCompra.getCosmetico().getMid());
				pstm.setInt(3, nuevaCompra.getCantidad());

				SimpleDateFormat sdfr = new SimpleDateFormat("yyyyMMdd");
				pstm.setString(4, sdfr.format(nuevaCompra.getFecha()));

				int rows = pstm.executeUpdate();

				pstm.close();

				// ACTUALIZAR SALDO DE USUARIO
				sql = "UPDATE usuario u SET u.saldo=u.saldo-? WHERE u.uid=?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, nuevaCompra.getCosmetico().getPrecio() * nuevaCompra.getCantidad());
				pstm.setInt(2, nuevaCompra.getUsuario().getUid());
				rows = pstm.executeUpdate();

				pstm.close();

				// ACTUALIZAR EXISTENCIAS DE MAQUILLAJE
				sql = "UPDATE maquillaje m SET m.existencias=m.existencias-? WHERE m.mid=?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, nuevaCompra.getCantidad());
				pstm.setInt(2, nuevaCompra.getCosmetico().getMid());
				rows = pstm.executeUpdate();

				pstm.close();

				conn.commit();

				conn.close();

				logger.info("Inserci�n exitosa");
				exito = rows > 0 ? true : false;

			} catch (Exception e) {
				conn.rollback();
				logger.severe("Transacci�n fallida:" + e.getMessage());
				exito = false;
			}

		} catch (Exception e) {
			logger.severe("Error en la conexi�n de BBDD:" + e.getMessage());
			exito = false;
		}

		return exito;
	}

	@Override
	public boolean updateCompra(Compra compra) {
		// TODO Auto-generated method stub
		return false;
	}
}
