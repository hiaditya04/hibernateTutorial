package com.raj.engine;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.raj.pojo.Parent;

/*
 * Author: Raj
 * */
public class SelectEngine {
	public static void main(String bag[]){
		System.out.println("--BEGIN--");
		
		Configuration configuration  = new Configuration();
		configuration.configure("com//raj/hbm//hibernate.cfg.xml");
		
		SessionFactory sessionFactory =  configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		Parent parent =  (Parent)session.get(Parent.class, new Integer(1));
		
		System.out.println("Childs: "+parent.getChilds().size());
		
		System.out.println("--END--");
	}
}
