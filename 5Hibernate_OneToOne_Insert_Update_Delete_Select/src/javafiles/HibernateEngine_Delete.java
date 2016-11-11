package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Delete { 
 
    public static void main(String[] javaPlanet)
    { 
       	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .... ONE TO ONE DELETE LESSON ....");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();
         
        Result resultObj = (Result) sessionObj.get(Result.class, new Integer(1));
        Transaction transactionObj = sessionObj.beginTransaction();        
        sessionObj.delete(resultObj);                
        transactionObj.commit();
        
        System.out.println(".... DATA DELETED SUCCESSFULLY ....");
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    } 
}
