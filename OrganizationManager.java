//PersonManager.java handles all object transactions with a database using Hibernate
import org.hibernate.Session;
import org.hibernate.criterion.*;
import java.io.Serializable;
import java.util.List;
public class OrganizationManager implements EntityTypes {
	private Session session;
	
	public OrganizationManager(){}//default constructor
	
	public Organization findOrganizationByID(Long id)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();       
        Organization orgFound = (Organization)session.load(Organization.class, id);        
        session.getTransaction().commit();
        session.close();  
        return orgFound;
	}
	
	/** Returns a list of Organizations based on Example given
	 	(Pages 624 & 681 Hibernate book) */
	public List findOrganizationsByExample(Organization p)
	{						
		//.ignoreCase() goes to lower case in Oracle was after .add(examplePerson)
		//.setFetchSize(50)//Get only first 50 hits 
		//By default all value-typed properties, excluding identifier property,
		//are used in comparison. To exclude: .excludeProperty("dob") etc.
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();	
		//retreives all persistent instances
		List results = session.createCriteria(Organization.class)
									//order results by name
									.addOrder(Order.asc("organizationName"))
									.list();		
		//System.out.println("PersonManager results size " + results.size());
		session.getTransaction().commit();
		session.close(); 			
		return results;	
	}		
	
	/** Adds an Organization to the database
	 	Pre-condition:  The organization does not exist in the database */
	public void add(Organization org)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();       
        Serializable orgId = session.save(org);
		session.save(org);
        session.getTransaction().commit();
        session.close();  
	}	
	
	public void update(Organization org)
	{
		
	}
	
	public void save(Organization org)
	{
		
	}
}
