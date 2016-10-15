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
        ownerList = session.getNamedQuery("Owner.findAll").getResultList();
        //session.getTransaction().commit();

		return ownerList;
	}

	@Override
	public Owner findByID(int id) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Owner> findByID(List<Integer> ids) {
		List<Owner> ownerList = new ArrayList<Owner>();
		Session session = HibernateSessionManager.getSessionFactory().openSession();
        ownerList = session.getNamedQuery("Owner.findByIDList").setParameter("ownerList", ids).getResultList();
		return ownerList;
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
