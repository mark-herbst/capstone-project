/** LoginMediator.java handles the events associated with components
 	in a login screen and uses an Authenticator to validate the login process */
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
public class LoginMediator implements ActionListener, InputConstants {
	private JupiterFrame loginFrame;
	private LogInJPanel loginPanel;
	private JButton btnLogin;
	private Authenticator a = new Authenticator();
	private String invalidLoginMessage, loginErrorTitle;
	
	public LoginMediator(JupiterFrame loginFrame, String invalidLoginMessage,
						 String loginErrorTitle)
	{
		this.loginFrame = loginFrame;
		this.loginPanel = ((LogInJPanel)loginFrame.getPanel());
		this.btnLogin = loginPanel.getBtnLogIn();
		this.invalidLoginMessage = invalidLoginMessage;
		this.loginErrorTitle = loginErrorTitle;
		btnLogin.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{	  
		if (e.getSource() == btnLogin)
		{			
			// Get the input from the text fields
			String username = loginPanel.getjtfUserName().getText().trim();
			char[] password = loginPanel.getPasswordField().getPassword();
			//checkSize(username, password);			
			if (a.authenticate(username, password))
			{
				a.zeroPassword(password);//Overwrites password for security
				loginFrame.dispose();//close login frame
			}	
			else
			{
				JOptionPane.showMessageDialog(null, invalidLoginMessage,
						loginErrorTitle, JOptionPane.ERROR_MESSAGE);
				a.zeroPassword(password);//Overwrites password for security
				loginPanel.clearTextFields();
				loginPanel.getJtfUserName().requestFocus();			
			}	
		}			
	}
	
	public Authenticator getA() {
		return a;
	}

	public void setA(Authenticator a) {
		this.a = a;
	}
}
