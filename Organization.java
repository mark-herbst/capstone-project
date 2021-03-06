//Organization.java represents an organization
import java.io.Serializable;
public class Organization implements Serializable {
	private Long id;
	private String organizationName;
	
	public Organization(){}//default constructor
	
	/** Returns true if this Object equals other; false otherwise
		Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof Organization)) return false;
		final Organization that = (Organization)other;
		return organizationName.equals(that.getOrganizationName());
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return organizationName.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{
		return getOrganizationName();				
	}
	
	public String getOrganizationName() {
		return organizationName;
	}
	
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
