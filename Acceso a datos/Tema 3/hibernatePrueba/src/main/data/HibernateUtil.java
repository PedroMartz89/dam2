package com.pberna.aad.ut3.baloncesto.data;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pberna.aad.ut3.baloncesto.data.model.Equipo;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml) config file.
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Equipo.class);
			configuration.configure();
			sessionFactory = configuration.buildSessionFactory();
			} catch (HibernateException ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}