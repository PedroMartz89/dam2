package com.pberna.aad.exameneva2.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pberna.aad.exameneva2.data.HibernateUtil;
import com.pberna.aad.exameneva2.data.pojos.PeliculaActor;
import com.pberna.aad.exameneva2.data.pojos.PeliculaActorPK;

public class DaoPeliculaActor extends 
    HibernateDao<PeliculaActor, PeliculaActorPK>{
	public DaoPeliculaActor() {
		super(PeliculaActor.class);
	}
	
	public List<PeliculaActor> getPapelesActor(Integer idActor) {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT pa FROM PeliculaActor pa "+
				"WHERE peliculasActorPK.id_actor = :idActor";
		
		Query<PeliculaActor> query = session.createQuery(
				hql, PeliculaActor.class);
		query.setParameter("idActor", idActor);
		
		return query.getResultList();
	}
}
