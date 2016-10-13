package xyz.yogesh.service;

import xyz.yogesh.dao.UserDAO;
import xyz.yogesh.domain.User;

public class UserService {
	
	private UserDAO dao = new UserDAO();

	public User authenticate(String email, String password) {
		User user = dao.findUserByEmail(email);
		
		if(user!=null && password.equals(user.getPassword())) {
			return user;
		}
		else {
			return null;
		}
	}
}
