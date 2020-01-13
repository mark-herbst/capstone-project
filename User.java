// User.java is an application user.
import java.io.Serializable;
public class User implements Serializable {
	private Long id;
	private String username, password, userType;
	private static final String ADMINISTRATOR = "Administrator";
	private static final String USER = "User";
	public User(){}

	/** Returns true if this Object equals other; false otherwise
	Indicates whether some other object is "equal to" this one */
	public boolean equals(Object other)
	{
		if(this == other) return true;
		if(!(other instanceof User)) return false;
		final User that = (User)other;
		return username.equals(that.getUsername());
	}
	
	/** Returns an int hash code value for the object */
	public int hashCode()
	{
		return username.hashCode();
	}
	
	/** Returns a String representation of the object
	 	password is omitted for security*/	
	public String toString()
	{
		return getUsername() + " " + getUserType();		
	}

	public static String getADMINISTRATOR() {
		return ADMINISTRATOR;
	}

	public static String getUSER() {
		return USER;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
