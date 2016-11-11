package com.raj.engine;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.raj.pojo.Child;
import com.raj.pojo.Parent;

/*
 * Author: Raj
 * */
public class SaveEngine {
	public static void main(String bag[]){
		System.out.println("--BEGIN--");
		
		Configuration configuration  = new Configuration();
		configuration.configure("com//raj/hbm//hibernate.cfg.xml");
		
		SessionFactory sessionFactory =  configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		Parent parent =  new Parent();
		parent.setName("P1");
		
		Child c1 = new Child();
		c1.setAge(6);
		c1.setName("c1");
		
		Child c2 = new Child();
		c2.setAge(4);
		c2.setName("C2");
		
		Set<Child> childs =  new HashSet<Child>();
		childs.add(c1);
		childs.add(c2);		
		parent.setChilds(childs);
		
		Transaction transaction = session.beginTransaction();
		session.save(parent);
		
		transaction.commit();
		
		System.out.println("--Parent data saved successfully--");
		System.out.println("--END--");
	}
}
