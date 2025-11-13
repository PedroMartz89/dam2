package services;
import dao.AlumnoDao;
import model.Alumno;
import model.AlumnoDaoImpl;
import model.calculados.MatriculadosAsignatura;

import java.util.List;
import java.util.Scanner;

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

    //Ejercicio 4 - 1
    public List<MatriculadosAsignatura> obtenerRecuentoMatriculadosAsignatura() {
        return alumnoDao.obtenerRecuentoMatriculadosAsignatura();
    }

    public List<Alumno> alumnosMatriculadosAsignatura(Scanner sc) {
        return alumnoDao.alumnosMatriculadosAsignatura(sc);
    }
}
