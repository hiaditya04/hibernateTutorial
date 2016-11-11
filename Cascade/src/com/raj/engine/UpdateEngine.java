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
public class UpdateEngine {
	public static void main(String bag[]){
		System.out.println("--BEGIN--");
		
		Configuration configuration  = new Configuration();
		configuration.configure("com//raj/hbm//hibernate.cfg.xml");
		
		SessionFactory sessionFactory =  configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		Product product =  (Product)session.get(Product.class, new Integer(1));
		product.setName("Parker");
		product.setPrice(1000);
		
		ProductDetail detail = new ProductDetail();
		detail.setCompany("Peter-Reynolds");
		detail.setPurchasedDate(new Date());
		detail.setProduct(product);
		
		product.setDetail(detail);
		
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		
		System.out.println("--END--");
	}
}
