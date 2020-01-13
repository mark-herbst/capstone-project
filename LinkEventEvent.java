/** LinkEventEvent.java creates a link between two Events */
import java.io.Serializable;
public class LinkEventEvent implements Serializable {
	private Long id;
	private Event parentEvent, eventLink;
	
	public LinkEventEvent(){}//default constructor
	
	/** Returns true if this Object equals other; false otherwise
	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof LinkEventEvent)) return false;
		final LinkEventEvent that = (LinkEventEvent)other;
		if (parentEvent.equals(that.getParentEvent()) &&
				eventLink.equals(that.getEventLink()))
			return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return parentEvent.hashCode() + eventLink.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{		
		return parentEvent.toString() + " " + eventLink.toString();			
	}

	public Event getEventLink() {
		return eventLink;
	}

	public void setEventLink(Event eventLink) {
		this.eventLink = eventLink;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Event getParentEvent() {
		return parentEvent;
	}

	public void setParentEvent(Event parentEvent) {
		this.parentEvent = parentEvent;
	}
	
	
}
