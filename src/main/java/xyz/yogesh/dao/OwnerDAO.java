package xyz.yogesh.dao;

import java.util.List;

import xyz.yogesh.domain.Owner;

public interface OwnerDAO {
	
	public List<Owner> findAll();
	
	public Owner findByID(int id);
	
	public List<Owner> findByID(List<Integer> ids);
	
	public Owner create(Owner owner);
	
	public Owner update(Owner owner);
	
	public void delete(Owner owner);

}
