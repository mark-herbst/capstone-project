/** LinkPersonEvent.java creates a link between a Person and an Event */
import java.io.Serializable;
public class LinkPersonEvent implements Serializable {
	private Long id;
	private Person person;
	private Event event;
	
	public LinkPersonEvent(){}//default constructor
	
	/** Returns true if this Object equals other; false otherwise
	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof LinkPersonEvent)) return false;
		final LinkPersonEvent that = (LinkPersonEvent)other;
		if (person.equals(that.getPerson()) &&
				event.equals(that.getEvent()))
					return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return person.hashCode() + event.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{		
		return person.toString() + " " + event.toString();			
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
