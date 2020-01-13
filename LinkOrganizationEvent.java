/** LinkOrganizationEvent.java creates a link between an Organization and an Event */
import java.io.Serializable;
public class LinkOrganizationEvent implements Serializable {
	private Long id;
	private Organization organization;
	private Event event;
	
	public LinkOrganizationEvent(){}//default constructor
	
	/** Returns true if this Object equals other; false otherwise
	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof LinkOrganizationEvent)) return false;
		final LinkOrganizationEvent that = (LinkOrganizationEvent)other;
		if (organization.equals(that.getOrganization()) &&
				event.equals(that.getEvent()))
					return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return organization.hashCode() + event.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{		
		return organization.toString() + " " + event.toString();			
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
}
