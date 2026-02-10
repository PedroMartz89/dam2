package Hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateDao<T, P> implements GenericDao<T, P> {

    private Class<T> entityClass;
    private Class<P> idClass;
    public HibernateDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(T entity) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();

        }
    }

    @Override
    public T read(P idClass) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(entityClass, idClass);
        }
    }

    @Override
    public void update(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();
        }
    }

    @Override
    public void delete(T entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            // Dentro de tu método delete(T entity)
            if (session.contains(entity)) {
                session.remove(entity);
            } else {
                session.remove(session.merge(entity));
            }
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from " + entityClass.getName(), entityClass).getResultList();
        }
    }

}
