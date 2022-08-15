package xyz.yogesh.dao;

public class UserDAOFactory {
	
	public static UserDAO getUserDAO() {
		return new JDBCUserDAO();
	}
}
