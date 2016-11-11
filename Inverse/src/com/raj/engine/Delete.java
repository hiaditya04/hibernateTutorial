package com.raj.engine;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.raj.pojo.Parent;
 
public class Delete { 
 
    public static void main(String[] args)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ....... ONE TO MANY DELETE DEMO ............\n");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();        
                           
        Parent parentObj= (Parent) session.get(Parent.class, new Integer(1));        
        Transaction transaction=session.beginTransaction();        
        session.delete(parentObj);                
        transaction.commit();
        
        System.out.println("\n....... DATA DELETED SUCCESSFULLY ..........");
        session.close();
        factory.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
