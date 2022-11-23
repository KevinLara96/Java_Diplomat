package mx.unam.tic.diplomado.agenda.modelo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;
	
	public static void init() {
		
		try {
	        StandardServiceRegistry registry =
	                new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	        Metadata metaData =
	                new MetadataSources(registry).getMetadataBuilder().build();
	        sessionFactory = metaData.getSessionFactoryBuilder().build();
	    } catch (Throwable th) {

	        System.err.println("Enitial SessionFactory creation failed" + th);
	        throw new ExceptionInInitializerError(th);

	    }
		
	}
	
	public static StandardServiceRegistry getRegistry() {
		return registry != null ? registry : null; 
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory != null ? sessionFactory : null; 
	}
	
	public static Session getSession() {
		return sessionFactory != null ? sessionFactory.openSession() : null; 
	}

}
