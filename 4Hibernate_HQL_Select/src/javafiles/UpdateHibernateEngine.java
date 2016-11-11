package javafiles;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class UpdateHibernateEngine { 
 
    public static void main(String[] dataBag)
    {
 
    	System.out.println(" ....... ENGINE START ............");
    	
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();        
        
         
        /*      
 		Query queryObj1=session.createQuery("UPDATE Entity E SET E.name='daisy' WHERE E.id=:tempId");
        queryObj1.setParameter("tempId", 98304);
        
        int totalDeleted1=queryObj1.executeUpdate();
        
        if(totalDeleted1==0){
        	System.out.println(" No record deleted. ");
        }else{
        	System.out.println(" Total deleted records : "+totalDeleted1);
        }
        */
        
        Query queryObj2 = session.createQuery("UPDATE Entity E SET E.name='Peacock' WHERE E.id=?");
        queryObj2.setParameter(0, 2);
        
        int totalDeleted2 = queryObj2.executeUpdate();
        
        if(totalDeleted2==0){
        	System.out.println(" No record updated. ");
        }else{
        	System.out.println(" Total number of updated records : "+totalDeleted2);
        }
        
        Transaction transactionObj =  session.beginTransaction();
        transactionObj.commit();
        session.close();
        factory.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    }
 
}
