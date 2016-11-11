package javafiles;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_SelectAll { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... START ............");
    	System.out.println(" ....... MANY TO ONE SELECT DEMO ............\n");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();        
                                   
        Criteria criteriaObj = session.createCriteria(Children.class);
        List<Children> childList	= criteriaObj.list();
        
        System.out.println("Parent-Name\tChild-Name \tChild-Age");
        System.out.println("------------------------------------------");
        for(Children childObj:childList){
        	System.out.print(childObj.getParentObj().getName());
        	System.out.print("\t\t"+childObj.getName());
        	System.out.println("\t\t"+childObj.getAge());        	
        }
        System.out.println("------------------------------------------");
               
        session.close();
        factory.close();
        System.out.println(" ....... MANY TO ONE SELECT DONE ............");
        System.out.println("\n....... STOP ..........");
    }
 
}

