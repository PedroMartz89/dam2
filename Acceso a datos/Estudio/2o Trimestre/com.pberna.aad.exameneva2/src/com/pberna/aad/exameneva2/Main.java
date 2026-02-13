package com.pberna.aad.exameneva2;


import com.pberna.aad.exameneva2.data.pojos.Actores;
import com.pberna.aad.exameneva2.data.pojos.PeliculaActor;
import com.pberna.aad.exameneva2.data.pojos.Peliculas;
import com.pberna.aad.exameneva2.data.pojos.RentabilidadDirector;
import com.pberna.aad.exameneva2.services.ServiceActores;
import com.pberna.aad.exameneva2.services.ServiceDirectores;
import com.pberna.aad.exameneva2.services.ServicePeliculaActor;
import com.pberna.aad.exameneva2.services.ServicePeliculas;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		ServiceDirectores serviceDirectores = new ServiceDirectores();
		serviceDirectores.delete(4);
		
		ServicePeliculas servicePeliculas = new ServicePeliculas();
		List<Peliculas> peliculas = servicePeliculas.getPeliculasGenero(5);
		
		for(Peliculas pelicula: peliculas) {
			System.out.println(pelicula);
		}
		
		ServiceActores serviceActores = new ServiceActores();		
		List<Actores> actores = serviceActores.getActoresPelicula(2);
		
		for(Actores actor: actores) {
			System.out.println(actor);
		}
		
		ServicePeliculaActor servicePeliculaActor = new ServicePeliculaActor();
		List<PeliculaActor> peliculasActor = servicePeliculaActor.getPapelesActor(2);
		
		for(PeliculaActor peliculaActor: peliculasActor) {
			System.out.println(peliculaActor);
		}

		for(RentabilidadDirector rentabilidadDirector : 
			serviceDirectores.getRentabilidadDirector()) {
			System.out.println(rentabilidadDirector);
		}
		
	}

}
