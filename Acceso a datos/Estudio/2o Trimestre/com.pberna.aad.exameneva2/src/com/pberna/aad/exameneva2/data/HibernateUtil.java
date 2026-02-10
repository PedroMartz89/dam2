package com.pberna.aad.exameneva2.data;

import com.pberna.aad.exameneva2.data.pojos.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.naming.Referenceable;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static Session currentSession = null;
	
	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml) config file.
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Actores.class);
			configuration.addAnnotatedClass(Directores.class);
			configuration.addAnnotatedClass(Genero.class);
			configuration.addAnnotatedClass(PeliculaActor.class);
			configuration.addAnnotatedClass(Peliculas.class);

			configuration.configure();
			sessionFactory = configuration.buildSessionFactory();
			} catch (HibernateException ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
	}

	public static Session getSession() {
		if(currentSession == null) {
			currentSession = sessionFactory.openSession();
		} else {
			if(!currentSession.isOpen()) {
				currentSession = sessionFactory.openSession();
			}
		}
		
		return currentSession;
	}
}