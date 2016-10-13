package xyz.yogesh.dao;

public class OwnerDAOFactory {
	
	public static OwnerDAO getOwnerDAO() {
		return new JDBCOwnerDAO();
	}
}
