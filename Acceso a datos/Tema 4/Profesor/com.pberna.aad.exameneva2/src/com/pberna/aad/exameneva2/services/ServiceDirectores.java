package com.pberna.aad.exameneva2.services;

import java.util.List;

import com.pberna.aad.exameneva2.data.dao.DaoDirectores;
import com.pberna.aad.exameneva2.data.pojos.Directores;
import com.pberna.aad.exameneva2.data.pojos.RentabilidadDirector;

public class ServiceDirectores {

	public void delete(int idDirector) {
		DaoDirectores daoDirectores = new DaoDirectores();
		
		//leemos el director
		Directores director = daoDirectores.read(idDirector);
		
		if(director == null) {
			System.out.println("No existe el director");
			return;
		}
		
		if(director.getPeliculasDirigidas().size() > 0) {
			System.out.println("No se puede borrar el director porque ha dirigido películas");
			return;
		}
		
		daoDirectores.delete(idDirector);
		
	}
	
	public List<RentabilidadDirector> getRentabilidadDirector() {
		DaoDirectores daoDirectores = new DaoDirectores();
		
		return daoDirectores.getRentabilidadDirector();
	}
}
