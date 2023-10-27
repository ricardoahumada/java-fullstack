package com.banana.db;

public class DAOFactory {
	private static DAOFactory instance = null;

	public static DAOFactory getInstance() {
		if (instance == null) {
			instance = new DAOFactory();
		}
		return instance;
	}
	
	public Object getDAO(String daoType){
		switch (daoType) {
			case "usuario": return (Object)UsuarioDAOImpl.getInstance();
			case "maquillaje": return (Object)MaquillajeDAOImpl.getInstance();
			case "compra": return (Object)CompraDAOImpl.getInstance();
			default: return null;
		}
	}
	
}
