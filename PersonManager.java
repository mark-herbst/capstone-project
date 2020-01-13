//PersonManager.java handles all object transactions with a database using Hibernate
import org.hibernate.Session;
import org.hibernate.criterion.*;
import java.io.Serializable;
import java.util.List;
public class PersonManager implements EntityTypes {//implements TransactionManager 
	private Session session;	
	
	public PersonManager(){}//Default constructor
	
	public Person findPersonByID(Long id)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();       
        Person personFound = (Person)session.load(Person.class, id);        
        session.getTransaction().commit();
        session.close();  
        return personFound;
	}
	
	/** Returns a list of Organizations based on Example given
 	(Pages 624 & 681 Hibernate book) */
	public List findPersonsByExample(Person p)
	{						
		//.ignoreCase() goes to lower case in Oracle was after .add(examplePerson)
		//.setFetchSize(50)//Get only first 50 hits 
		//By default all value-typed properties, excluding identifier property,
		//are used in comparison. To exclude: .excludeProperty("dob") etc.
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();			
		List results = session.createCriteria(Person.class)//retreives all persistent instances				
									.addOrder(Order.asc("name"))//order results by name
									.list();		
		//System.out.println("PersonManager results size " + results.size());
		session.getTransaction().commit();
		session.close(); 			
		return results;	
	}		
	
	/** Adds a Person to the database
 		Pre-condition:  The Person does not exist in the database */
	public void add(Person p)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();       
        Serializable personId = session.save(p);
		session.save(p);
        session.getTransaction().commit();
        session.close();  
	}
	
	public void update(Person p)
	{
		
	}
	
	public void save(Person p)
	{
		
	}
}