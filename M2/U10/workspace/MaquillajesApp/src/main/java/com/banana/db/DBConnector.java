package com.banana.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.banana.models.Maquillaje;
import com.banana.models.Usuario;

public class DBConnector {
	private static Logger logger = Logger.getLogger("DBConnector");

	public boolean existeUsuario(String email, String pass) {

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/maquillajes?user=maq_user&password=mqll7");

			// ordenes sql
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT u.* FROM usuario u WHERE u.email='" + email + "' AND password='" + pass + "' LIMIT 1");

			boolean existeUsuario = false;
			if (rs.next()) {
				existeUsuario = true;
			}

			stmt.close();
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
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/maquillajes?user=maq_user&password=mqll7");

			// ordenes sql
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT u.* FROM usuario u WHERE u.email='" + email + "' AND password='" + pass + "' LIMIT 1");

			if (rs.next()) {
				
				usuarioADevolver = new Usuario(
						rs.getInt("uid"), 
						rs.getString("nombre"), 
						rs.getString("apellido"), 
						rs.getString("email"), 
						rs.getString("coquetitud"), 
						rs.getDouble("saldo"), 
						"", 
						rs.getDate("nacimiento"), 
						rs.getInt("activo")
						);
			}

			stmt.close();
			
			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			usuarioADevolver=null;
		}
		
		return usuarioADevolver;
	}
	
	public List<Maquillaje> getUserMakeups(int uid){
		List<Maquillaje> listADevolver = new ArrayList<Maquillaje>();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/maquillajes?user=maq_user&password=mqll7");

			// ordenes sql
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT m.* FROM maquillaje m INNER JOIN compra c ON c.cosmetico=m.mid WHERE c.usuario="+uid);
			
			while ( rs.next() ) {
				listADevolver.add( new Maquillaje(
						rs.getInt("mid"), 
						rs.getString("codigo"), 
						rs.getString("marca"), 
						rs.getString("tipo"),
						rs.getInt("precio"), 
						rs.getInt("existencias")
					) );
			}

			stmt.close();
			
			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			listADevolver=null;
		}
		
		return listADevolver;
	}
	
}
