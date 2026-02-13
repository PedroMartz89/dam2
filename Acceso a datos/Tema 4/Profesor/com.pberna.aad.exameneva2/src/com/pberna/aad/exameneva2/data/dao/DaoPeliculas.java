package com.pberna.aad.exameneva2.data.dao;

import com.pberna.aad.exameneva2.data.pojos.Peliculas;

public class DaoPeliculas extends HibernateDao<Peliculas, Integer>{

	public DaoPeliculas() {
		super(Peliculas.class);
	}
}
