package xyz.yogesh.service;

import java.util.List;

import xyz.yogesh.dao.OwnerDAO;
import xyz.yogesh.dao.OwnerDAOFactory;
import xyz.yogesh.domain.Owner;

public class OwnerService {
	
	private OwnerDAO dao = OwnerDAOFactory.getOwnerDAO();

	public List<Owner> findAll() {
		return dao.findAll();
	}

	public List<Owner> find(String[] ids) {
		int[] idArr = new int[ids.length];
		for(int i=0; i<ids.length; i++) {
			idArr[i] = Integer.parseInt(ids[i]);
		}
		return dao.findByID(idArr);
	}
}
