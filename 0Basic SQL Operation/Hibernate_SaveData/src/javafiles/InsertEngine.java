package javafiles;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
/*
 * 
 * */
public class InsertEngine { 
 
    public static void main(String[] dataBag)
    {
    	System.out.println("--BEGIN--"); 
    	
    	// Configuration object should be one per application
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml"); 
        System.out.println("1");
        SessionFactory sessionfactory = config.buildSessionFactory();
        Session session = sessionfactory.openSession();
        System.out.println("2");
         
        /* Object 'product' is in transient state */
        Product product = new Product(); 
         System.out.println("1");
        product.setProductId(100);
        product.setProName("NOKIAX");
        product.setDate(new Date());
        product.setPrice(90);
 
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(product);        
        System.out.println("3");
        /* product object in persistent state (Relation with the database) */
        transaction.commit();
        
        session.close();
        /* product object in detached state now */
        sessionfactory.close();
        
        System.out.println("--END--");
    }
 
}
