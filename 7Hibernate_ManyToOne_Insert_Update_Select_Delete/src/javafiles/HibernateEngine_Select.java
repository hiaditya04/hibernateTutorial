package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Select { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ...MANY TO MANY SELECT LESSON... ");
        Configuration configurationObj  =   new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj =  configurationObj.buildSessionFactory();                
        Session sessionObj  =  sessionFactoryObj.openSession();        
                              
        Children childObj= (Children) sessionObj.get(Children.class, new Integer(3));
                
        System.out.println("\n--------Child Data----------");
        System.out.println("Id	: "+childObj.getId());
        System.out.println("Name	: "+childObj.getName());
        System.out.println("Age	: "+childObj.getAge());
        System.out.println("------------------------------\n");
        
        Parent parentObj = (Parent) childObj.getParentObj();
        System.out.println("\n--------Parent Data----------");
        System.out.println("Id	: "+parentObj.getId());
        System.out.println("Name	: "+parentObj.getName());        
        System.out.println("------------------------------\n");
                   
        sessionObj.close();
        sessionFactoryObj.close();
        System.out.println("....... MANY TO ONE SELECT DEMO DONE............\n");
        System.out.println("....... ENGINE STOP ..........");
    }
 
}
