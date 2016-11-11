package javafiles;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Update {  
    public static void main(String[] javaPlanet)
    {
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. ONE TO MANY ANNOTATION UPDATE LESSON ..");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();        
                           
        Parent parentObj= (Parent) sessionObj.get(Parent.class, new Integer(101));
        parentObj.setName("Sunny");
        Set<Children> childrenSet=parentObj.getChildren();
        
        for(Children child:childrenSet){
        	child.setName("parker");
        	child.setAge(20);
        	child.setParent(null);
        }
        parentObj.setChildren(childrenSet);
        
        Transaction transaction=sessionObj.beginTransaction();        
        sessionObj.update(parentObj);                
        transaction.commit();
        
        System.out.println("....... DATA UPDATED SUCCESSFULLY ..........");
        sessionObj.close();
        sessionFactoryObj.close();        
        System.out.println("....... ENGINE STOP ..........");
    } 
}
