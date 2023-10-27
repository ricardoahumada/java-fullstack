package com.banana.db.factory;

import com.banana.db.dao.*;

public class DAOFactory {
	public static final DAO getDao(String tipo) throws Exception{
		switch (tipo) {
		case "customer":
			CustomerDAO aDao= CustomerDAOImpl.getInstance();
			return aDao;
		case "order":
			//orderDAO aDao= orderDAOImpl.getInstance();
			return null;
		}
		return null;
	}
}
