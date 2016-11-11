package javafiles;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Select { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ....... ONE TO MANY SELECT LESSON ............\n");
        Configuration configurationObj  =   new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj  =  configurationObj.buildSessionFactory();                
        Session sessionObj  =  sessionFactoryObj.openSession();        
                           
        Parent parentObj= (Parent) sessionObj.get(Parent.class, new Integer(1));
                
        System.out.println("\n--------Parent Data----------");
        System.out.println("Parent Id 	: "+parentObj.getId());
        System.out.println("Parent Name : "+parentObj.getName());
        System.out.println("\n------------------------------\n");
        
        Set<Children> childrenSet = parentObj.getChildren();        
        System.out.println("\n---------Children Data--------");               
        System.out.println(" Child-Id\tName\tAge");
        System.out.println("--------------------------------");        
        for(Children child:childrenSet){
        	System.out.print(child.getId()+"\t");
        	System.out.print("\t"+child.getName());
        	System.out.println("\t"+child.getAge());
        }
        System.out.println("-------------------------------");                
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
