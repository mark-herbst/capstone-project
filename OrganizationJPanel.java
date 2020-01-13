/** OrganizationJPanel.java is a panel used to create an Organization object */
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
public class OrganizationJPanel extends JPanel {
	private String title, txtName;
	private JPanel mainPanel;
	private JLabel lblName;
	private JTextField organization;
	private FunctionButtonJPanel buttonPanel;
	
	public OrganizationJPanel(String title, String txtName, JPanel buttons)
	{
		this.title = title;
		this.txtName = txtName;
		this.buttonPanel = (FunctionButtonJPanel)buttons;
		setLayout(new BorderLayout());
		lblName = new JLabel(txtName);
		organization = new JTextField(30);
		
		mainPanel = new JPanel();
		mainPanel.add(lblName);
		mainPanel.add(organization);		
		
		add(mainPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);		
	}
	
	/** Clears all text fields contained in this Object */
	public void clearTextFields()
	{
		organization.setText("");
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JTextField getOrganization() {
		return organization;
	}

	public void setOrganization(JTextField organization) {
		this.organization = organization;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTxtName() {
		return txtName;
	}

	public void setTxtName(String txtName) {
		this.txtName = txtName;
	}

	public FunctionButtonJPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(FunctionButtonJPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}	
}
