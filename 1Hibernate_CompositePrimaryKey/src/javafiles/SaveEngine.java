package javafiles;

import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class SaveEngine { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println("********** START ************");
        Configuration configurationObj =  new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();                
        Session sessionObj = sessionFactoryObj.openSession();

        Creature creature=new Creature(); 
 
        creature.setId(1);
        creature.setName("Tiger1");
        creature.setColor("Red-Yellow");
 
        Transaction tx = sessionObj.beginTransaction();
        sessionObj.save(creature);        
        tx.commit();
        System.out.println("Creature's Data saved successfully !");
        
        sessionObj.close();
        sessionFactoryObj.close();
        System.out.println("********** STOP ************");
    }
 
}
