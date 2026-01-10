package com.pberna.aad.patrodao.hibernate.data;

import com.pberna.aad.patrodao.hibernate.data.model.Equipo;

public class EquipoDao extends HibernateDao<Equipo, Integer> {

	public EquipoDao() {
		super(Equipo.class);
	}
}
