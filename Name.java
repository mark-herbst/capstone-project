//Name.java represents a person's name
import java.io.Serializable;
public class Name implements Serializable {
	private String first, middle, mothersMaiden, fathers, grandfathers, familys, alias;	
	public Name(){}
	
	/** Returns true if this Object equals other; false otherwise
 		Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof Name)) return false;
		final Name that = (Name)other;
		if (first.equals(that.getFirst()) &&
			middle.equals(that.getMiddle()) &&
			mothersMaiden.equals(that.getMothersMaiden()) &&
			fathers.equals(that.getFathers()) &&
			grandfathers.equals(that.getGrandfathers()) &&
			familys.equals(that.getFamilys()) &&
			alias.equals(that.getAlias()))
			return true;		
		else return false;
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return first.hashCode() + middle.hashCode() + mothersMaiden.hashCode() +
				fathers.hashCode() + grandfathers.hashCode() + familys.hashCode() +
				alias.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{				
		String noNullName = "";
		if(first != null)
			noNullName += first + " ";
		if(middle != null)
			noNullName += middle + " ";
		if(fathers != null)
			noNullName += fathers + " ";
		if(grandfathers != null)
			noNullName += grandfathers + " ";
		if(mothersMaiden != null)
			noNullName += mothersMaiden + " ";
		if(familys != null)
			noNullName += familys;//No space needed after familys name, it is always last
		if(alias != null)
			noNullName += alias;//No space needed after an alias, it is always first AND last
		return noNullName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getFamilys() {
		return familys;
	}

	public void setFamilys(String familys) {
		this.familys = familys;
	}

	public String getFathers() {
		return fathers;
	}

	public void setFathers(String fathers) {
		this.fathers = fathers;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getGrandfathers() {
		return grandfathers;
	}

	public void setGrandfathers(String grandfathers) {
		this.grandfathers = grandfathers;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getMothersMaiden() {
		return mothersMaiden;
	}

	public void setMothersMaiden(String mothersMaiden) {
		this.mothersMaiden = mothersMaiden;
	}
}
