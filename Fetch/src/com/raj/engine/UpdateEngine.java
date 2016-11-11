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
public class UpdateEngine {
	public static void main(String bag[]){
		System.out.println("--BEGIN--");
		
		Configuration configuration  = new Configuration();
		configuration.configure("com//raj/hbm//hibernate.cfg.xml");
		
		SessionFactory sessionFactory =  configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		Parent parent =  (Parent)session.get(Parent.class, new Integer(1));
		parent.setName("Parker");
		parent.getChilds().clear();
		
		Child c2 = new Child();
		c2.setAge(16);
		c2.setName("C16");
		
		Set<Child> childs =  new HashSet<Child>();
		childs.add(c2);		
		
		parent.getChilds().addAll(childs);
		
		Transaction transaction = session.beginTransaction();
		session.update(parent);
		transaction.commit();
		
		System.out.println("--END--");
	}
}
