package javafiles;

import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class HibernateEngine { 
 
    public static void main(String[] javaPlanet)
    {
 
      	System.out.println("********** START ************");
      	
        Configuration configurationObj =  new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();                
        Session sessionObj = sessionFactoryObj.openSession();
           
        Rural ruralObj=new Rural();
        ruralObj.setStateId(1);
        ruralObj.setStateName("Gujarat");
        ruralObj.setAreaId(1);
        ruralObj.setAreaName("Vrundavan");
        ruralObj.setPopulation(7000);
        ruralObj.setTotalSchools(4);
        
        Urban urbanObj=new Urban();
        urbanObj.setStateId(2);
        urbanObj.setStateName("Gujarat");        
        urbanObj.setAreaId(2);
        urbanObj.setAreaName("Anand");
        urbanObj.setPopulation(70000);
        urbanObj.setTotalColleges(11);
        
        Transaction transactionObj = sessionObj.beginTransaction();
        sessionObj.save(ruralObj);
        sessionObj.save(urbanObj);
        
        transactionObj.commit();
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("Area's Data saved successfully !");
        System.out.println("*********** END ************");
    }
 
}

/*
 CREATE TABLE HIB_AREA (ID NUMERIC PRIMARY KEY,AREA_NAME VARCHAR(20),PERSON_NAME VARCHAR(20),PERSON_QUALIFICATION VARCHAR(20))
 */