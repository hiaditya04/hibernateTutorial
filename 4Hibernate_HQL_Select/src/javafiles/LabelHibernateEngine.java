package javafiles;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class LabelHibernateEngine { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory sessionfactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionfactoryObj.openSession();        
        
        System.out.println("-------------- USAGE OF LABLE --------------\n");   	

        Query queryObj1=sessionObj.createQuery("FROM Entity E WHERE E.id=:tempId");
        queryObj1.setParameter("tempId", 1);
        
        List entityIdList1 = queryObj1.list();
        Iterator listIterator1 = entityIdList1.iterator();
        
        System.out.println("ID \t NAME \t CATEGORY ");        
        System.out.println("--------------------------");        
        while(listIterator1.hasNext()){
        	Entity entityObj=(Entity)listIterator1.next();
        	System.out.print(entityObj.getId());
        	System.out.print("\t"+entityObj.getName());
        	System.out.println("\t"+entityObj.getCategory());
        }
        System.out.println("--------------------------");       
         
       	System.out.println("\n +++++++++++++ USAGE OF ?  +++++++++++++++++");
 
        Query queryObj2=sessionObj.createQuery("SELECT E.id,E.name FROM Entity E WHERE E.id=?");
        queryObj2.setParameter(0, 2);        
        List entityIdList2=queryObj2.list();
        Iterator listIterator2=entityIdList2.iterator();
        System.out.println("ID \t NAME");
        System.out.println("--------------");
        while(listIterator2.hasNext()){
        	Object[] data=(Object[])listIterator2.next();
        	System.out.println(data[0]+"\t"+data[1]);
        }
        sessionObj.close();
        
        sessionfactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
