//EventManager.java handles all object transactions with a database using Hibernate
import org.hibernate.Session;
import org.hibernate.criterion.*;
import java.io.Serializable;
import java.util.List;

public class EventManager {
	private Session session;
	
	public EventManager(){}//default constructor
	
	public Event findEventByID(Long id)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();       
        Event eventFound = (Event)session.load(Event.class, id);        
        session.getTransaction().commit();
        session.close();  
        return eventFound;
	}
	
	/** Returns a List of Events based on Example given
 	(Pages 624 & 681 Hibernate book) */
	public List findEventsByExample(Event anEvent)
	{						
		//.ignoreCase() goes to lower case in Oracle was after .add(examplePerson)
		//.setFetchSize(50)//Get only first 50 hits 
		//By default all value-typed properties, excluding identifier property,
		//are used in comparison. To exclude: .excludeProperty("dob") etc.
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();			
		List results = session.createCriteria(Event.class)//retreives all persistent instances				
									.addOrder(Order.asc("eventDate"))//order results by name
									.list();		
		session.getTransaction().commit();
		session.close(); 			
		return results;	
	}		
	
	/** Adds an Event to the database
 		Pre-condition:  The Event does not exist in the database */
	public void add(Event anEvent)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();       
        Serializable eventId = session.save(anEvent);
		session.save(anEvent);
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
