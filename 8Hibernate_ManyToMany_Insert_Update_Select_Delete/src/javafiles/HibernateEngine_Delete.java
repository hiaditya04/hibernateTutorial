package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Delete {  
    public static void main(String[] javaPlanet)
    {
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println("... MANY TO MANY DELETE DEMO .....");
        Configuration configurationObj  =   new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj =  configurationObj.buildSessionFactory();                
        Session sessionObj  =  sessionFactoryObj.openSession();       
                           
        User usertObj= (User) sessionObj.get(User.class, new Integer(1));        
        Transaction transaction=sessionObj.beginTransaction();        
        sessionObj.delete(usertObj);                
        transaction.commit();
        
        System.out.println(".. DATA DELETED SUCCESSFULLY ..");
        sessionObj.close();
        sessionFactoryObj.close();        
        System.out.println("....... ENGINE STOP ......");
    }
}
