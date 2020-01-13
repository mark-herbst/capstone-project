/** LinkOrganizationOrganization.java creates a link between two Organizations */
import java.io.Serializable;
public class LinkOrganizationOrganization implements Serializable {
	private Long id;
	private Organization parentOrganization, organizationLink;
	
	public LinkOrganizationOrganization(){}//default constructor

	/** Returns true if this Object equals other; false otherwise
	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof LinkOrganizationOrganization)) return false;
		final LinkOrganizationOrganization that = (LinkOrganizationOrganization)other;
		if (parentOrganization.equals(that.getParentOrganization()) &&
				organizationLink.equals(that.getOrganizationLink()))
					return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return parentOrganization.hashCode() + organizationLink.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{		
		return parentOrganization.toString() + " " + organizationLink.toString();			
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Organization getOrganizationLink() {
		return organizationLink;
	}

	public void setOrganizationLink(Organization organizationLink) {
		this.organizationLink = organizationLink;
	}

	public Organization getParentOrganization() {
		return parentOrganization;
	}

	public void setParentOrganization(Organization parentOrganization) {
		this.parentOrganization = parentOrganization;
	}
}
