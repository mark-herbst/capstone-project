/** EventLink.java is a string representation of an Event link and stores the
 	Event's id for later retrieval from database */
public class EventLink {
	private Long id;
	private String eventDate, title, description;
	
	public EventLink(){}//default constructor
	
	/** Returns true if this Object equals other; false otherwise
 	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof EventLink)) return false;
		final EventLink that = (EventLink)other;
		if (id.equals(that.getId()) &&
			eventDate.equals(that.getEventDate()) &&
			title.equals(that.getTitle()) &&
			description.equals(that.getDescription()))		
			return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return id.hashCode() + eventDate.hashCode() + title.hashCode() + 
				description.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{
		return eventDate + "\n" + title + "\n " +  description + "\n\n";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
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
