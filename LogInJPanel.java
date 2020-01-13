/** LogInJPanel.java is a panel that contains components used in an application's
 	login screen. */
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.*;
public class LogInJPanel extends JPanel {
	private JLabel lblIcon,lblUserName,lblPassword;
	private JTextField jtfUserName;
	private JPasswordField passwordField;
	private JButton btnLogIn, btnHelp;	
	private JPanel lblPanel, txtPanel, buttonPanel,	componentPanel, mainPanel;
	
	public LogInJPanel(){}//Default constructor
	
	public LogInJPanel(ImageIcon splashIcon, String txtUserName,
						String txtPassword,	String txtLogin,
						Action helpAction, String txtHelp)
	{					
		this.setBackground(Color.BLACK);
		
		lblIcon = new JLabel(splashIcon);
		lblUserName = new JLabel((txtUserName));
		lblUserName.setForeground(Color.WHITE);
		jtfUserName = new JTextField(10);
		lblPassword = new JLabel((txtPassword));
		lblPassword.setForeground(Color.WHITE);
		passwordField = new JPasswordField(10);		
		
		btnLogIn = new JButton((txtLogin));//;		
		btnHelp = new JButton(helpAction);
		btnHelp.setIcon(null);//Disable icon in helpAction
		btnHelp.setText(txtHelp);//Modify text displayed from text in helpAction	
		
		lblPanel = new JPanel(new GridLayout(2,1,13,13));//rows,columns
		lblPanel.setBackground(Color.BLACK);
		txtPanel = new JPanel(new GridLayout(2,1,10,10));
		txtPanel.setBackground(Color.BLACK);
		buttonPanel = new JPanel(new FlowLayout());
		componentPanel = new JPanel(new FlowLayout());
		mainPanel = new JPanel(new GridLayout(4,1));
		
		lblPanel.add(lblUserName);
		lblPanel.add(lblPassword);		
		txtPanel.add(jtfUserName);
		txtPanel.add(passwordField);	
		componentPanel.setBackground(Color.BLACK);
		componentPanel.add(lblPanel);
		componentPanel.add(txtPanel);	
		buttonPanel.setBackground(Color.BLACK);
		buttonPanel.add(btnLogIn);
		buttonPanel.add(btnHelp);		
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(lblIcon, BorderLayout.PAGE_START);
		mainPanel.add(componentPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.PAGE_END);		
	
		add(mainPanel, BorderLayout.CENTER);	
		
		jtfUserName.requestFocus();
	}
	
	/** Clears all text fields contained in this Object */
	public void clearTextFields(){
		jtfUserName.setText("");
		passwordField.setText("");
		jtfUserName.requestFocus();
	}
	
	public JButton getBtnHelp() {
		return btnHelp;
	}

	public void setBtnHelp(JButton btnHelp) {
		this.btnHelp = btnHelp;
	}

	public JButton getBtnLogIn() {
		return btnLogIn;
	}

	public void setBtnLogIn(JButton btnLogIn) {
		this.btnLogIn = btnLogIn;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public JPanel getComponentPanel() {
		return componentPanel;
	}

	public void setComponentPanel(JPanel componentPanel) {
		this.componentPanel = componentPanel;
	}

	public JLabel getlblIcon() {
		return lblIcon;
	}

	public void setlblIcon(JLabel lblIcon) {
		this.lblIcon = lblIcon;
	}

	public JPanel getLblPanel() {
		return lblPanel;
	}

	public void setLblPanel(JPanel lblPanel) {
		this.lblPanel = lblPanel;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	public JLabel getLblUserName() {
		return lblUserName;
	}

	public void setLblUserName(JLabel lblUserName) {
		this.lblUserName = lblUserName;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JPanel getTxtPanel() {
		return txtPanel;
	}

	public void setTxtPanel(JPanel txtPanel) {
		this.txtPanel = txtPanel;
	}

	public JTextField getjtfUserName() {
		return jtfUserName;
	}

	public void setjtfUserName(JTextField jtfUserName) {
		this.jtfUserName = jtfUserName;
	}

	public JTextField getJtfUserName() {
		return jtfUserName;
	}

	public void setJtfUserName(JTextField jtfUserName) {
		this.jtfUserName = jtfUserName;
	}

	public JLabel getLblIcon() {
		return lblIcon;
	}

	public void setLblIcon(JLabel lblIcon) {
		this.lblIcon = lblIcon;
	}
}

