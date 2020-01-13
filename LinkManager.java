//LinkManager.java handles database transactions related to links between objects
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class LinkManager implements EntityTypes {
	private Session session;
	
	public LinkManager(){}//default constructor
	
	/** Adds a Person-Person link to the database */
	public void addPersonPersonLink(Person parent, Person child)
	{
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		LinkPersonPerson personLink = new LinkPersonPerson();
		personLink.setParentPerson(parent);
		personLink.setPersonLink(child);
		session.save(personLink);
        session.getTransaction().commit();
        session.close();  		
	}
	
	/** Adds an Organization-Organization link to the database */
	public void addOrganizationOrganizationLink(Organization parent, Organization child)
	{
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		LinkOrganizationOrganization orgLink = new LinkOrganizationOrganization();
		orgLink.setParentOrganization(parent);
		orgLink.setOrganizationLink(child);
		session.save(orgLink);
        session.getTransaction().commit();
        session.close();  		
	}
	
	/** Adds an Event-Event link to the database */
	public void addEventEventLink(Event parent, Event child)
	{
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		LinkEventEvent eventLink = new LinkEventEvent();
		eventLink.setParentEvent(parent);
		eventLink.setEventLink(child);
		session.save(eventLink);
        session.getTransaction().commit();
        session.close();  		
	}
	
	/** Adds a Person-Organization link to the database */
	public void addPersonOrganizationLink(Person person, Organization org)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		LinkPersonOrganization personOrgLink = new LinkPersonOrganization();
		personOrgLink.setPerson(person);
		personOrgLink.setOrganization(org);
		session.save(personOrgLink);
        session.getTransaction().commit();
        session.close(); 
	}	
	
	/** Adds a Person-Event link to the database */
	public void addPersonEventLink(Person person, Event event)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		LinkPersonEvent personEventLink = new LinkPersonEvent();
		personEventLink.setPerson(person);
		personEventLink.setEvent(event);
		session.save(personEventLink);
        session.getTransaction().commit();
        session.close(); 
	}	
	
	/** Adds an Organization-Event link to the database */
	public void addOrganizationEventLink(Organization org, Event event)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		LinkOrganizationEvent orgEventLink = new LinkOrganizationEvent();
		orgEventLink.setOrganization(org);
		orgEventLink.setEvent(event);
		session.save(orgEventLink);
        session.getTransaction().commit();
        session.close(); 
	}
	
	/** Returns a List of Person Link Nodes associated with a Person
	 	Pre-condition:  The person already exists in the database */
	public List getPersonPersonLinkNodes(Person parent)
	{
		List personLinkNodes = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List personLinks = session.createCriteria(LinkPersonPerson.class)
						.add(Restrictions.eq("parentPerson", parent))	
						.list();
		for (Iterator it = personLinks.iterator();
					it.hasNext();) {
			LinkPersonPerson aPersonLink = (LinkPersonPerson)it.next();
			Long id = aPersonLink.getPersonLink().getId();
			String text = aPersonLink.getPersonLink().getName().toString();
			Node linkNode = new Node();
			linkNode.setId(id);
			linkNode.setTYPE(PERSON);
			linkNode.setText(text);
			personLinkNodes.add(linkNode);
		}    	
		session.getTransaction().commit();
        session.close(); 
        return personLinkNodes;
	}
	
	/** Returns a List of Organization Link Nodes associated with a Person
	 	Pre-condition:  The person already exists in the database */
	public List getPersonOrganizationLinkNodes(Person person)
	{
		List orgLinkNodes = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List orgLinks = session.createCriteria(LinkPersonOrganization.class)
						.add(Restrictions.eq("person", person))	
						.list();
		for (Iterator it = orgLinks.iterator();
					it.hasNext();) {
			LinkPersonOrganization anOrgLink = (LinkPersonOrganization)it.next();
			Long id = anOrgLink.getOrganization().getId();
			String text = anOrgLink.getOrganization().toString();
			Node linkNode = new Node();
			linkNode.setId(id);
			linkNode.setTYPE(ORGANIZATION);
			linkNode.setText(text);
			orgLinkNodes.add(linkNode);
		}    	
		session.getTransaction().commit();
        session.close(); 
        return orgLinkNodes;
	}
	
	/** Returns a List of Event Link Nodes associated with a Person
 		Pre-condition:  The person already exists in the database */
	public List getPersonEventLinkNodes(Person person)
	{
		List eventLinkNodes = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List eventLinks = session.createCriteria(LinkPersonEvent.class)
						.add(Restrictions.eq("person", person))	
						.list();
		for (Iterator it = eventLinks.iterator();
					it.hasNext();) {
			LinkPersonEvent anEventLink = (LinkPersonEvent)it.next();
			Long id = anEventLink.getEvent().getId();
			String text = anEventLink.getEvent().getTitle().toString();
			Node linkNode = new Node();
			linkNode.setId(id);
			linkNode.setTYPE(EVENT);
			linkNode.setText(text);
			eventLinkNodes.add(linkNode);
		}    	
		session.getTransaction().commit();
	    session.close(); 
	    return eventLinkNodes;
	}
	
	/** Returns a List of Organization Link Nodes associated with an Organization
	 	Pre-condition:  The organization already exists in the database */
	public List getOrganizationOrganizationLinkNodes(Organization parent)
	{
		List organizationLinkNodes = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List organizationLinks = session.createCriteria(LinkOrganizationOrganization.class)
						.add(Restrictions.eq("parentOrganization", parent))	
						.list();
		for (Iterator it = organizationLinks.iterator();
					it.hasNext();) {
			LinkOrganizationOrganization anOrgLink = (LinkOrganizationOrganization)it.next();
			Long id = anOrgLink.getOrganizationLink().getId();
			String text = anOrgLink.getOrganizationLink().toString();
			Node linkNode = new Node();
			linkNode.setId(id);
			linkNode.setTYPE(ORGANIZATION);
			linkNode.setText(text);
			organizationLinkNodes.add(linkNode);
		}    	
		session.getTransaction().commit();
        session.close(); 
        return organizationLinkNodes;
	}
	
	/** Returns a List of Person Link Nodes associated with an Organization
 		Pre-condition:  The Organization already exists in the database */
	public List getOrganizationPersonLinkNodes(Organization parent)
	{
		List personLinkNodes = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List personLinks = session.createCriteria(LinkPersonOrganization.class)
						.add(Restrictions.eq("organization", parent))	
						.list();
		for (Iterator it = personLinks.iterator();
					it.hasNext();) {
			LinkPersonOrganization aPersonLink = (LinkPersonOrganization)it.next();
			Long id = aPersonLink.getPerson().getId();
			String text = aPersonLink.getPerson().getName().toString();
			Node linkNode = new Node();
			linkNode.setId(id);
			linkNode.setTYPE(PERSON);
			linkNode.setText(text);
			personLinkNodes.add(linkNode);
		}    	
		session.getTransaction().commit();
	    session.close(); 
	    return personLinkNodes;
	}
	
	/** Returns a List of Event Link Nodes associated with an Organization
 		Pre-condition:  The Organization already exists in the database */
	public List getOrganizationEventLinkNodes(Organization parent)
	{
		List eventLinkNodes = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List eventLinks = session.createCriteria(LinkOrganizationEvent.class)
						.add(Restrictions.eq("organization", parent))	
						.list();
		for (Iterator it = eventLinks.iterator();
					it.hasNext();) {
			LinkOrganizationEvent anEventLink = (LinkOrganizationEvent)it.next();
			Long id = anEventLink.getId();
			String text = anEventLink.getEvent().getTitle().toString();
			Node linkNode = new Node();
			linkNode.setId(id);
			linkNode.setTYPE(EVENT);
			linkNode.setText(text);
			eventLinkNodes.add(linkNode);
		}    	
		session.getTransaction().commit();
	    session.close(); 
	    return eventLinkNodes;
	}
	
	/** Returns a List of Event Link Nodes associated with an Event
 		Pre-condition:  The Event already exists in the database */
	public List getEventEventLinkNodes(Event parent)
	{
		List eventLinkNodes = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List eventLinks = session.createCriteria(LinkEventEvent.class)
						.add(Restrictions.eq("parentEvent", parent))	
						.list();
		for (Iterator it = eventLinks.iterator();
					it.hasNext();) {
			LinkEventEvent anEventLink = (LinkEventEvent)it.next();
			Long id = anEventLink.getEventLink().getId();
			String text = anEventLink.getEventLink().getTitle().toString();
			Node linkNode = new Node();
			linkNode.setId(id);
			linkNode.setTYPE(EVENT);
			linkNode.setText(text);
			eventLinkNodes.add(linkNode);
		}    	
		session.getTransaction().commit();
	    session.close(); 
	    return eventLinkNodes;
	}
	
	/** Returns a List of Organization Link Nodes associated with an Event
 		Pre-condition:  The Event already exists in the database */
	public List getEventOrganizationLinkNodes(Event event)
	{
		List orgLinkNodes = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List orgLinks = session.createCriteria(LinkOrganizationEvent.class)
						.add(Restrictions.eq("event", event))	
						.list();
		for (Iterator it = orgLinks.iterator();
					it.hasNext();) {
			LinkOrganizationEvent anOrgLink = (LinkOrganizationEvent)it.next();
			Long id = anOrgLink.getOrganization().getId();
			String text = anOrgLink.getOrganization().toString();
			Node linkNode = new Node();
			linkNode.setId(id);
			linkNode.setTYPE(ORGANIZATION);
			linkNode.setText(text);
			orgLinkNodes.add(linkNode);
		}    	
		session.getTransaction().commit();
	    session.close(); 
	    return orgLinkNodes;
	}
	
	/** Returns a List of Person Link Nodes associated with an Event
		Pre-condition:  The Organization already exists in the database */
	public List getEventPersonLinkNodes(Event parent)
	{
		List personLinkNodes = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List personLinks = session.createCriteria(LinkPersonEvent.class)
						.add(Restrictions.eq("event", parent))	
						.list();
		for (Iterator it = personLinks.iterator();
					it.hasNext();) {
			LinkPersonEvent aPersonLink = (LinkPersonEvent)it.next();
			Long id = aPersonLink.getPerson().getId();
			String text = aPersonLink.getPerson().getName().toString();
			Node linkNode = new Node();
			linkNode.setId(id);
			linkNode.setTYPE(PERSON);
			linkNode.setText(text);
			personLinkNodes.add(linkNode);
		}    	
		session.getTransaction().commit();
	    session.close(); 
	    return personLinkNodes;
	}
	
	/** Returns a List of Person Links associated with a Person
	 	Pre-condition:  The person already exists in the database */
	public List getPersonPersonLinks(Person parent)
	{
		List personLinks = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List personLinkIDs = session.createCriteria(LinkPersonPerson.class)
						.add(Restrictions.eq("parentPerson", parent))	
						.list();
		for (Iterator it = personLinkIDs.iterator();
					it.hasNext();) {
			LinkPersonPerson aPersonLink = (LinkPersonPerson)it.next();
			PersonLink aLink = new PersonLink();
			aLink.setId(aPersonLink.getPersonLink().getId());
			aLink.setName(aPersonLink.getPersonLink().getName().toString());
			aLink.setGender(aPersonLink.getPersonLink().getGender().toString());
			aLink.setRace(aPersonLink.getPersonLink().getRace().toString());
			GenericDate dob = new GenericDate();
			dob.setTheDate(aPersonLink.getPersonLink().getDob());
			aLink.setDob(dob.toString());
			personLinks.add(aLink);
		}    	
		session.getTransaction().commit();
        session.close(); 
        return personLinks;
	}
	
	/** Returns a List of Organization Links associated with an Organization
	 	Pre-condition:  The organization already exists in the database */
	public List getOrganizationOrganizationLinks(Organization parent)
	{
		List orgLinks = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List orgLinkIDs = session.createCriteria(LinkOrganizationOrganization.class)
						.add(Restrictions.eq("parentOrganization", parent))	
						.list();
		for (Iterator it = orgLinkIDs.iterator();
					it.hasNext();) {
			LinkOrganizationOrganization anOrgLink = (LinkOrganizationOrganization)it.next();
			OrganizationLink aLink = new OrganizationLink();
			aLink.setId(anOrgLink.getOrganizationLink().getId());
			aLink.setOrganizationName(anOrgLink.getOrganizationLink().toString());
			orgLinks.add(aLink);
		}    	
		session.getTransaction().commit();
        session.close(); 
        return orgLinks;
	}
	
	/** Returns a List of Event Links associated with an Event
 		Pre-condition:  The Event already exists in the database */
	public List getEventEventLinks(Event parent)
	{
		List eventLinks = new ArrayList();
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();  
		List eventLinkIDs = session.createCriteria(LinkEventEvent.class)
						.add(Restrictions.eq("parentEvent", parent))	
						.list();
		for (Iterator it = eventLinkIDs.iterator();
					it.hasNext();) {
			LinkEventEvent anEventLink = (LinkEventEvent)it.next();
			EventLink aLink = new EventLink();
			aLink.setId(anEventLink.getEventLink().getId());
			GenericDate eventDate = new GenericDate();
			eventDate.setTheDate(anEventLink.getEventLink().getEventDate());
			aLink.setEventDate(eventDate.toString());
			aLink.setTitle(anEventLink.getEventLink().getTitle().toString());
			aLink.setDescription(anEventLink.getEventLink().getDescription().toString());
			eventLinks.add(aLink);
		}    	
		session.getTransaction().commit();
	    session.close(); 
	    return eventLinks;
	}
	
}
