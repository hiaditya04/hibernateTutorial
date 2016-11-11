package javafiles;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Update { 
 
    public static void main(String[] javaPlanet)
    {
    	System.out.println("....... ENGINE START ............");
    	System.out.println("...MANY TO MANY UPDATE LESSON...");
        Configuration configurationObj  =   new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj =  configurationObj.buildSessionFactory();                
        Session sessionObj  =  sessionFactoryObj.openSession();       
                           
        User userObj = (User) sessionObj.get(User.class, new Integer(1));
        userObj.setName("Dharm"); // changing user name here
        Set<MobilePhone> mobilePhoneSet = userObj.getMobilePhones();
        
        for(MobilePhone phone:mobilePhoneSet){
        	if(phone.getModelNumber()==1133)
        		phone.setName("SAMSUNG galaxy");// changing new phone name here         	
        }
        userObj.setMobilePhones(mobilePhoneSet);
        
        Transaction transaction=sessionObj.beginTransaction();        
        sessionObj.update(userObj);                
        transaction.commit();
        
        System.out.println("....... DATA UPDATED SUCCESSFULLY ..........");
        sessionObj.close();
        sessionFactoryObj.close();        
        System.out.println("....... ENGINE STOP ..........");
    }
 
}
