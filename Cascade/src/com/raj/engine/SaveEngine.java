package com.raj.engine;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.raj.pojo.Product;
import com.raj.pojo.ProductDetail;

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
	
		Product product =  new Product();
		product.setName("Pen");
		product.setPrice(100);
		
		ProductDetail detail = new ProductDetail();
		detail.setCompany("Reynolds");
		detail.setPurchasedDate(new Date());
		detail.setProduct(product);
		
		product.setDetail(detail);
		
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		
		System.out.println("--END--");
	}
}
