package com.training.hibernatedemo.operation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.hibernatedemo.entity.Person;
import com.training.hibernatedemos.DemoSessionFactory;

public class DeleteOperation {

	public static void main(String[] args) {
		DemoSessionFactory.createSessionFactory();
		Session updatesession = DemoSessionFactory.getSession();
		Transaction updates = updatesession.beginTransaction();
		Person ps = new Person();
		ps.setId(90);
		ps.setAddress("delhi");
		ps.setAge(50);
		ps.setGender("female");
		ps.setName("sonali");
		updatesession.update(ps);
		updates.commit();
		System.out.println("updated....");
	}
}
