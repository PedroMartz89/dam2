package com.pberna.aad.ut1.instituto.dao;

import java.util.List;

import com.pberna.aad.ut1.instituto.model.Alumno;
import com.pberna.aad.ut1.instituto.model.calculados.MatriculadosAsignatura;

public interface AlumnoDao {
	void create(Alumno alumno);
	 Alumno read(String nre);
	 void update(Alumno alumno);
	 void delete(String alumno);
	 
	 List<Alumno> buscarPorCurso(String codCurso);
	 List<Alumno> buscarPorNombre(String nombre);
	 
	 List<MatriculadosAsignatura> obtenerRecuentoMatriculadosAsignatura();

     //Tarea 4: Completar resto de consultas

    List<Alumno> alumnosMatriculadosAsignatura();

}
