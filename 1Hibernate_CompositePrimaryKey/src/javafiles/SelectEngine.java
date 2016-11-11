package javafiles;

import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class SelectEngine { 
 
    public static void main(String[] javaPlanet)
    {
    	
    	 
    	System.out.println("********** START ************");
        Configuration configurationObj =  new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();                
        Session sessionObj = sessionFactoryObj.openSession();
        
        Creature creatureObj=new Creature(); 
        creatureObj.setId(1);
        creatureObj.setName("Tiger1");
 
        Creature creatureData=(Creature)sessionObj.get(Creature.class, creatureObj);
        System.out.println("  Creature's Data  ");
        System.out.println("--------------------");
        System.out.println(" Id	: "+creatureData.getId());
        System.out.println(" Name	: "+creatureData.getName());
        System.out.println(" Color	: "+creatureData.getColor());
                
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n-------STOP---------");
    } 
}
