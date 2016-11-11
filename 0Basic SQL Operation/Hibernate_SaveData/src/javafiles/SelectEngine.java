package javafiles;

import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class SelectEngine { 
 
    public static void main(String[] dataBag)
    {
    	System.out.println("--BEGIN--"); 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
         
        Product product = (Product)session.load(Product.class,new Integer(100));        
        
        /*
         * here the object 'product' is in the relation with the database
         * so it is in the persistent state
         * */
        
        System.out.println("Id : "+product.getProductId());
        System.out.println("Name : "+product.getProName());
        System.out.println("Price : "+product.getPrice());
        
        session.close();
        
        /*
         * closing the session brings the 'product' object into detached state 
         * */
        factory.close();
        System.out.println("--END--");
    }
 
}
