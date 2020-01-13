//AppManager.java is the Application Manager for Jupiter
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Locale;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppManager implements Application  {	
	private ResourceFactory appFactory = new ResourceFactory();
	private Locale locale = Locale.getDefault();//current locale: en_US
	private User user;
	private LoginMediator mediator;
	
	public AppManager(){}//Default constructor
	
	public void load()
	{		
		try {
			ResourceBundle appBundle = ResourceBundle.getBundle(JUPITER_STRINGS,
											  					locale);
			ResourceBundle countriesBundle = ResourceBundle.getBundle(COUNTRY_STRINGS,
											  						locale);
			ResourceBundle USStatesBundle = ResourceBundle.getBundle(US_STATE_STRINGS,
																	locale);			
			appFactory.createResources(appBundle, countriesBundle, USStatesBundle);
			run();	
		}//end try
		catch (MissingResourceException ex)
		{
			/** Shown when one of the resource bundles are not found */
			JOptionPane.showMessageDialog(null, "A .properties file was not found!\n" +
					"Program will close", "Missing Resource Exception",
					JOptionPane.ERROR_MESSAGE);
			close();
		}	
		catch (NullPointerException ex)
		{
			/** Shown when a properties file path is null or a null pointer
			 	exception is thrown while accessing one of the keys in a
			 	resource bundle */
			JOptionPane.showMessageDialog(null, "A .properties file name was null!\n" +
					"Program will close", "Null Pointer Exception",
					JOptionPane.ERROR_MESSAGE);
			close();
		}
	}
	
	public void run()
	{			
		try {			
			JupiterFrame loginFrame = appFactory.createLoginWindow();			
			loginFrame.addWindowListener(new WindowAdapter(){
				public void windowClosed(WindowEvent e)
				{
					//get logged in user
					setUser(mediator.getA().getUser());	
					//Open Jupiter main frame when loginFrame closed					
					appFactory.createMainWindow();//Create the main window
					//Set application resource availability based on user level/type
					appFactory.setUserAccess(user.getUserType());
					//Make main window visible
					appFactory.getMainFrame().setVisible(true);
				}//end windowClosed
			});//end addWindowListener
			
			loginFrame.setVisible(true);
			//get strings for login mediator
			String invalidLoginMessage = appFactory.getAppBundle()
										.getString("exception.invalid_login_message.text");
			
			String loginErrorTitle = appFactory.getAppBundle()
										.getString("exception.invalid_login_title.text");
			
			mediator = new LoginMediator(loginFrame, invalidLoginMessage,
											loginErrorTitle);			
		}//end try
		catch (MissingResourceException ex)
		{
			JOptionPane.showMessageDialog(null, ((appFactory.getAppBundle()
			.getString("exception.missing_resource_message.text") + "\n" +
			ex.getMessage().getClass().getName())),
			appFactory.getAppBundle().getString("exception.missing_resource_title.text"), 
			JOptionPane.ERROR_MESSAGE);
			close();
		}	
		catch (NullPointerException ex)
		{
			JOptionPane.showMessageDialog(null, ((appFactory.getAppBundle()
			.getString("exception.null_pointer.message") + "\n" +
			ex.getMessage().getClass().getName())),
			appFactory.getAppBundle().getString("exception.null_pointer.title"),
			JOptionPane.ERROR_MESSAGE);
			close();
		}		
		catch (ClassCastException ex)
		{
			/** Shown if the object found for the given key is not a string
			 	exception is thrown while accessing one of the keys in a
			 	resource bundle */
			JOptionPane.showMessageDialog(null, ((appFactory.getAppBundle()
			.getString("exception.class_cast.message") + "\n" +
			ex.getMessage())), appFactory.getAppBundle().getString(
			"exception.class_cast.title"), JOptionPane.ERROR_MESSAGE);
			close();
		}	
	}
	
	public void close()
	{
		System.exit(0);
	}
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public ResourceFactory getAppFactory() {
		return appFactory;
	}

	public void setAppFactory(ResourceFactory appFactory) {
		this.appFactory = appFactory;
	}

	public LoginMediator getMediator() {
		return mediator;
	}

	public void setMediator(LoginMediator mediator) {
		this.mediator = mediator;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
