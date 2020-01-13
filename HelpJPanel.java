/** HelpJPanel.java is a panel that holds an .html based help file */
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.net.URL;
public class HelpJPanel extends JPanel implements FilePaths {
	private JEditorPane helpContentPane;
	private JScrollPane helpContentScrollPane;
	private URL helpFileURL;
	public HelpJPanel()
	{
		setLayout(new BorderLayout());
		helpContentPane = createEditorPane();
		helpContentScrollPane = new JScrollPane(helpContentPane);
		helpContentScrollPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		helpContentScrollPane.setPreferredSize(new Dimension(700,700));
		helpContentScrollPane.setMinimumSize(new Dimension(500,500));		
		add(helpContentScrollPane, BorderLayout.CENTER);		
	}
	
	private JEditorPane createEditorPane()
	{
		helpContentPane = new JEditorPane();
		helpContentPane.setEditable(false);
		helpFileURL = HelpJPanel.class.getResource(HELP);
		if(helpFileURL!= null)
		{
			try {
				helpContentPane.setPage(helpFileURL);
			}
			catch (IOException e){
				System.err.println("Attempted to read a bad URL:  " + helpFileURL);
			}
		}
		else {
			System.err.println("Could not find file:  help.html");
		}
		return helpContentPane;
	}

	public static String getHELP() {
		return HELP;
	}

	public JEditorPane getHelpContentPane() {
		return helpContentPane;
	}

	public void setHelpContentPane(JEditorPane helpContentPane) {
		this.helpContentPane = helpContentPane;
	}

	public JScrollPane getHelpContentScrollPane() {
		return helpContentScrollPane;
	}

	public void setHelpContentScrollPane(JScrollPane helpContentScrollPane) {
		this.helpContentScrollPane = helpContentScrollPane;
	}

	public URL getHelpFileURL() {
		return helpFileURL;
	}

	public void setHelpFileURL(URL helpFileURL) {
		this.helpFileURL = helpFileURL;
	}
	
	
}
