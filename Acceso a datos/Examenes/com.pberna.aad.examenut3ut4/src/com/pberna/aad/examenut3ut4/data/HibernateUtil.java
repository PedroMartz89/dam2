package com.pberna.aad.examenut3ut4.data;

import com.pberna.aad.examenut3ut4.data.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static Session currentSession = null;
	
	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml) config file.
			Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Compra.class);
            configuration.addAnnotatedClass(DetalleCompra.class);
            configuration.addAnnotatedClass(Producto.class);
            configuration.addAnnotatedClass(Usuario.class);
            configuration.addAnnotatedClass(Valoracion.class);
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