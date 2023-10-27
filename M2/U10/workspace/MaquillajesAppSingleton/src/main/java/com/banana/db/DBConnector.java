package com.banana.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.banana.models.Compra;
import com.banana.models.Maquillaje;
import com.banana.models.Usuario;

public class DBConnector {
	private static Logger logger = Logger.getLogger("DBConnector");
	
	private String driverName;
	private String url;
	
	private static DBConnector instance = null;
	
	public static DBConnector getInstance() {
		if (instance == null) {
			instance = new DBConnector();
		}
		return instance;
	}

	protected DBConnector() {
		this.driverName = "com.mysql.jdbc.Driver";
		this.url = "jdbc:mysql://localhost/maquillajes?user=maq_user&password=mqll7";
		
		try {
			Class.forName(this.driverName).newInstance();
		} catch (Exception e) {
			logger.info("Error al instanciar driver!!!!");
			e.printStackTrace();
		}
		
	}
	

	public boolean existeUsuario(String email, String pass) {

		try {
			Connection conn = DriverManager.getConnection(this.url);

			// ordenes sql
			String sql="SELECT u.* FROM usuario u WHERE u.email=? AND password=? LIMIT 1";
			PreparedStatement pstm=conn.prepareStatement(sql);
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
			Connection conn = DriverManager.getConnection(this.url);
			// ordenes sql
			String sql="SELECT u.* FROM usuario u WHERE u.email=? AND password=? LIMIT 1";
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, pass);
			
			ResultSet rs = pstm.executeQuery();

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

			pstm.close();
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
			Connection conn = DriverManager.getConnection(this.url);
			
			// ordenes sql
			String sql="SELECT m.* FROM maquillaje m INNER JOIN compra c ON c.cosmetico=m.mid WHERE c.usuario=?";
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setInt(1, uid);
			
			ResultSet rs = pstm.executeQuery();
			
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

			pstm.close();
			
			conn.close();

			logger.info("Conexión exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e);
			listADevolver=null;
		}
		
		return listADevolver;
	}
	
	public boolean insertCompra(Compra nuevaCompra){
		boolean exito = false;

		try {
			Connection conn = DriverManager.getConnection(this.url);
			// ordenes sql
			String sql="INSERT INTO compra VALUES(NULL,?,?,?,?)";
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setInt(1, nuevaCompra.getUsuario());
			pstm.setInt(2, nuevaCompra.getCosmetico());
			pstm.setInt(3, nuevaCompra.getCantidad());
			
			SimpleDateFormat sdfr = new SimpleDateFormat("yyyyMMdd");
			pstm.setString(4,  sdfr.format( nuevaCompra.getFecha() ) );
			
			int rows = pstm.executeUpdate();
			
			pstm.close();
			conn.close();

			logger.info("Inserción exitosa");
			exito = rows>0?true:false;

		} catch (Exception e) {
			logger.severe("Error en la conexión de BBDD:" + e.getMessage());
			exito=false;
		}
		
		return exito;
	}
	
}
