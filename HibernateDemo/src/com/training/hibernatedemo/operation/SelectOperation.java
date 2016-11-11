package com.training.hibernatedemo.operation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;


import com.training.hibernatedemo.entity.Person;
import com.training.hibernatedemos.DemoSessionFactory;

public class SelectOperation {

	private static List<Person> listofperson;
	public static void main(String[] args) {
		try {
		DemoSessionFactory.createSessionFactory();
		Session session = DemoSessionFactory.getSession();
		Criteria crt = session.createCriteria(Person.class);
		System.out.println("before ");
		listofperson = crt.list();
		System.out.println("after.." + listofperson.toString());
		for (Person person : listofperson) {
			System.out.println("object......"+person.toString());
		}
	} catch (Exception e) {
          e.printStackTrace();
          System.out.println("in catch.....");
	}finally{
		DemoSessionFactory.shutdown();
	}
	}
}
