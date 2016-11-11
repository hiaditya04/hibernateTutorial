package com.raj.engine;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.raj.pojo.Child;
import com.raj.pojo.Parent;
 
public class Insert { 
 
    public static void main(String[] args)
    {
 
    	
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ....... ONE TO MANY INSERT DEMO ............\n");
        Configuration cfg = new Configuration();
        cfg.configure("com//raj//hbm//hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();        
                                   
        Parent parentObj=new Parent();
        parentObj.setName("Raj");
        
        Child chil1=new Child();
        chil1.setName("c11");
        chil1.setAge(5);
        chil1.setParent(parentObj);
        
        Child child2=new Child();
        child2.setName("c22");
        child2.setAge(9);
        child2.setParent(parentObj);
        
        Set<Child> childSet=new HashSet<Child>();
        childSet.add(chil1);
        childSet.add(child2);
        parentObj.setChildren(childSet);
        
        Transaction transaction = session.beginTransaction();
        session.save(parentObj);
        session.save(chil1);
        session.save(child2);
        transaction.commit();
        
        System.out.println("\n....... DATA INSERTED SUCCESSFULLY ..........");
        session.close();
        
        factory.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
