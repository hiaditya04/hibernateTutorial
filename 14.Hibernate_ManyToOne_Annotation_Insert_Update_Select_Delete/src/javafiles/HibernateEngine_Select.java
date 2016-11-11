package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Select { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. MANY TO ONE ANNOTATION SELECT LESSON ..\n");
        Configuration condigurationObj = new Configuration();
        condigurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory factoryObj = condigurationObj.buildSessionFactory();
        Session sessionObj = factoryObj.openSession();        
                              
        Children childObj= (Children) sessionObj.get(Children.class, new Integer(2));
                
        System.out.println("\n--------Child Data---------");
        System.out.println("Id	:"+childObj.getId());
        System.out.println("Name	:"+childObj.getName());
        System.out.println("Age	:"+childObj.getAge());
        System.out.println("----------------------------\n");
        
        Parent parentObj = (Parent) childObj.getParentObj();
        System.out.println("--------Parent Data---------");
        System.out.println("Id	: "+parentObj.getId());
        System.out.println("Name	:"+parentObj.getName());        
        System.out.println("----------------------------");
                   
        sessionObj.close();
        factoryObj.close();
        System.out.println(".. MANY TO ONE  ANNOTATION SELECT LESSON DONE ..");
        System.out.println("....... ENGINE STOP ..........");
    }
 
}
