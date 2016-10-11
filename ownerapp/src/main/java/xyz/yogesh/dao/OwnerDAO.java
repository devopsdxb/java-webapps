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
		
		try {
			String sql = "select * from " + table;
			ResultSet result = getStatement().executeQuery(sql);

			while(result.next()) {
				addOwnertoList(result, ownerList);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return ownerList;
	}

	public List<Owner> find(String[] ids) {
		
		List<Owner> ownerList = new ArrayList<Owner>();
		
		try {
			Statement stmt = getStatement();
			
			for(String id : ids) {
				String sql = "select * from owners where id=\"" + id + "\"";
				ResultSet result = stmt.executeQuery(sql);
				result.next();
				addOwnertoList(result, ownerList);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return ownerList;
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

	private void addOwnertoList(ResultSet result, List<Owner> ownerList) {
		Owner owner = new Owner();
		
		try {
			owner.setId(result.getInt("id"));
			owner.setFirstName(result.getString("first_name"));
			owner.setLastName(result.getString("last_name"));
			owner.setCity(result.getString("city"));
			owner.setAddress(result.getString("address"));
			owner.setTelephone(result.getLong("telephone"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		ownerList.add(owner);
	}

}
