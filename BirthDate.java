//BirthDate.java represents a person's date of birth
import java.util.Calendar;
public class BirthDate {
	//Calendar.getInstance() returned is based on the current time
	//in the default time zone with the default locale.
	private Calendar currentDate = Calendar.getInstance();
	private int month = currentDate.get(Calendar.MONTH);
	private int date = currentDate.get(Calendar.DATE);//date is a synonym for DAY_OF_MONTH
	private int year = currentDate.get(Calendar.YEAR);
	
	public BirthDate(){}//default constructor
	
	//Returns true if this Object equals other; false otherwise
	//Indicates whether some other object is "equal to" this one
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof BirthDate)) return false;
		final BirthDate that = (BirthDate)other;
		//equals name, gender, race, dob
		if (month == that.getMonth() &&
			date == that.getDate() &&
			year == that.getYear())
			return true;
		else return false;			
	}
	
	//Returns an int hash code value for the object
	public int hashCode()
	{
		return currentDate.hashCode();
	}
	
	//Returns a String representation of the object "MM/dd/yyyy"
	public String toString()
	{
		return getMonth() + "/" + getDate() + "/" + getYear();
	}
	
	public Calendar getCurrentDate()
	{
		return currentDate;
	}
	public void setCurrentDate(Calendar birthDate)
	{
		this.currentDate = birthDate;
	}
	public int getMonth()
	{
		return month + 1;//January=0, February=1, etc...
	}
	public void setMonth(int month)
	{
		this.month = month - 1;//January=0, February=1, etc...
	}
	public int getDate()
	{
		return date;//The first day of the month has value 1
	}
	public void setDate(int date)
	{
		this.date = date;//The first day of the month has value 1
	}
	public int getYear()
	{
		return year;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
}
