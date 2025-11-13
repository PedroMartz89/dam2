package services;

import dao.AsignaturaDao;
import model.Asignatura;
import model.AsignaturaDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class AsignaturaServicio implements Servicio <Asignatura, String> {

    private AsignaturaDao asignaturaDao;

    public AsignaturaServicio() {
        this.asignaturaDao = new AsignaturaDaoImpl();
    }

    @Override
    public void crear(Asignatura modelo) throws ServiceException {

    }

    @Override
    public Asignatura obtener(String id) {
        return null;
    }

    @Override
    public void actualizar(Asignatura modelo) {

    }

    @Override
    public void borrarPorId(String id) {

    }

    public List<Asignatura> obtenerAsignaturasDepto(String cod_departamento) throws SQLException {
        return asignaturaDao.obtenerAsignaturasDepto(cod_departamento);
    }

}
