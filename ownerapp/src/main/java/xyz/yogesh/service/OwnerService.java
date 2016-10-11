package xyz.yogesh.service;

import java.util.List;

import xyz.yogesh.dao.OwnerDAO;
import xyz.yogesh.domain.Owner;

public class OwnerService {
	
	private OwnerDAO dao = new OwnerDAO();

	public List<Owner> findAll() {
		return dao.findAll();
	}

	public List<Owner> find(String[] ids) {
		return dao.find(ids);
	}
}
