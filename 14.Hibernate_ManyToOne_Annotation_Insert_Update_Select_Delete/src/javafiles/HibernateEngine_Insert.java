package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Insert{  
    public static void main(String[] javaPlanet)
    {    	
    	System.out.println(" .......ENGINE START ............");
    	System.out.println(" .. MANY TO ONE ANNONTATION INSERT LESSON ..");
        Configuration condigurationObj = new Configuration();
        condigurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory factoryObj = condigurationObj.buildSessionFactory();
        Session sessionObj = factoryObj.openSession();        
                                   
        Parent parentObj=new Parent();
        parentObj.setName("Karna");
        
        Children childObj1=new Children();
        childObj1.setName("Abhi");
        childObj1.setAge(11);
        childObj1.setParentObj(parentObj);
        
        Children childObj2=new Children();
        childObj2.setName("Adi");
        childObj2.setAge(10);
        childObj2.setParentObj(parentObj);
        
        Transaction transaction=sessionObj.beginTransaction();
        sessionObj.save(childObj1);
        sessionObj.save(childObj2);
                
        transaction.commit();        
        System.out.println(".. DATA INSERTED SUCCESSFULLY ..");
        
        sessionObj.close();        
        factoryObj.close();
        
        System.out.println(".......ENGINE STOP ..........");
    } 
}
