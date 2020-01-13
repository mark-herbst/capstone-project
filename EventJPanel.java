//EventJPanel.java is a panel that holds components used to create an Event object
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;

public class EventJPanel extends JPanel{
	private JLabel lblTitle,lblDescription;
	private DateJPanel datePanel;
	private JTextField title;
	private JTextArea description;
	private JPanel titlePanel, descriptionPanel, dateTitlePanel, mainPanel;
	private FunctionButtonJPanel buttonPanel;
	
	public EventJPanel(String txtTitle, String txtDescription, JPanel datePanel, JPanel buttons)
	{
		this.datePanel=(DateJPanel)datePanel;
		this.buttonPanel=(FunctionButtonJPanel)buttons;
		
		setLayout(new BorderLayout());
		
		lblTitle = new JLabel(txtTitle);
		title = new JTextField(20);
		
		lblDescription = new JLabel(txtDescription);
		description = new JTextArea(2,20);//rows,columns
		description.setBorder(BorderFactory.createEtchedBorder());
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setEditable(true);
		
		titlePanel = new JPanel();
		titlePanel.add(lblTitle);
		titlePanel.add(title);
		
		descriptionPanel= new JPanel();
		descriptionPanel.add(lblDescription);
		descriptionPanel.add(description);
		
		dateTitlePanel = new JPanel();
		dateTitlePanel.add(datePanel);
		dateTitlePanel.add(titlePanel);
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(dateTitlePanel, BorderLayout.NORTH);
		mainPanel.add(descriptionPanel, BorderLayout.CENTER);
		
		add(mainPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);		
		
	}

	/** Clears all text fields contained in this Object */
	public void clearTextFields(){
		datePanel.clearTextFields();
		title.setText("");
		description.setText("");
	}
	
	public FunctionButtonJPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(FunctionButtonJPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public DateJPanel getDatePanel() {
		return datePanel;
	}

	public void setDatePanel(DateJPanel datePanel) {
		this.datePanel = datePanel;
	}

	public JTextArea getDescription() {
		return description;
	}

	public void setDescription(JTextArea description) {
		this.description = description;
	}

	public JPanel getDescriptionPanel() {
		return descriptionPanel;
	}

	public void setDescriptionPanel(JPanel descriptionPanel) {
		this.descriptionPanel = descriptionPanel;
	}

	public JLabel getLblDescription() {
		return lblDescription;
	}

	public void setLblDescription(JLabel lblDescription) {
		this.lblDescription = lblDescription;
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JTextField getTitle() {
		return title;
	}

	public void setTitle(JTextField title) {
		this.title = title;
	}

	public JPanel getTitlePanel() {
		return titlePanel;
	}

	public void setTitlePanel(JPanel titlePanel) {
		this.titlePanel = titlePanel;
	}
	
	
	
	
	
}
