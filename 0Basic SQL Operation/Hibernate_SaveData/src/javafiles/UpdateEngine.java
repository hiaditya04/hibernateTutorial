package javafiles;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class UpdateEngine { 
 
    public static void main(String[] args)
    {
    	System.out.println("--BEGIN--"); 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Product product = (Product) session.load(Product.class,new Integer(100)); // ObjectNotFoundException
        //Product product = (Product) session.load(Product.class,new Integer(101)); // return null
        product.setProName("Unicorn65");
        product.setDate(new Date());
        product.setPrice(1010);
        
        Transaction transaction = session.beginTransaction();
        session.update(product); 
        
        transaction.commit();
        session.close();
        factory.close();
        System.out.println("--Data updates successfully--");
        System.out.println("--END--");
    }
 
}
