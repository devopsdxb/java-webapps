package xyz.yogesh.dao;

import xyz.yogesh.dao.orm.HibernateOwnerDAO;

public class OwnerDAOFactory {
	
	public static OwnerDAO getOwnerDAO() {
		return new HibernateOwnerDAO();
	}
}
