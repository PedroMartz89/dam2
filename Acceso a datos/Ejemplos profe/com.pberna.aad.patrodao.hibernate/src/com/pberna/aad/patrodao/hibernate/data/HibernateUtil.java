package com.pberna.aad.patrodao.hibernate.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pberna.aad.patrodao.hibernate.data.model.Equipo;
import com.pberna.aad.patrodao.hibernate.data.model.Jugador;
import com.pberna.aad.patrodao.hibernate.data.model.Patrocinador;
import com.pberna.aad.patrodao.hibernate.data.model.Presidente;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static Session session;
	
	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml) config file.
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Equipo.class);
			configuration.addAnnotatedClass(Jugador.class);
			configuration.addAnnotatedClass(Patrocinador.class);
			configuration.addAnnotatedClass(Presidente.class);
			configuration.configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (HibernateException ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Session getSession() {
		if(session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		
		return session;
	}
}
