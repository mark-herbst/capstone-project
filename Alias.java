//Alias.java represents a person's alias
import java.io.Serializable;
public class Alias implements Serializable {
	private Long id;
	private Name alias;
	
	public Alias(){}//default constructor

	/** Returns true if this Object equals other; false otherwise
 	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof Alias)) return false;
		final Alias that = (Alias)other;
		return alias.equals(that.getAlias());
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return alias.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{
		return getAlias().toString();				
	}	
	public Name getAlias() {
		return alias;
	}

	public void setAlias(Name alias) {
		this.alias = alias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
