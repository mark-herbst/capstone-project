//NameAliasJPanel.java is a panel used for obtaining input of a person's alias
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
public class NameAliasJPanel extends JPanel {
	private JLabel lblAlias;	
	private JPanel mainPanel;
	protected JTextField aliasName;
	
	public NameAliasJPanel(){}//default constructor	
	public NameAliasJPanel(String alias)
	{
		setLayout(new BorderLayout());
		lblAlias = new JLabel(alias);
		aliasName = new JTextField(15);
		
		mainPanel = new JPanel();
		mainPanel.add(lblAlias);
		mainPanel.add(aliasName);
		
		add(mainPanel, BorderLayout.WEST);
	}
	
	/** Clears all text fields contained in this Object */
	public void clearTextFields(){
		aliasName.setText("");
	}
	
	public JTextField getAliasName() {
		return aliasName;
	}
	public void setAliasName(JTextField aliasName) {
		this.aliasName = aliasName;
	}
	public JLabel getLblAlias() {
		return lblAlias;
	}
	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}
	public JPanel getMainPanel() {
		return mainPanel;
	}
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
}
