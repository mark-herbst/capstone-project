//Address.java represents an address or location
import java.io.Serializable;
public class Address implements Serializable {
	private Long id;
	private String street, city, region, zipcode, country;
	
	public Address(){}//default constructor
	
	/** Returns true if this Object equals other; false otherwise
	 	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof Address)) return false;
		final Address that = (Address)other;
		//equals street, city, region, zipcode, country
		if (street.equals(that.getStreet()) &&
			city.equals(that.getCity()) &&
			region.equals(that.getRegion()) &&
			zipcode.equals(that.getZipcode()) &&
			country.equals(that.getCountry()))
			return true;
		else return false;			
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return street.hashCode() + city.hashCode() + region.hashCode() +
				zipcode.hashCode() + country.hashCode();
	}
	
	/** Returns a String representation of the object */
	public String toString()
	{
		return getStreet() + " " + getCity() + " " + getRegion() +  " " +
				getZipcode() + " " + getCountry();			
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
