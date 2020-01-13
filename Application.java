//Application.java interface is implemented by an Application Manager
public interface Application extends FilePaths {
	/** Load resources needed for application */
	void load();	
	/** Start the application */
	void run();
	/** Close the application */
	void close();
}
