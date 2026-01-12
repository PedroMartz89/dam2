package data.hibernate;

import data.Dao;
import org.hibernate.Session;

public class HibernateDAO<T, P> implements Dao<T, P> {
    private Class<T> claseModelo;

    public HibernateDAO(Class<T> claseModelo) {
        this.claseModelo = claseModelo;
    }

    @Override
    public void create(T model) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(model);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public T read(P id) {
        Session session = HibernateUtil.getSession();
        return session.get(claseModelo, id);
    }

    @Override
    public void update(T model) {
        Session sesion = HibernateUtil.getSession();
        sesion.beginTransaction();
        sesion.persist(model);
        sesion.getTransaction().commit();
    }

    @Override
    public void delete(P id) {
        Session sesion = HibernateUtil.getSession();
        T model = read(id);

        sesion.beginTransaction();
        sesion.remove(model);
        sesion.getTransaction().commit();
    }
}
