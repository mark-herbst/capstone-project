//PhoneCall.java represents a phone call
import java.io.Serializable;
public class PhoneCall implements Serializable {
	private Long id;
	private static final String INCOMING = "Incoming";
	private static final String OUTGOING = "Outgoing";
	private String callType;//INCOMING or OUTGOING
	private PhoneCallDateTime callDateTime;
	private int duration;//seconds or minutes
	
	/** Returns true if this Object equals other; false otherwise
	 	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof PhoneCall)) return false;
		final PhoneCall that = (PhoneCall)other;
		if (callType.equals(that.getCallType()) &&
			callDateTime.equals(that.getCallDateTime()) &&
			duration == that.getDuration())
			return true;
		else return false;
	}
		
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return callType.hashCode() + callDateTime.hashCode() + duration;
	}
		
	/** Returns a String representation of the object */
	public String toString()
	{
		//ex. Outgoing 09/10/2007 76
		return getCallType() + " " +  getCallDateTime() + " " + getDuration();
	}
	
	public static String getINCOMING() {
		return INCOMING;
	}
	public static String getOUTGOING() {
		return OUTGOING;
	}
	public PhoneCallDateTime getCallDateTime() {
		return callDateTime;
	}
	public void setCallDateTime(PhoneCallDateTime callDateTime) {
		this.callDateTime = callDateTime;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
