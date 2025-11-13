package dao;

import model.Profesor;

import java.util.List;

public interface ProfesorDao {

    //CRUD

    //EJERCICIO 4 - 2

    List<Profesor> obtenerProfesImpartenAula(String numAula);

}
