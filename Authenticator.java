/** Authenticator.java checks a username and password for equality based
 	on user input and user information stored in a database. A user manager
 	is used to access the database and retrieve stored user data. */
import java.util.Arrays;
public class Authenticator implements InputConstants {	
	private UserManager usermgr = new UserManager();
	private User user; 
	public Authenticator(){}
	
	/** Authenticates a user by input username and password */
	public boolean authenticate(String username, char[] inputPassword)
	{		
		if (!isValidUsername(username))
			return false;
		else return isValidPassword(inputPassword);			
	}
	
	/** Returns false if username is null or not equal to stored username
	 	Returns true if username input is equal to stored username
	 	Precondition:  username is unique and <= 30 in length */
	public boolean isValidUsername(String username)
	{		
		try {
			user = new User();
			setUser((User)usermgr.find(username));
			return (username.equals(user.getUsername()));			 
		}
		catch (NullPointerException ex)
		{
			//query result is null and is caught
			return false;
		}		
	}
	
	/** Returns false if password is null or not equal to stored password
	 	Returns true if password input is equal to stored password
	 	Precondition:  password is <= 10 in length */
	public boolean isValidPassword(char[] inputPassword)
	{
		//get stored User's password
		char[] storedPassword = user.getPassword().
								trim().toCharArray();
		if (inputPassword.length != storedPassword.length)
			return false;//if lengths of passwords are not equal			
			if (Arrays.equals(inputPassword, storedPassword)== true)
			{
				zeroPassword(storedPassword);
				return true;//password is valid if both are equal
			}			
		zeroPassword(storedPassword);
		return false;//password is invalid if both are not equal	
	}
	
	/** For stronger security, it is recommended that the
	 	password character array be cleared after use
	 	by setting each character to zero. */
	public void zeroPassword(char[] password)
	{
		for(int i = 0; i < password.length; i++)//zero password
	    	password[i] = 0;	
	}

	/** Checks size of input
 	Returns true if username and password are <= to max size
 	Otherwise, returns false */
	public boolean checkSize(String username, char[] password)
	{
		return (username.length() <= NAME_MAX_SIZE &&
				password.length <= PASSWORD_MAX_SIZE);		
	}
	
	/** Used for testing
	 * Verifies that a password has been "zeroed"
	 * Result:  Prints the password to the console
	 * @param password
	 */
	public void checkPassword(char[] password)
	{
		for(int i = 0; i < password.length; i++)//zero password	    	
		System.out.println(password[i]);
	}
	
	public UserManager getUsermgr() {
		return usermgr;
	}

	public void setUsermgr(UserManager usermgr) {
		this.usermgr = usermgr;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}