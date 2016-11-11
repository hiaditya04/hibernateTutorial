package com.raj.engine;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.raj.pojo.Product;

/*
 * Author: Raj
 * */
public class DeleteEngine {
	public static void main(String bag[]){
		System.out.println("--BEGIN--");
		
		Configuration configuration  = new Configuration();
		configuration.configure("com//raj/hbm//hibernate.cfg.xml");
		
		SessionFactory sessionFactory =  configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		Product product =  (Product)session.get(Product.class, new Integer(1));
 		Transaction transaction = session.beginTransaction();
		session.delete(product);
		transaction.commit();
		
		System.out.println("--END--");
	}
}
