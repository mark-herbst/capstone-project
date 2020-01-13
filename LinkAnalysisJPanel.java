//LinkAnalysisJPanel.java contains all panels for Link Analyses
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
public class LinkAnalysisJPanel extends JPanel implements ActionListener {
	private JPanel cards, mainPanel;
	private EntityRadioButtonJPanel rbPanel;
	private FunctionButtonJPanel btnPanel;
	public LinkAnalysisJPanel(){}//default constructor	
	public LinkAnalysisJPanel(JPanel rbPanel, JPanel cards, JPanel btnPanel)
	{		
		this.cards = cards;
		this.rbPanel = (EntityRadioButtonJPanel)rbPanel;
		this.btnPanel = (FunctionButtonJPanel)btnPanel;
		setLayout(new BorderLayout());
		mainPanel = new JPanel();
		mainPanel.add(rbPanel);	
		mainPanel.add(cards);
		add(mainPanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);				
		
		//Register listeners for the radio buttons
        this.rbPanel.getRbPerson().addActionListener(this);
        this.rbPanel.getRbOrganization().addActionListener(this);
        this.rbPanel.getRbAddress().addActionListener(this);
        this.rbPanel.getRbEvent().addActionListener(this);
        this.rbPanel.getRbPhone().addActionListener(this);
        this.rbPanel.getRbPhoneCalls().addActionListener(this);     
	}	
	
	/** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {
        String rb =  e.getActionCommand();
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, rb);
    }
	public JPanel getCards() {
		return cards;
	}

	public void setCards(JPanel cards) {
		this.cards = cards;
	}	
	
	public EntityRadioButtonJPanel getRbPanel() {
		return rbPanel;
	}
	public void setRbPanel(EntityRadioButtonJPanel rbPanel) {
		this.rbPanel = rbPanel;
	}
	public FunctionButtonJPanel getBtnPanel() {
		return btnPanel;
	}
	public void setBtnPanel(FunctionButtonJPanel btnPanel) {
		this.btnPanel = btnPanel;
	}
	public JPanel getMainPanel() {
		return mainPanel;
	}
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
}
