package dao;

import model.Alumno;
import model.calculados.MatriculadosAsignatura;

import java.util.List;
import java.util.Scanner;

public interface AlumnoDao {
    void create(Alumno alumno);
    Alumno read(String nre);
    void update(Alumno alumno);
    void delete(String alumno);

    List<Alumno> buscarPorCurso(String codCurso);
    List<Alumno> buscarPorNombre(String nombre);

    List<MatriculadosAsignatura> obtenerRecuentoMatriculadosAsignatura();

    //Tarea 4: Completar resto de consultas

    List<Alumno> alumnosMatriculadosAsignatura(Scanner sc);

}
