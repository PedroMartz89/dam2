package dao;

import model.Asignatura;

import java.sql.SQLException;

public interface AsignaturaDAO {

    void read(Asignatura a) throws SQLException;
    void delete(int id) throws SQLException;
    void update(Asignatura a) throws SQLException;
    void create(Asignatura a) throws SQLException;
}
