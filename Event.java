//Event.java represents an event
import java.io.Serializable;
import java.util.Calendar;
public class Event implements Serializable {
	private Long id;
	private Calendar eventDate;
	private String title, description;
	
	public Event(){}//default constructor
	
	/** Returns true if this Object equals other; false otherwise
 		Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof Event)) return false;
		final Event that = (Event)other;
		if (eventDate.equals(that.getEventDate()) &&
			title.equals(that.getTitle()) &&
			description.equals(that.getDescription()))
			return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return eventDate.hashCode() + title.hashCode() + description.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{
		return eventDate.toString() + " " + getTitle() + " " + getDescription();				
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Calendar getEventDate() {
		return eventDate;
	}

	public void setEventDate(Calendar eventDate) {
		this.eventDate = eventDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
