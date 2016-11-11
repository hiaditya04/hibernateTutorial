package com.raj.engine;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.raj.pojo.Child;
import com.raj.pojo.Parent;
 
public class Select { 
 
    public static void main(String[] args)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ....... ONE TO MANY SELECT DEMO ............\n");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();        
                           
        Parent parentObj= (Parent) session.get(Parent.class, new Integer(1));
        
        if(parentObj==null){
        	System.out.println("\nNo Record Found");
        	return;
        }
        System.out.println("\n--------Parent Data----------");
        System.out.println("Parent Id 	: "+parentObj.getId());
        System.out.println("Parent Name : "+parentObj.getName());
        System.out.println("\n------------------------------\n");
        
        Set<Child> childrenSet = parentObj.getChildren();        
        System.out.println("\n---------Children Data--------");               
        System.out.println(" Child-Id\tName\tAge");
        System.out.println("--------------------------------");        
        for(Child child:childrenSet){
        	System.out.println("\t"+child.getId()+"\t"+child.getName()+"\t"+child.getAge());
        }
        System.out.println("-------------------------------");                
        session.close();
        factory.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
