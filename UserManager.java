//UserManager.java manages persistent users of an application
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;
public class UserManager {
	private Session session;	
	public UserManager(){}//Default constructor
	
	/** Retrieves a persistent user (Hibernate book P562)
	 	Precondition:  username is unique in database */
	public Object find(String username)
	{		
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();       
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.like("username", username));//property, input
        User user = (User) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();  
        return user;
	}
	
	public void update(Object user)
	{
		
	}
	
	public void save(Object user)
	{
		
	}
	
	public void add(Object user)
	{
		
	}
}
