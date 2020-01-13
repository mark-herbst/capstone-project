
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JPanel;

public class TitledBorderedJPanel extends JPanel {
	private static Border grayline = BorderFactory.createLineBorder(Color.GRAY);
	
	public TitledBorderedJPanel(){}// Default constructor
	public TitledBorderedJPanel(String title)
	{
		title = " " + title + " ";
		setBorder(BorderFactory.createTitledBorder(grayline, title));	
		
	}
}
