package com.pberna.aad.exameneva2;

import com.pberna.aad.exameneva2.mongo.ComponentesBD;
import com.pberna.aad.exameneva2.services.ServiceActores;

public class Main {

	public static void main(String[] args) {
		/*ServiceDirectores serviceDirectores = new ServiceDirectores();
		serviceDirectores.delete(4);*/
		
		/*ServicePeliculas servicePeliculas = new ServicePeliculas();
		List<Peliculas> peliculas = servicePeliculas.getPeliculasGenero(5);
		
		for(Peliculas pelicula: peliculas) {
			System.out.println(pelicula);
		}*/
		
		ServiceActores serviceActores = new ServiceActores();
		List<Actores> actores = serviceActores.getActoresPelicula(2);
		
		for(Actores actor: actores) {
			System.out.println(actor);
		}*/
		
		/*ServicePeliculaActor servicePeliculaActor = new ServicePeliculaActor();
		List<PeliculaActor> peliculasActor = servicePeliculaActor.getPapelesActor(2);
		
		for(PeliculaActor peliculaActor: peliculasActor) {
			System.out.println(peliculaActor);
		}*/
		
		/*ServiceDirectores serviceDirectores = new ServiceDirectores();
		for(RentabilidadDirector rentabilidadDirector : 
			serviceDirectores.getRentabilidadDirector()) {
			System.out.println(rentabilidadDirector);
		}*/
		
		ComponentesBD componentesBD = new ComponentesBD();
		//componentesBD.crearColeccionesConDatos();
		//componentesBD.asignarCampoPrecioProcesadores();
		componentesBD.borrarDiscoDuro();
	}

}
