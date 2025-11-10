package dao;

import model.Grupo;

import java.sql.SQLException;

public interface GrupoDAO {
    void read(Grupo g) throws SQLException;
    void delete(int id) throws SQLException;
    void update(Grupo g) throws SQLException;
    void create(Grupo a) throws SQLException;
}
