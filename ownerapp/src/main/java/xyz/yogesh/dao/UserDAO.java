package xyz.yogesh.dao;

import java.util.List;

import xyz.yogesh.domain.User;

public interface UserDAO {
	
	public List<User> findAll();
	
	public User findByEmail(String email);
	
	public User create(User user);
	
	public User update(User user);
	
	public void delete(User user);

}
