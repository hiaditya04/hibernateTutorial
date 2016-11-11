package com.raj.engine;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.raj.pojo.Parent;

/*
 * Author: Raj
 * */
public class UpdateEngine {
	public static void main(String bag[]){
		
		
		//Configuration configuration  = new Configuration();
	//	configuration.configure("com//raj/hbm//hibernate.cfg.xml");
		
		try {
			System.out.println("--BEGIN--");
			HibernateSessionFactory.buildSessionFactory();
			Session session = HibernateSessionFactory.getSession();
			Parent parent = (Parent) session.get(Parent.class, new Integer(1));
			parent.setName("Parker_updated");
			parent.getChilds().clear();
			/*Child c2 = new Child();
			c2.setAge(16);
			c2.setName("C16");
			
			Set<Child> childs =  new HashSet<Child>();
			childs.add(c2);		
			
			parent.getChilds().addAll(childs);
			 */
			Transaction transaction = session.beginTransaction();
			session.update(parent);
			transaction.commit();
			System.out.println("--END--");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.shutDown();
			
		}
	}
}
