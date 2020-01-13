import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class MainFrame extends JFrame {
	private static final Dimension LARGE  = new Dimension(1000,900);
	
	public MainFrame(){}//Default constructor
	public MainFrame(String title)
	{
			/** Code to show frame */	
			setTitle(title);// Set title of frame
			setSize(LARGE);// Set frame size
			//Close frame when user closes window
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			centerFrame();
			getContentPane();
			setVisible(true);// Show frame							
	}	
	
	public void centerFrame()
	{
		/** Code to center frame on screen */
	    // Get the dimension of the screen
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int screenWidth = screenSize.width;
	    int screenHeight = screenSize.height;
	    // Locate the upper-left corner (x, y) of the centered frame
	    int x = (screenWidth - this.getWidth()) / 2;
	    int y = (screenHeight - this.getHeight()) / 2;	    
	    setLocation(x, y);// Set the location of the frame
	}	
}
