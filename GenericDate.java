/** GenericDate.java is a helper class that helps convert a Calendar date to a proper
 	string representation of a date */
import java.util.Calendar;
public class GenericDate {
	//Calendar.getInstance()returns: current date/time in the default time zone with the default locale.
	private Calendar theDate = Calendar.getInstance();
	private int month;
	private int date;
	private int year;
	
	public GenericDate(){}//default constructor
	
	/** Returns true if this Object equals other; false otherwise
		Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof GenericDate)) return false;
		final GenericDate that = (GenericDate)other;
		if (getMonth()==that.getMonth() &&
			getDate()==that.getDate() &&
			getYear()==that.getYear())
			return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return month + date + year;
	}
	
	/** Returns a default String representation of the object "MM/dd/yyyy" */
	public String toString()
	{
		return getMonth() + "/" + getDate() + "/" + getYear();
	}
	
	public int getMonth()
	{
		return month=month+1;//January=0, February=1, etc...
	}
	
	/** This method should be used when a month is received from user input */
	public void setMonth(int month)
	{
		this.month = month-1;//The value used to set the MONTH calendar field.
						     //Month value is 0-based. e.g., 0 for January.
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
	
	public Calendar getTheDate() {
		return theDate;
	}
	
	/** This method is used to set theDate from an already established Calendar object,
	 	such as from a database */
	public void setTheDate(Calendar theDate)
	{
		month = theDate.get(Calendar.MONTH);//set the month
		date = theDate.get(Calendar.DATE);//set the date
		year = theDate.get(Calendar.YEAR);//set the year		
		this.theDate = theDate;
	}
	/** This method is used to set theDate from user input */
	public void setTheDate(int year, int month, int date)
	{
		//Previous values of other calendar fields (the fields of theDate instance
		//created when this class is instantiated) are retained. 		
		theDate.clear();//If this is not desired, call clear() first.
		setYear(year);
		setMonth(month);//month-1
		setDate(date);
		theDate.set(this.year, this.month, this.date);		
		//System.out.println("From GenericDate after setTheDate() month,date,year " + month + date + year);
		//System.out.println("theDate (Calendar) From GenericDate after setTheDate() " + theDate.toString());
	}
}
