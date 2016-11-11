package javafiles;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Insert { 
 
    public static void main(String[] args)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ....... ONE TO MANY INSERT DEMO ............\n");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();        
                           
        Parent parentObj=new Parent();
        //parentObj.setId(12); // id is auto increment into database so no need to set it.
        parentObj.setName("Raj");
        
        Children childObj1=new Children();
        //childObj1.setId(1); // id is auto increment into database so no need to set it.
        childObj1.setName("Krishna");
        childObj1.setAge(56);
        
        Children childObj2=new Children();
        //childObj2.setId(2); // id is auto increment into database so no need to set it.
        childObj2.setName("Rajvir");
        childObj2.setAge(29);
        
        Set<Children> childrenSet = new HashSet<Children>();
        childrenSet.add(childObj1);
        childrenSet.add(childObj2);
        
        parentObj.setChildren(childrenSet);
        
        Transaction transaction=session.beginTransaction();
        session.save(parentObj);
        
        transaction.commit();
        
        System.out.println("\n....... DATA INSERTED SUCCESSFULLY ..........");
        session.close();
        factory.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
