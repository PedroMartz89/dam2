package Hibernate;

import java.util.List;

public interface GenericDao<T, P> {
    void create(T entity);
    T read(P id);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();
}
