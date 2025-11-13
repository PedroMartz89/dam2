package services;

import dao.ProfesorDao;
import model.Profesor;
import model.ProfesorDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class ProfesorServicio implements Servicio<Profesor, String> {

    private ProfesorDao profesorDao;

    public ProfesorServicio() {
        this.profesorDao = new ProfesorDAOImpl();
    }

    //Ejercicio 4 - 2
    public List<Profesor> obtenerProfesImpartenAula(String numAula) throws SQLException {
        return profesorDao.obtenerProfesImpartenAula(numAula);
    }

    @Override
    public void crear(Profesor modelo) throws ServiceException {

    }

    @Override
    public Profesor obtener(String id) {
        return null;
    }

    @Override
    public void actualizar(Profesor modelo) {

    }

    @Override
    public void borrarPorId(String id) {

    }
}