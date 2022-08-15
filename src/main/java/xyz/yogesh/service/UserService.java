package xyz.yogesh.service;

import xyz.yogesh.dao.UserDAO;
import xyz.yogesh.dao.UserDAOFactory;
import xyz.yogesh.domain.User;

public class UserService {
	
	private UserDAO dao = UserDAOFactory.getUserDAO();

	public User authenticate(String email, String password) {
		User user = dao.findByEmail(email);
		
		if(user!=null && password.equals(user.getPassword())) {
			return user;
		}
		else {
			return null;
		}
	}
}
