//Phone.java represents a phone number
import java.io.Serializable;
public class Phone implements Serializable {
	private Long id;
	private String areaCode, exchange, subscriber, country;
		
	public Phone(){}//default constructor
		
	/** Returns true if this Object equals other; false otherwise
	 	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof Phone)) return false;
		final Phone that = (Phone)other;		
		//equals areaCode, exchange, subscriber and country
		if (areaCode.equals(that.getAreaCode()) &&
			exchange.equals(that.getExchange()) &&
			subscriber.equals(that.getSubscriber()) &&
			country.equals(that.getCountry()))
			return true;
		else return false;
	}
		
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		//equals areaCode, exchange, subscriber and country
		return areaCode.hashCode() + exchange.hashCode() + subscriber.hashCode() +
				country.hashCode();
	}
		
	/** Returns a String representation of the object in United States phone
	 	number format:  (areaCode) exchange-subscriber (XXX) XXX-XXXX */
	public String toString()
	{
		return "(" + getAreaCode() + ") " +  getExchange() + "-" +
				getSubscriber() + " " + getCountry();
	}

	public String getAreaCode() {
			return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}


