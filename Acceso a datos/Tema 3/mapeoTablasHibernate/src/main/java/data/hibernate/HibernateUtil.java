package data.hibernate;

import data.model.Departamento;
import data.model.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static Session session;
    static {

        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Departamento.class);
            configuration.addAnnotatedClass(Empleado.class);
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
        }
        return session;

    }
}
