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
		
		try {
			HibernateSessionFactory.buildSessionFactory();
			Session session = HibernateSessionFactory.getSession();
			Parent parent = new Parent();
			parent.setName("P1");
			Child c1 = new Child();
			c1.setAge(6);
			c1.setName("c1");
			c1.setParent(parent);
			Child c2 = new Child();
			c2.setAge(4);
			c2.setName("C2");
			c2.setParent(parent);
			Set<Child> childs = new HashSet<Child>();
			childs.add(c1);
			childs.add(c2);
			parent.setChilds(childs);
			Transaction transaction = session.beginTransaction();
			session.save(parent);
			transaction.commit();
			System.out.println("--Parent data saved successfully--");
			System.out.println("--END--");
		} catch (Exception e) {
         e.printStackTrace();
		}finally{
			HibernateSessionFactory.shutDown();
		}
	}
}
