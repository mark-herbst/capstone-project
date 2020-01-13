/** OrganizationLink.java is a string representation of an Organization link
 	and stores the Organization's id for later retrieval from database */
public class OrganizationLink {
	private Long id;
	private String organizationName;
	
	public OrganizationLink(){}//default constructor
	
	/** Returns true if this Object equals other; false otherwise
		Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof OrganizationLink)) return false;
		final OrganizationLink that = (OrganizationLink)other;
		if (getId().equals(that.getId()) &&
			organizationName.equals(that.getOrganizationName()))					
			return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return id.hashCode() + organizationName.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{
		return organizationName + "\n";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
	
}
