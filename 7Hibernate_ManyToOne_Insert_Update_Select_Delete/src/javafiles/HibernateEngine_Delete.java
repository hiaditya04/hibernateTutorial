package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Delete { 
 
    public static void main(String[] javaPlanet)
    {
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ....... MANY TO ONE DELETE LESSON ............\n");
        Configuration configurationObj  =   new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj =  configurationObj.buildSessionFactory();                
        Session sessionObj  =  sessionFactoryObj.openSession();        
                           
        Children childObj = (Children) sessionObj.get(Children.class, new Integer(4));       
        Transaction transactionObj = sessionObj.beginTransaction();        
        sessionObj.delete(childObj);                
        transactionObj.commit();        
        System.out.println("....... DATA DELETED SUCCESSFULLY ..........");
        
        sessionObj.close();
        sessionFactoryObj.close();        
        System.out.println("....... ENGINE STOP ..........");
    } 
}
