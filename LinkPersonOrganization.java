/** LinkPersonOrganization.java creates a link between a Person and an Organization */
import java.io.Serializable;
public class LinkPersonOrganization implements Serializable {
	private Long id;
	private Person person;
	private Organization organization;
	
	public LinkPersonOrganization(){}//default constructor

	/** Returns true if this Object equals other; false otherwise
	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof LinkPersonOrganization)) return false;
		final LinkPersonOrganization that = (LinkPersonOrganization)other;
		if (person.equals(that.getPerson()) &&
				organization.equals(that.getOrganization()))
					return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return person.hashCode() + organization.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{		
		return person.toString() + " " + organization.toString();			
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
