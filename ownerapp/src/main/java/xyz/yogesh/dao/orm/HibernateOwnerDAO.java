package xyz.yogesh.dao.orm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import xyz.yogesh.dao.OwnerDAO;
import xyz.yogesh.domain.Owner;

public class HibernateOwnerDAO implements OwnerDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Owner> findAll() {
		List<Owner> ownerList = new ArrayList<Owner>();
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		
		//session.beginTransaction();
        ownerList = session.getNamedQuery("Owner.getAll").getResultList();
        //session.getTransaction().commit();

		return ownerList;
	}

	@Override
	public Owner findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Owner> findByID(int[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner create(Owner owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner update(Owner owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Owner owner) {
		// TODO Auto-generated method stub
		
	}

}
