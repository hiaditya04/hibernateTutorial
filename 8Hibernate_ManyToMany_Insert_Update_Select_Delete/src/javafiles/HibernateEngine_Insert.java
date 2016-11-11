package javafiles;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Insert { 
 
    public static void main(String[] javaPlanet)
    {
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println("...MANY TO MANY INSERT DEMO...");
        Configuration configurationObj  =   new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj =  configurationObj.buildSessionFactory();                
        Session sessionObj  =  sessionFactoryObj.openSession(); 
        
        MobilePhone phoneObj1= new MobilePhone();
        phoneObj1.setModelNumber(1133);
        phoneObj1.setName("NOKIA WOW");
        	
        MobilePhone phoneObj2= new MobilePhone();
        phoneObj2.setModelNumber(1110);
        phoneObj2.setName("NOKIA RAYS");        	

        Set<MobilePhone> mobilePhoneSet= new HashSet<MobilePhone>();
        mobilePhoneSet.add(phoneObj1);
        mobilePhoneSet.add(phoneObj2);
        
        User userObj1 = new User();
        userObj1.setName("Nainesh");
        userObj1.setAddress("Baroda, Alkapuri");
                
        User userObj2 = new User();
        userObj2.setName("Nisha");
        userObj2.setAddress("Bharuch, Narmada Colony");
        
        Set<User> userSet= new HashSet<User>();
        userSet.add(userObj1);
        userSet.add(userObj2);
        
        phoneObj1.setUsers(userSet);
        phoneObj2.setUsers(userSet);
        
        Transaction transaction=sessionObj.beginTransaction();
        sessionObj.save(phoneObj1);
        sessionObj.save(phoneObj2);                
        transaction.commit();      
        
        System.out.println("... DATA INSERTED SUCCESSFULLY...");
        sessionObj.close();        
        sessionFactoryObj.close();        
        System.out.println(".......ENGINE STOP........");
    }
 
}
