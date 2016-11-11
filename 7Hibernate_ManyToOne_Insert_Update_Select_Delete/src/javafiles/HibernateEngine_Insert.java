package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Insert { 
	
    public static void main(String[] javaPlanet)
    {
    	System.out.println(" .......  ENGINE START ............");
    	System.out.println(" ....... MANY TO ONE INSERT LESSON ............\n");
        Configuration configurationObj  =   new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj =  configurationObj.buildSessionFactory();                
        Session sessionObj  =  sessionFactoryObj.openSession();        
                                          
        Parent parentObj = new Parent();
        parentObj.setName("Mrs. Rose Jack Den");
        
        Children childObj1 = new Children();
        childObj1.setName("Alish");
        childObj1.setAge(12);
        childObj1.setParentObj(parentObj);
        
        Children childObj2 = new Children();
        childObj2.setName("Hem");
        childObj2.setAge(10);
        childObj2.setParentObj(parentObj);
        
        Transaction transaction = sessionObj.beginTransaction();
        sessionObj.save(childObj1);
        sessionObj.save(childObj2);                
        transaction.commit();      
        
        System.out.println("\n....... DATA INSERTED SUCCESSFULLY ..........");        
        sessionObj.close();        
        sessionFactoryObj.close();        
        System.out.println("\n....... ENGINE STOP ..........");
    }

}
