/** LinkPersonPerson.java creates a link between two Persons */
import java.io.Serializable;
public class LinkPersonPerson implements Serializable {
	private Long id;
	private Person parentPerson, personLink;
	
	public LinkPersonPerson(){}//default constructor

	/** Returns true if this Object equals other; false otherwise
	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof LinkPersonPerson)) return false;
		final LinkPersonPerson that = (LinkPersonPerson)other;
		if (parentPerson.equals(that.getParentPerson()) &&
			personLink.equals(that.getPersonLink()))
			return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return parentPerson.hashCode() + personLink.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{		
		return parentPerson.toString() + " " + personLink.toString();			
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getParentPerson() {
		return parentPerson;
	}

	public void setParentPerson(Person parentPerson) {
		this.parentPerson = parentPerson;
	}

	public Person getPersonLink() {
		return personLink;
	}

	public void setPersonLink(Person personLink) {
		this.personLink = personLink;
	}
	
	
}
