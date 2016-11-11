package com.raj.engine;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.raj.pojo.Parent;

/*
 * Author: Raj
 * */
public class DeleteEngine {
	public static void main(String bag[]){
		System.out.println("--BEGIN--");
		
		HibernateSessionFactory.buildSessionFactory();
		Session session = HibernateSessionFactory.getSession();
		Parent parent = (Parent) session.get(Parent.class, new Integer(1));
	
		/*Parent parent =  (Parent)session.get(Parent.class, new Integer(1));*/
 		Transaction transaction = session.beginTransaction();
		session.delete(parent);
		transaction.commit();
		
		System.out.println("--END--");
	}
}
