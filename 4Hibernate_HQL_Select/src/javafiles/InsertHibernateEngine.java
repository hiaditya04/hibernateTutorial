package javafiles;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class InsertHibernateEngine { 
 
    public static void main(String[] dataBag)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	
        Configuration configurationObj =  new Configuration();        
        configurationObj.configure("hibernate.cfg.xml"); 
        
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();                
        Session sessionObj = sessionFactoryObj.openSession();       
                           
 		Query queryObj1 = sessionObj.createQuery("INSERT INTO Item (id,name,category) SELECT E.id,E.name,E.category FROM Entity E"); // WHERE  E.id>=? 		
        //queryObj1.setParameter(0, 0);
        
        int totalInserted = queryObj1.executeUpdate();
        
        if(totalInserted == 0){
        	System.out.println(" No record inserted. ");
        }else{
        	System.out.println(" Total inserted records : "+totalInserted);
        }
        
        Transaction transactionObj =  sessionObj.beginTransaction();
        transactionObj.commit();        
  
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
