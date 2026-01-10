package com.pberna.aad.patrodao.hibernate.data;

import com.pberna.aad.patrodao.hibernate.data.model.Jugador;

public class JugadorDao extends HibernateDao <Jugador, Integer>{
	public JugadorDao() {
		super(Jugador.class);
	}
}
