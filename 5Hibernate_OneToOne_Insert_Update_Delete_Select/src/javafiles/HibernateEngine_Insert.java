package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Insert { 
 
    public static void main(String[] javaPlanet)
    {
    	System.out.println(" ....... ENGINE START ............ ");
    	System.out.println(" ... ONE TO ONE INSERT DEMO .... ");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();
                
        Pupil pupilObj = new Pupil();
        pupilObj.setName("Renny1");
        pupilObj.setAddress("Anand, A.V.ROAD");
        
        Result resultObj = new Result();
        resultObj.setMathsMarks(99);
        resultObj.setScienceMarks(91);
        resultObj.setTotalMarks((resultObj.getScienceMarks()+resultObj.getMathsMarks()));
        resultObj.setPupil(pupilObj);
        
        Transaction transactionObj = sessionObj.beginTransaction();
        sessionObj.save(resultObj);        
                
        transactionObj.commit();        
        sessionObj.close();        
        sessionFactoryObj.close();        
        
        System.out.println("...DATA INSERTED SUCCESSFULLY...");
        System.out.println("....... ENGINE STOP ........");
    } 
}
