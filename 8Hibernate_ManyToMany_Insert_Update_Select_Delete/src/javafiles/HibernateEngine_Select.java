package javafiles;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Select { 
 
    public static void main(String[] javaPlanet)
    {
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ... MANY TO MANY SELECT DEMO ...");
        Configuration configurationObj  =   new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj =  configurationObj.buildSessionFactory();                
        Session sessionObj  =  sessionFactoryObj.openSession();        
                           
        User usertObj= (User) sessionObj.get(User.class, new Integer(1));
                
        System.out.println("\n--------User Data----------");
        System.out.println("Id	: "+usertObj.getId());
        System.out.println("Name	: "+usertObj.getName());
        System.out.println("Address	: "+usertObj.getAddress());
        System.out.println("----------------------------\n");
        
        Set<MobilePhone> mobilePhoneSet = usertObj.getMobilePhones();        
        System.out.println("\n-----MobilePhone Data------");               
        System.out.println("ID\tModel#\tName");
        System.out.println("----------------------------");        
        for(MobilePhone phone:mobilePhoneSet){
        	System.out.print(phone.getId());
        	System.out.print("\t"+phone.getModelNumber());
        	System.out.println("\t"+phone.getName());
        }
        System.out.println("----------------------------");                
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("....... ENGINE STOP ..........");
    }
 
}
