//Note.java represents a note that can be assigned to other object's
import java.io.Serializable;
public class Note implements Serializable {
	private Long id;
	private String note;	
	
	public Note(){}//default constructor

	/** Returns true if this Object equals other; false otherwise
 		Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof Note)) return false;
		final Note that = (Note)other;
		return note.equals(that.getNote());
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return note.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{
		return getNote();				
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}	
}
