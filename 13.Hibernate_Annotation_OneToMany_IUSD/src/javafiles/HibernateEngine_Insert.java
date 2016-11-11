package javafiles;

/*
 * Author : RAJ 
 */
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateEngine_Insert {

	public static void main(String[] javaPlanet) {
		System.out.println(" ....... ENGINE START ............");
		System.out.println(" .. ANNOTATION ONE TO MANY INSERT LESSON ..\n");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml"); 
 
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();

		Parent parentObj = new Parent();
		parentObj.setId(101); 								 
		parentObj.setName("Kandarp");

		
		SubChildren subChildren = new SubChildren();
		subChildren.setId(1);
		subChildren.setName("subchild");
		
		Set<SubChildren> subSet = new HashSet<SubChildren>();
		subSet.add(subChildren);
		
		
		Children childObj1 = new Children();
		childObj1.setId(1); 
		childObj1.setName("Prexa");
		childObj1.setAge(10);
		//childObj1.setParent(parentObj);
		//childObj1.setChildSet(subSet);

		Children childObj2 = new Children();
		childObj2.setId(2); 
		childObj2.setName("ram");
		childObj2.setAge(29);
		//childObj2.setParent(parentObj);
		//childObj2.setSubChildren(subSet);

		Set<Children> childSet = new HashSet<Children>();
		childSet.add(childObj1);
		childSet.add(childObj2);
		parentObj.setChildren(childSet);

		Transaction transaction = sessionObj.beginTransaction();
		sessionObj.save(parentObj);
		transaction.commit();

		System.out.println("\n.. DATA INSERTED SUCCESSFULLY ..");
		sessionObj.close();
		sessionFactoryObj.close();
		System.out.println("....... ENGINE STOP ..........");
	}
}
