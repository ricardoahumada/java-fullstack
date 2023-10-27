package com.banana.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.banana.models.Compra;
import com.banana.models.Maquillaje;
import com.banana.models.Usuario;

public class DBConnector {
	private static Logger logger = Logger.getLogger("DBConnector");

	private DataSource datasource;

	private static DBConnector instance = null;

	public static DBConnector getInstance() {
		if (instance == null) {
			instance = new DBConnector();
		}
		return instance;
	}

	protected DBConnector() {
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env"); 
			this.datasource = (DataSource)envContext.lookup("jdbc/maquillajedb");
		}catch (Exception e) {
			logger.info("Error al instanciar Datasource!!!!");
			e.printStackTrace();
		}

	}

	public boolean existeUsuario(String email, String pass) {

		try {
			Connection conn = this.datasource.getConnection();

			// ordenes sql
			String sql = "SELECT u.* FROM usuario u WHERE u.email=? AND password=? LIMIT 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, pass);

			ResultSet rs = pstm.executeQuery();

			boolean existeUsuario = false;
			if (rs.next()) {
				existeUsuario = true;
			}

			pstm.close();
			conn.close();

			logger.info("Conexión exitosa");

			return existeUsuario;
		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			return false;
		}

	}

	public Usuario getUsuario(String email, String pass) {
		Usuario usuarioADevolver = null;

		try {
			Connection conn = this.datasource.getConnection();
			// ordenes sql
			String sql = "SELECT u.* FROM usuario u WHERE u.email=? AND password=? LIMIT 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, pass);

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {

				usuarioADevolver = new Usuario(rs.getInt("uid"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("email"), rs.getString("coquetitud"), rs.getDouble("saldo"), "",
						rs.getDate("nacimiento"), rs.getInt("activo"));
			}

			pstm.close();
			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			usuarioADevolver = null;
		}

		return usuarioADevolver;
	}

	public List<Maquillaje> getUserMakeups(int uid) {
		List<Maquillaje> listADevolver = new ArrayList<Maquillaje>();

		try {
			Connection conn = this.datasource.getConnection();

			// ordenes sql
			String sql = "SELECT m.* FROM maquillaje m INNER JOIN compra c ON c.cosmetico=m.mid WHERE c.usuario=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				listADevolver.add(new Maquillaje(rs.getInt("mid"), rs.getString("codigo"), rs.getString("marca"),
						rs.getString("tipo"), rs.getInt("precio"), rs.getInt("existencias")));
			}

			pstm.close();

			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			listADevolver = null;
		}

		return listADevolver;
	}

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

				logger.info("Inserción exitosa");
				exito = rows > 0 ? true : false;

			} catch (Exception e) {
				conn.rollback();
				logger.severe("Transacción fallida:" + e.getMessage());
				exito = false;
			}

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e.getMessage());
			exito = false;
		}

		return exito;
	}

	public List<Maquillaje> getMakeupsOptions() {
		List<Maquillaje> listADevolver = new ArrayList<Maquillaje>();

		try {
			Connection conn = this.datasource.getConnection();

			// ordenes sql
			String sql = "SELECT m.* FROM maquillaje m WHERE 1";
			PreparedStatement pstm = conn.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				listADevolver.add(new Maquillaje(rs.getInt("mid"), rs.getString("codigo"), rs.getString("marca"),
						rs.getString("tipo"), rs.getInt("precio"), rs.getInt("existencias")));
			}

			pstm.close();

			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			listADevolver = null;
		}

		return listADevolver;
	}

	public Maquillaje getCosmetico(int mid) {
		Maquillaje maquillajeADevolver = null;

		try {
			Connection conn = this.datasource.getConnection();
			// ordenes sql
			String sql = "SELECT m.* FROM maquillaje m WHERE m.mid=? LIMIT 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, mid);

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {

				maquillajeADevolver = new Maquillaje(rs.getInt("mid"), rs.getString("codigo"), rs.getString("marca"),
						rs.getString("tipo"), rs.getInt("precio"), rs.getInt("existencias"));
			}

			pstm.close();
			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			maquillajeADevolver = null;
		}

		return maquillajeADevolver;
	}

}
