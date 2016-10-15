package xyz.yogesh.service;

import java.util.ArrayList;
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
		List<Integer> idList = new ArrayList<Integer>();
		for(int i=0; i<ids.length; i++) {
			idList.add(Integer.parseInt(ids[i]));
		}
		return dao.findByID(idList);
	}
}
