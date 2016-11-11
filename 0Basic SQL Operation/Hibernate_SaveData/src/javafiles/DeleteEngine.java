package javafiles;

import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class DeleteEngine { 
 
    public static void main(String[] dataBag)
    {
    	System.out.println("--START--");
    	
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Product product = (Product) session.load(Product.class, new Integer(100));        
        Transaction tx = session.beginTransaction();
        session.delete(product);
        tx.commit();
        
        session.close();
        factory.close();
        
        System.out.println("Product Data deleted successfully.....!!");
        System.out.println("--END--");
    }
 
}
