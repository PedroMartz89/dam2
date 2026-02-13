package com.pberna.aad.exameneva2.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pberna.aad.exameneva2.data.HibernateUtil;
import com.pberna.aad.exameneva2.data.pojos.Actores;

public class DaoActores extends HibernateDao<Actores, Integer>{
	public DaoActores() {
		super(Actores.class);
	}
	
	public List<Actores> getActoresPelicula(Integer idPelicula) {
		Session session = HibernateUtil.getSession();
		
		Query<Actores> query = session.createNamedQuery(
				"ListarPorIdPelicula", Actores.class);
		query.setParameter(1, idPelicula);
		
		return query.getResultList();
	}
}
