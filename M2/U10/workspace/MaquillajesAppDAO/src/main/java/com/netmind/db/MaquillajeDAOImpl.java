package com.netmind.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.netmind.models.Maquillaje;

public final class MaquillajeDAOImpl extends MaquillajeDAO {
	private static Logger logger = Logger.getLogger("MaquillajeDaoImpl");
	
	private static MaquillajeDAOImpl instance = null;

	public static MaquillajeDAOImpl getInstance() {
		if (instance == null) {
			instance = new MaquillajeDAOImpl();
		}
		return instance;
	}
	
	@Override
	public Maquillaje getMaquillaje(int mid) {
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

			logger.info("Conexi�n exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexi�n de BBDD:" + e);
			maquillajeADevolver = null;
		}

		return maquillajeADevolver;
	}

	@Override
	public boolean delMaquillaje(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertMaquillaje(Maquillaje cosmetico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMaquillaje(Maquillaje cosmetico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Maquillaje> getUserMaquillajes(int uid) {
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

			logger.info("Conexi�n exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexi�n de BBDD:" + e);
			listADevolver = null;
		}

		return listADevolver;
	}

	@Override
	public List<Maquillaje> getMaquillajes() {
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

			logger.info("Conexi�n exitosa");

		} catch (Exception e) {
			logger.severe("Error en la conexi�n de BBDD:" + e);
			listADevolver = null;
		}

		return listADevolver;
	}

}
