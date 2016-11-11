package com.training.hibernatedemo.operation;

import org.hibernate.Session;

import com.training.hibernatedemo.entity.Person;
import com.training.hibernatedemos.DemoSessionFactory;

public class InsertOperation {
	private  static Person ps;

	public static void main(String[] args) {
		DemoSessionFactory.createSessionFactory();
		Session sessn = DemoSessionFactory.getSession();
		org.hibernate.Transaction trns = sessn.beginTransaction();
		try{

			System.out.println("session created");
			ps = new Person();
			ps.setAge(23);
			ps.setAddress("mumbai");
			ps.setGender("f");
			ps.setId(17);
			ps.setName("mona");
			System.out.println(ps.toString());
			sessn.save(ps);
			System.out.println("saved....");
			trns.commit();

			System.out.println("commited...");
		}
		catch(Exception  e){
			e.printStackTrace();
			trns.rollback();
			
			//trns.commit();
			//sessn.close();
			//sessn.flush();
			System.out.println("session roll backed");
			System.out.println("first transcation alive..."+trns.isActive());
		}
		
		try{
			//sessn.reconnect(arg0)
			System.out.println("first transcation in second try catch ..alive..."+trns.isActive());
			//sessn=DemoSessionFactory.getSession();
		    //sessn.clear();
			
			/*Person newPerson = new Person();
			newPerson.setId(16);*/
        	Person obj = (Person)sessn.get(Person.class, 17l);
        	obj.setName("updated");
			org.hibernate.Transaction delete = sessn.beginTransaction();
			System.out.println("second transcation..." + delete.isActive());
			/*sessn.flush();
			sessn.clear();*/
			//sessn.delete(obj);
			sessn.update(obj);
			delete.commit();
			System.out.println("row deleted...");
			sessn.close();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("......not deleted");
		}
         finally{
        	 DemoSessionFactory.shutdown();	 
         }

		






	}
}