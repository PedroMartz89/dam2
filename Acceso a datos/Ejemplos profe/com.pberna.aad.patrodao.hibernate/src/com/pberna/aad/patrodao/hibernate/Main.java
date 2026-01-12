package com.pberna.aad.patrodao.hibernate;

import com.pberna.aad.patrodao.hibernate.data.PresidenteDao;
import com.pberna.aad.patrodao.hibernate.data.model.Presidente;

public class Main {

	public static void main(String[] args) {
		/*EquipoDao equipoDao = new EquipoDao();		
		
		Equipo equipo = equipoDao.read(1);		
		equipo.setNombreEquipo("Nuevo nombre");
		
		equipoDao.update(equipo);*/
		
		/*JugadorDao jugadorDao = new JugadorDao();
		Jugador jugador = jugadorDao.read(1);
		
		System.out.println("El jugador " + jugador.getNombreJugador() +
				" es del equipo " + jugador.getEquipoRelacionado().getNombreEquipo());*/
	
		//EquipoDao equipoDao = new EquipoDao();
		//Equipo equipo = equipoDao.read(1);
		
		/*System.out.println("Vamos a lista los jugadores del equipo " 
				+ equipo.getNombreEquipo());
		
		for(Jugador jugador: equipo.getJugadores()) {
			System.out.println(jugador);
		}*/
		
		
		/*System.out.println("Vamos a lista los patrocinadores del equipo " 
				+ equipo.getNombreEquipo());
		
		for(Patrocinador patrocinador: equipo.getPatrocinadores()) {
			System.out.println(patrocinador);
		}*/
		
		/*PatrocinadorDao patrocinadorDao = new PatrocinadorDao();
		Patrocinador patrocinador = patrocinadorDao.read(2);
		
		System.out.println("Vamos a mostrar los equipos patrocinador por "+
		 patrocinador.getNombrePatrocinador());
		 
		 for(Equipo equipoPatrocinado: patrocinador.getEquipos()) {
				System.out.println(equipoPatrocinado);
		 }*/
		
		/*EquipoDao equipoDao = new EquipoDao();		
		Equipo equipo = equipoDao.read(1);		
		
		System.out.println("El presidente/a del equipo " + 
				equipo.getNombreEquipo() + " es " + equipo.getPresidente().getNombre());*/
		PresidenteDao presidenteDao = new PresidenteDao();		
		Presidente presidente = presidenteDao.read(1);
		
		System.out.println("El presidente/a " + presidente.getNombre() + 
				" preside el equipo " + presidente.getEquipoPresidido().getNombreEquipo());	
		
	}
}
