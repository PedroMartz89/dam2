package data;

public interface Dao<T, P> {
    void create(T model);
    T read(P id);
    void update(T model);
    void delete(P id);

}
