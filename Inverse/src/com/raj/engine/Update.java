package com.raj.engine;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.raj.pojo.Child;
import com.raj.pojo.Parent;
 
public class Update { 
 
    public static void main(String[] args)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ....... ONE TO MANY UPDATE DEMO ............\n");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();        
                           
        Parent parentObj= (Parent) session.get(Parent.class, new Integer(1));
        parentObj.setName("Gaurang");
        Set<Child> childrenSet=parentObj.getChildren();
        
        for(Child child:childrenSet){
        	child.setName("Gulab11111");
        	child.setAge(200);
        }
        parentObj.setChildren(childrenSet);
        
        Transaction transaction=session.beginTransaction();        
        session.update(parentObj);                
        transaction.commit();
        
        System.out.println("\n....... DATA UPDATED SUCCESSFULLY ..........");
        session.close();
        factory.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
