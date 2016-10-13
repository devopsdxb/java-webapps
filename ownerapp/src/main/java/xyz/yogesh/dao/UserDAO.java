package xyz.yogesh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import xyz.yogesh.domain.User;

public class UserDAO {
	
	private final String table = "user";
	
	private final String driver = "com.mysql.jdbc.Driver";
	private final String db = "jdbc:mysql://localhost:3306/petclinic";
	private final String dbUser = "root";
	private final String dbPassword = "root";
	
	public User findUserByEmail(String email) {
		User user = null;
		
		try {
			String sql = "select * from " + table + " where email=\"" + email + "\"";
			ResultSet result = getStatement().executeQuery(sql);

			while(result.next()) {
				user = new User();
				user.setEmail(result.getString("email"));
				user.setName(result.getString("name"));
				user.setPassword(result.getString("password"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	private Statement getStatement() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(db, dbUser, dbPassword);
			Statement stmt = conn.createStatement();
			return stmt;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
