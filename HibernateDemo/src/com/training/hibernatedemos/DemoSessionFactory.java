package com.training.hibernatedemos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DemoSessionFactory {
	
	private static SessionFactory SESSION_BUNCH;
	private static final String CONF_LOCATION = "demo.cfg.xml";
	public static void createSessionFactory() {
		try{
			Configuration cg = new Configuration();
			cg.configure(CONF_LOCATION);
			StandardServiceRegistry stdregistry = new StandardServiceRegistryBuilder().applySettings(cg.getProperties()).build();
			SESSION_BUNCH = cg.buildSessionFactory(stdregistry);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

	public static SessionFactory getSessionFactory() {
		System.out.println("start session factory");
		if(SESSION_BUNCH == null)
		createSessionFactory();
		return SESSION_BUNCH;
	}
	
	public static Session getSession() {
		
		return SESSION_BUNCH.openSession();
	}
	
	public static void shutdown() {
		SESSION_BUNCH.close();
		System.out.println("CLOSE SESSION");
		
	}
	
	
	
	
	
}
