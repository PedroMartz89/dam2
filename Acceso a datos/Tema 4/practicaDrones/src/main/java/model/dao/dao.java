package model.dao;

import java.util.List;

public interface dao <T>{

    void create(T entity);
    T read(int id);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();
}
