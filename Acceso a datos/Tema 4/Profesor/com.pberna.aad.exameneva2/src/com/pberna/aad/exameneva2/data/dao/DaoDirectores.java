package com.pberna.aad.exameneva2.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pberna.aad.exameneva2.data.HibernateUtil;
import com.pberna.aad.exameneva2.data.pojos.Directores;
import com.pberna.aad.exameneva2.data.pojos.RentabilidadDirector;

public class DaoDirectores extends HibernateDao<Directores, Integer>{

	public DaoDirectores() {
		super(Directores.class);
	}

	public List<RentabilidadDirector> getRentabilidadDirector() {
		Session session = HibernateUtil.getSession();
		
		String sql = "SELECT d.id_director as idDirector, d.nombre, SUM(p.recaudacion) AS totalRecaudacion ,\n"
				+ " AVG(p.recaudacion) AS mediaRecaudacion,\n"
				+ " AVG(p.recaudacion / p.presupuesto ) as rentabilidadMedia\n"
				+ "  from Directores d \n"
				+ "  LEFT  JOIN Peliculas p on p.id_director  = d.id_director \n"
				+ "GROUP BY d.id_director, d.nombre";
		
		Query<RentabilidadDirector> query = session.createNativeQuery(sql, RentabilidadDirector.class);
		return query.getResultList();
	}
}
