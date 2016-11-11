package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Delete { 
 
    public static void main(String[] javaPlanet)
    { 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. ONE TO MANY ANNOTATION DELETE LESSON ..\n");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();        
                           
        Parent parentObj= (Parent) sessionObj.get(Parent.class, new Integer(101));        
        Transaction transaction=sessionObj.beginTransaction();        
        sessionObj.delete(parentObj);                
        transaction.commit();
        
        System.out.println("\n....... DATA DELETED SUCCESSFULLY ..........");
        sessionObj.close();
        sessionFactoryObj.close();       
        System.out.println("....... ENGINE STOP ..........");
    } 
}
