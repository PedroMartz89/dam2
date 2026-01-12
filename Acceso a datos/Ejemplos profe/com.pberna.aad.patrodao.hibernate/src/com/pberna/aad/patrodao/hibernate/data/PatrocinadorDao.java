package com.pberna.aad.patrodao.hibernate.data;

import com.pberna.aad.patrodao.hibernate.data.model.Patrocinador;

public class PatrocinadorDao extends HibernateDao<Patrocinador, Integer>{

	public PatrocinadorDao() {
		super(Patrocinador.class);
	}
}
