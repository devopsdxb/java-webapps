package xyz.yogesh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xyz.yogesh.domain.Owner;

public class OwnerDAO {
	
	private final String table = "owners";
	
	private final String driver = "com.mysql.jdbc.Driver";
	private final String db = "jdbc:mysql://localhost:3306/petclinic";
	private final String dbUser = "root";
	private final String dbPassword = "root";
	
	public List<Owner> findAll() {
	
		List<Owner> ownerList = new ArrayList<Owner>();
		Owner owner;
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(db, dbUser, dbPassword);
			Statement stmt = conn.createStatement();
			
			String sql = "select * from " + table;
			ResultSet result = stmt.executeQuery(sql);


			while(result.next()) {
				owner = new Owner();
				
				owner.setId(result.getInt("id"));
				owner.setFirstName(result.getString("first_name"));
				owner.setLastName(result.getString("last_name"));
				owner.setCity(result.getString("city"));
				owner.setAddress(result.getString("address"));
				owner.setTelephone(result.getLong("telephone"));
				
				ownerList.add(owner);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return ownerList;
	}

}
