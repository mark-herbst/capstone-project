//PhoneCallDateTime.java represents the date and time of a phone call
import java.util.Calendar;
public class PhoneCallDateTime {
	//Calendar.getInstance() returned is based on the current time
	//in the default time zone with the default locale.
	private Calendar currentDate = Calendar.getInstance();
	private int month = currentDate.get(Calendar.MONTH);
	private int date = currentDate.get(Calendar.DATE);//date is a synonym for DAY_OF_MONTH
	private int year = currentDate.get(Calendar.YEAR);
	private int hourOfDay = currentDate.get(Calendar.HOUR_OF_DAY);
	private int minute = currentDate.get(Calendar.MINUTE);
	private int second = currentDate.get(Calendar.SECOND);
	
	public PhoneCallDateTime(){}//default constructor

	//Returns true if this Object equals other; false otherwise
	//Indicates whether some other object is "equal to" this one
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof PhoneCallDateTime)) return false;
		final PhoneCallDateTime that = (PhoneCallDateTime)other;
		if (month == that.getMonth() &&
			date == that.getDate() &&
			year == that.getYear() &&
			hourOfDay == that.getHourOfDay() &&
			minute == that.getMinute() &&
			second == that.getSecond())
			return true;
		else return false;			
	}
	
	//Returns an int hash code value for the object
	public int hashCode()
	{
		return currentDate.hashCode();
	}
	
	//Returns a String representation of the object:  MM/DD/YYYY HHMM
	public String toString()
	{
		return getMonth() + "/" + getDate() + "/" + getYear() + " " + getHourOfDay()
				+ getMinute();
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
	public int getHourOfDay() {
		return hourOfDay;
	}
	
	public void setHourOfDay(int hourOfDay) {
		this.hourOfDay = hourOfDay;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}	
}
