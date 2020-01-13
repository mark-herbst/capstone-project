/** PersonLink.java is a string representation of a Person link and stores the
 	Person's id for later retrieval from database */
public class PersonLink {
	private Long id;
	private String name, gender, race, dob;
	
	public PersonLink(){}//default constructor
	
	/** Returns true if this Object equals other; false otherwise
	 	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof PersonLink)) return false;
		final PersonLink that = (PersonLink)other;
		if (getId().equals(that.getId()) &&
			name.equals(that.getName()) &&
			gender.equals(that.getGender()) &&
			race.equals(that.getRace()) &&
			dob.equals(that.getDob()))		
			return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return id.hashCode() + name.hashCode() + gender.hashCode() + race.hashCode() +
				dob.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{
		return name + "\n" + gender + " " +  race + " " + dob + "\n\n";
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}	
}
