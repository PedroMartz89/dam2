package com.pberna.aad.exameneva2.services;

import java.util.List;

import com.pberna.aad.exameneva2.data.dao.DaoPeliculaActor;
import com.pberna.aad.exameneva2.data.pojos.PeliculaActor;

public class ServicePeliculaActor {
	public List<PeliculaActor> getPapelesActor(Integer idActor) {
		
		DaoPeliculaActor daoPeliculasActor = new DaoPeliculaActor();
		return daoPeliculasActor.getPapelesActor(idActor);
	}
}
