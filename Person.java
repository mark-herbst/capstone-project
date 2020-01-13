//Person.java represents a person
import java.io.Serializable;
import java.util.Calendar;
public class Person implements Serializable, PersonConstants {
	private Long id;
	private Name name;
	private String gender, race;
	private Calendar dob;
	
	public Person(){}//default constructor
	
	/** Returns true if this Object equals other; false otherwise
		Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof Person)) return false;
		final Person that = (Person)other;
		//equals name, gender, race, dob
		if (getName().equals(that.getName()) &&
			gender.equals(that.getGender()) &&
			race.equals(that.getRace()) &&
			dob.equals(that.getDob()))			
			return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return name.hashCode() + gender.hashCode() + race.hashCode() +	dob.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{		
		return getName().toString() + " " + getGender() + " " + getRace() +	" " + dob.toString();			
	}	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {		
			this.gender = gender;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}
	
}
