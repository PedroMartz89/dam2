package com.pberna.aad.patrodao.hibernate.data;

import com.pberna.aad.patrodao.hibernate.data.model.Presidente;

public class PresidenteDao extends HibernateDao <Presidente, Integer>{

	public PresidenteDao() {
		super(Presidente.class);
	}
}
