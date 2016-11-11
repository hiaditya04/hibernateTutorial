package javafiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateEngine { 
 
    public static void main(String[] dataBag)
    {
    	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" ..ANNOTATION LESSON TO SAVE DATA..\n");
    	
    	Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();        
        Session sessionObj = sessionFactoryObj.openSession();
        
        Student studentObj = new Student();
        studentObj.setRollNumber(1);
        studentObj.setName("Nishidh");
        studentObj.setAddress("Nadiad");
        
        Transaction transactionObj = sessionObj.beginTransaction();
        sessionObj.save(studentObj);
        transactionObj.commit();
        
        sessionObj.close();        
        sessionFactoryObj.close();
        System.out.println(".. Student Data Saved successfully ! ..");
        System.out.println("....... ENGINE STOP ..........");
    } 
}
