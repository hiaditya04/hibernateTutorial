package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine { 
 
    public static void main(String[] javaPlanet)
    {
    	System.out.println("********** START ************");
        Configuration configurationObj =  new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();                
        Session sessionObj = sessionFactoryObj.openSession();
        sessionObj.get(Area.class,11);
        Rural ruralObj=new Rural();
        ruralObj.setAreaId(11);
        ruralObj.setAreaName("Gokul");
        ruralObj.setPopulation(5000);
        ruralObj.setTotalSchools(2);
        
        Urban urbanObj=new Urban();
        urbanObj.setAreaId(22);
        urbanObj.setAreaName("Baroda");
        urbanObj.setPopulation(20000);
        urbanObj.setTotalColleges(5);
      
        Transaction transactionObj = sessionObj.beginTransaction();
        sessionObj.save(ruralObj);
        sessionObj.save(urbanObj);
                
        transactionObj.commit();
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("Data saved successfully !");
        System.out.println("********** STOP ************");
    }
 
}

