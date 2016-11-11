package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Update {
	
    public static void main(String[] javaPlanet)
    {
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" MANY TO ONE UPDATE LESSON \n");
        Configuration configurationObj  =   new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj =  configurationObj.buildSessionFactory();                
        Session sessionObj  =  sessionFactoryObj.openSession();          
                           
        Children childObj = (Children) sessionObj.get(Children.class, new Integer(3));
        childObj.setName("Exa");
        childObj.setAge(20);
        /* In below two line we are changing the already exist parent name*/
        Parent parentObj = childObj.getParentObj();
        parentObj.setName("Peter");
        
        /* In below three line we are adding a new parent for the exist child */
        /* 
        Parent newParentObj = new Parent();
        newParentObj.setName("Denny");
        childObj.setParentObj(newParentObj);
        */
        
        Transaction transaction=sessionObj.beginTransaction();        
        sessionObj.update(childObj);
        transaction.commit();
        
        System.out.println("\n....... DATA UPDATED SUCCESSFULLY ..........");
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
