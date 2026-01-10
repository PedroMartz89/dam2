package model.dao;

import Hibernate.HibernateDao;
import Hibernate.HibernateUtil;
import model.HousePoints;
import org.hibernate.Session;

import java.util.List;

public class HousePointsDao extends HibernateDao<HousePoints> {
    public HousePointsDao() {
        super(HousePoints.class);
    }

    public boolean existsAsGiver(int idPerson) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long count = session.createQuery("select count(hp) from HousePoints hp where hp.giver.id = :id", Long.class)
                    .setParameter("id", idPerson)
                    .uniqueResult();
            return count > 0;
        }
    }

    public boolean existsAsReceiver(int idPerson) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long count = session.createQuery("select count(hp) from HousePoints hp where hp.receiver.id = :id", Long.class)
                    .setParameter("id", idPerson)
                    .uniqueResult();
            return count > 0;
        }
    }

    public List<Object[]> getPuntosTotalesPorCasa() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String hql = "SELECT hp.receiver.house.name, SUM(hp.points) " +
                    "FROM HousePoints hp " +
                    "GROUP BY hp.receiver.house.name";

            return session.createQuery(hql, Object[].class).getResultList();
        }
    }
}
