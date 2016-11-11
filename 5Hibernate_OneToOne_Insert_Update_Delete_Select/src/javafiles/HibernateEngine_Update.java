package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Update { 
 
    public static void main(String[] javaPlanet)
    {     	    
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ....ONE TO ONE UPDATE LESSON.... ");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();
         
        Result resultObj = (Result) sessionObj.get(Result.class, new Integer(1));
        resultObj.setMathsMarks(81);
        resultObj.setScienceMarks(81);
        resultObj.setTotalMarks(resultObj.getMathsMarks()+resultObj.getScienceMarks());
        
        Pupil pupilObj = resultObj.getPupil(); 
        pupilObj.setName("Rose");
      
        Transaction transaction=sessionObj.beginTransaction();        
        sessionObj.update(resultObj);                
        transaction.commit();
        
        System.out.println(".... DATA UPDATED SUCCESSFULLY ....");
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("....... ENGINE STOP ..........");
    } 
}
