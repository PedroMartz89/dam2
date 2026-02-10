package com.pberna.aad.exameneva2.data.dao;

import org.hibernate.Session;

import com.pberna.aad.exameneva2.data.HibernateUtil;

public class HibernateDao<T, S> implements Dao<T, S>{
	
	private final Class<T> classT;
	
	public HibernateDao(Class<T> classT) {
		this.classT = classT;
	}

	@Override
	public void create(T model) {
		Session session = HibernateUtil.getSession();
		
		session.beginTransaction();
		session.persist(model);
		session.getTransaction().commit();
	}

	@Override
	public T read(S id) {
		Session session = HibernateUtil.getSession();
		
		return session.get(classT, id);
	}

	@Override
	public void update(T model) {
		Session session = HibernateUtil.getSession();
		
		session.beginTransaction();
		session.persist(model);
		session.getTransaction().commit();
		
	}

	@Override
	public void delete(S id) {
		T model = read(id);
		
		
		if(model != null) {
			Session session = HibernateUtil.getSession();
			
			session.beginTransaction();
			session.remove(model);
			session.getTransaction().commit();
		}
		
	}
	
}
