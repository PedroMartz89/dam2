package dao;

import model.Curso;

import java.sql.SQLException;

public interface CursoDAO {

    void read(Curso c) throws SQLException;
    void delete(int id) throws SQLException;
    void update(Curso c) throws SQLException;
    void create(Curso c) throws SQLException;
}
