package com.pberna.aad.exameneva2.services;

import java.util.List;

import com.pberna.aad.exameneva2.data.dao.DaoActores;
import com.pberna.aad.exameneva2.data.pojos.Actores;

public class ServiceActores {
	
	public List<Actores> getActoresPelicula(Integer idPelicula) {
		DaoActores daoActores = new DaoActores();
		
		return daoActores.getActoresPelicula(idPelicula);
	}
}
