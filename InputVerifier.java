/** InputVerifier.java has various helper methods that can be used to verify that
 	input meets application constraints and manipulate data for proper display */
import java.util.Calendar;

public class InputVerifier implements InputConstants {
	public InputVerifier(){}//default constructor
	
	/** Checks size of input against size given
	 	Returns true if s is <= to max size; otherwise, returns false */
	public boolean inputSizeAllowed(String s, final int maxSize)
	{ 
		return (s.length() <= maxSize);	
	}
	
	/** Returns a GenericDate.toString() in default format ##/##/####
	 	from a Calendar object */
	public String CalendarDateToStringDate(Calendar birthDate)
	{
		GenericDate dob = new GenericDate();
		dob.setTheDate(birthDate);
		return dob.toString();
	}
	
	public boolean dateIsNull(int month, int date, int year)
	{
		if((month==0) && (date == 0) &&	(year == 0))
			return true;//date is Null
		else return false;//date is Not Null
		
	}
	
	public boolean validDate(int month, int date, int year)
	{
		if((month < 0) || (month > 12))
			return false;
		else if ((date < 0) || (date > 31))
			return false;
		else if ((year < 0))
			return false;
		else return true;
	}
}
