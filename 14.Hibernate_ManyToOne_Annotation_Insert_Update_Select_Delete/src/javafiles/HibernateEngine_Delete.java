package javafiles;
/*
 * Author : RAJ
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Delete { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. MANY TO ONE ANNOTATION DELETE LESSON ..\n");
        Configuration condigurationObj = new Configuration();
        condigurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory factoryObj = condigurationObj.buildSessionFactory();
        Session sessionObj = factoryObj.openSession();         
                           
        Children childObj= (Children) sessionObj.get(Children.class, new Integer(2));       
        Transaction transaction=sessionObj.beginTransaction();        
        sessionObj.delete(childObj);                
        transaction.commit();
        
        System.out.println("\n....... DATA DELETED SUCCESSFULLY ..........");
        sessionObj.close();
        factoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
