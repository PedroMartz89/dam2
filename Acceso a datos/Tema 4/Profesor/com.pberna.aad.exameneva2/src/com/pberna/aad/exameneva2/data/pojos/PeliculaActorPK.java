package com.pberna.aad.exameneva2.data.pojos;

import jakarta.persistence.Embeddable;

@Embeddable
public class PeliculaActorPK {
	protected int id_actor;
	protected int id_pelicula;
	
	public PeliculaActorPK() {
		
	}

	public PeliculaActorPK(int id_actor, int id_pelicula) {
		super();
		this.id_actor = id_actor;
		this.id_pelicula = id_pelicula;
	}

	@Override
	public String toString() {
		return "PeliculaActorPK [id_actor=" + id_actor + ", id_pelicula=" + id_pelicula + "]";
	}
	
	@Override	
	public boolean equals(Object obj) {
		if(obj instanceof PeliculaActorPK) {
			PeliculaActorPK compare = (PeliculaActorPK) obj;
			return compare.id_actor == id_actor 
					&& compare.id_pelicula == id_pelicula;
		}
		
		return false;
	}
	
}
