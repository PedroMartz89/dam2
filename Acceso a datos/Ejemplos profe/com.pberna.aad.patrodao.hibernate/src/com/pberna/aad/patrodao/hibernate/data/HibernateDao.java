package com.pberna.aad.patrodao.hibernate.data;

import org.hibernate.Session;

public class HibernateDao<T, P> implements Dao <T, P> {
	
	private Class<T> claseModelo;
	
	public HibernateDao(Class<T> clase) {
		this.claseModelo = clase;
	}

	@Override
	public void create(T model) {
		Session sesion = HibernateUtil.getSession();			
		
		sesion.beginTransaction();
		sesion.persist(model);
		sesion.getTransaction().commit();				
	}

	@Override
	public T read(P identifier) {
		Session sesion = HibernateUtil.getSession();
		return sesion.get(claseModelo, identifier);			
		
	}

	@Override
	public void update(T model) {
		Session sesion = HibernateUtil.getSession();			
		sesion.beginTransaction();
		sesion.persist(model);
		sesion.getTransaction().commit();		
	}

	@Override
	public void delete(P identifier) {
		Session sesion = HibernateUtil.getSession();
		T model = read(identifier);

		sesion.beginTransaction();
		sesion.remove(model);
		sesion.getTransaction().commit();
		
	}

}
