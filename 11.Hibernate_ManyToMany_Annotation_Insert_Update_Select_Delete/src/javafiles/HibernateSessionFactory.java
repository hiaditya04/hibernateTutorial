package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory SESSION_FACTORY;
	private static final String  CONFIG_FILE_LOCATION="hibernate.cfg.xml";
	public static void buildSessionFactory(){
		try {
			Configuration cfg = new Configuration();
			cfg.configure(CONFIG_FILE_LOCATION);
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			SESSION_FACTORY=cfg.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory(){
		System.out.println("start session factory");
		if(SESSION_FACTORY==null)
			buildSessionFactory();
		return SESSION_FACTORY;
 }
	
	public static Session getSession(){
		return SESSION_FACTORY.openSession();
	}

	public static void shutDown() {
	   SESSION_FACTORY.close();
       System.out.println("shutdown session factory");
		
	}
}