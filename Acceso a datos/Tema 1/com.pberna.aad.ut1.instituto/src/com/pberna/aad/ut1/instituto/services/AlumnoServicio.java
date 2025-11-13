package com.pberna.aad.ut1.instituto.services;

import java.util.List;

import com.pberna.aad.ut1.instituto.dao.AlumnoDao;
import com.pberna.aad.ut1.instituto.dao.AlumnoDaoImpl;
import com.pberna.aad.ut1.instituto.model.Alumno;
import com.pberna.aad.ut1.instituto.model.calculados.MatriculadosAsignatura;

public class AlumnoServicio implements Servicio<Alumno, String>{

	private AlumnoDao alumnoDao;
	
	public AlumnoServicio() {
		alumnoDao = new AlumnoDaoImpl();
	}
	
	@Override
	public void crear(Alumno modelo) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno obtener(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Alumno modelo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarPorId(String id) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Alumno> buscarPorCurso(String codCurso) {
		return alumnoDao.buscarPorCurso(codCurso);
	}
	
	public List<Alumno> buscarPorNombre(String nombre) {
		return alumnoDao.buscarPorNombre(nombre);
	}
	
	public List<MatriculadosAsignatura> obtenerRecuentoMatriculadosAsignatura() {
		return alumnoDao.obtenerRecuentoMatriculadosAsignatura();
	}
	
}
