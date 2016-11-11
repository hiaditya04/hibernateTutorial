package javafiles;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class SelectHibernateEngine { 
 
    public static void main(String[] javaPlanet)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory sessionfactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionfactoryObj.openSession();        
        
        /*
        Entity entity =  new Entity();
        entity.setId(2);
        entity.setName("Tiger");
        entity.setCategory("Animal");
        Transaction trans = sessionObj.beginTransaction();
        sessionObj.save(entity);
        trans.commit();
        */
        
        /* FETCHING ONE COLUMN DATA FROM THE TABLE "ENTITIES" */ 
        Query queryObj1 = sessionObj.createQuery("SELECT E.id FROM Entity E");        
        List entityIdList1 = queryObj1.list();
        Iterator listIterator1 = entityIdList1.iterator();
        System.out.println("ID");
        System.out.println("---");
        while(listIterator1.hasNext()){
        	Integer id=(Integer)listIterator1.next();
        	System.out.println(id);
        }
        System.out.println("-------");
        
        
        // FETCHING MORE THAN ONE COLUMN'S DATA FROM THE TABLE "ENTITIES" 
        Query queryObj2 = sessionObj.createQuery("SELECT E.id,E.name FROM Entity E");        
        List entityIdList2 = queryObj2.list();
        Iterator listIterator2 = entityIdList2.iterator();
        System.out.println("ID \t NAME");
        System.out.println("--------------");
        while(listIterator2.hasNext()){
        	Object[] data=(Object[])listIterator2.next();
        	System.out.println(data[0]+"\t"+data[1]);
        }
        System.out.println("--------------");
         
        
        //FETCHING ROWS OF ENTITY FROM THE TABLE "ENTITIES" 
        Query queryObj3 = sessionObj.createQuery("SELECT E FROM Entity E");        
        List entityList = queryObj3.list();
        Iterator listIterator3 = entityList.iterator();
        System.out.println("ID \tNAME \t CATEGORY");
        System.out.println("-----------------------");
        
        while(listIterator3.hasNext()){
        	Entity entityObj = (Entity)listIterator3.next();
        	System.out.print(entityObj.getId());
        	System.out.print("\t"+entityObj.getName());
        	System.out.println("\t"+entityObj.getCategory());
        }
        System.out.println("-----------------------");

        
        sessionObj.close();
        sessionfactoryObj.close();
        
        System.out.println(" ....... ENGINE STOP ..........");
    }
 
}
