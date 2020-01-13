//Persistent.java is an interface implemented by persistent classes
//to insure that required methods are implemented
import java.io.Serializable;
public interface Persistent extends Serializable {
    //Returns true if this Object equals obj; false otherwise
	// Indicates whether some other object is "equal to" this one	
	boolean equals(Object obj);
	//Returns an int hash code value for the object;
	int hashCode();	
	String toString();//Returns a String representation of the object
}

