package dao;

import model.Turno;

import java.sql.SQLException;

public interface TurnoDAO {
    void read(Turno t) throws SQLException;
    void delete(int id) throws SQLException;
    void update(Turno t) throws SQLException;
    void create(Turno t) throws SQLException;
}
