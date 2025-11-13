package dao;

import model.Asignatura;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AsignaturaDao {

    //CRUD

    //Ejercicio 4 - 3

    List<Asignatura> obtenerAsignaturasDepto(String cod_departamento) throws SQLException;

}
