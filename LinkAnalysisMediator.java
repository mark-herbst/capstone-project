import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class LinkAnalysisMediator implements ActionListener, InputConstants {
	private JupiterFrame LAFrame;
	private LinkAnalysisJPanel LAPanel;
	private JButton btnSearch;
	public LinkAnalysisMediator(JupiterFrame frame)
	{
		this.LAFrame = frame;
		this.LAPanel = (LinkAnalysisJPanel)LAFrame.getPanel();
		this.btnSearch = LAPanel.getBtnPanel().getBtnSearch();
		LAPanel.getBtnPanel().getBtnAdd().setEnabled(false);
		LAPanel.getBtnPanel().getBtnDelete().setEnabled(false);
		LAPanel.getBtnPanel().getBtnEdit().setEnabled(false);
		btnSearch.addActionListener(this);		
		//LAPanel.getCards().addFocusListener();
	}
	
	public void actionPerformed(ActionEvent e)
	{	  
		if (e.getSource() == btnSearch)
		{			
			//LAPanel.getCards().addFocusListener();
			
		}			
	}
}
