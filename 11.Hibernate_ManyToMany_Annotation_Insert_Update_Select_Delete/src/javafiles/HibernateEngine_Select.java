package javafiles;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Select { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. MANY TO MANY ANNOTATION SELECT LESSON ..\n");
 /*       Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();  */
    	HibernateSessionFactory.buildSessionFactory();
    	Session session = HibernateSessionFactory.getSession();
                           
        User usertObj= (User) session.get(User.class, new Integer(1));
                
        System.out.println("\n--------Users Data----------");
        System.out.println("Id	: "+usertObj.getId());
        System.out.println("Name	: "+usertObj.getName());
        System.out.println("Address	: "+usertObj.getAddress());
        System.out.println("\n------------------------------\n");
        
        Set<MobilePhone> mobilePhoneSet = usertObj.getMobilePhones();        
        System.out.println("\n---------MobilePhone Data--------");               
        System.out.println("Model-Number\t Name");
        System.out.println("--------------------------------");        
        for(MobilePhone phone:mobilePhoneSet){
        	System.out.println(phone.getModelNumber()+"\t"+phone.getName());
        }
        System.out.println("-------------------------------");                
        session.close();
        HibernateSessionFactory.shutDown();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
