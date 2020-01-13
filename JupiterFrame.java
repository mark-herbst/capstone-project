//JupiterFrame.java is a JFrame used for all Jupiter Frames
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class JupiterFrame extends JFrame implements FilePaths {
		JPanel panel;
		public JupiterFrame()//Default constructor
		{
			//Set the frame's icon to an image loaded from a file.
			setIconImage(new ImageIcon(ICON_JUPITER).getImage());
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
			setLayout(new FlowLayout());			
			getContentPane();
			pack();
			center();
			setVisible(false);// Show frame
		}
		
		public JupiterFrame(String title, JPanel panel)
		{
			this.panel = panel;
			//Set the frame's icon to an image loaded from a file.
			setIconImage(new ImageIcon(ICON_JUPITER).getImage());
			/** Code to show frame */	
			setTitle(title);// Set title of frame			
			add(panel);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setLayout(new FlowLayout());			
			getContentPane();
			pack();
			center();
			setVisible(false);// Show frame		
		}
		
		/** centers frame on screen */
		public void center()
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

		public JPanel getPanel() {
			return panel;
		}

		public void setPanel(JPanel panel) {
			this.panel = panel;
		}
}

