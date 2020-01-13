import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.util.ResourceBundle;
public class EntityRadioButtonJPanel extends JPanel {
	private ResourceBundle appBundle;
	private JPanel rbPanel;
	private ButtonGroup btnGroup;
	private JRadioButton rbPerson, rbOrganization, rbAddress, rbEvent, rbPhone,
							rbPhoneCalls;
	private String txtPerson, txtOrganization, txtAddress, txtEvent, txtPhone, txtPhoneCalls;
	public EntityRadioButtonJPanel(ResourceBundle appBundle)
	{
		this.appBundle = appBundle;
		createStrings();
		btnGroup = new ButtonGroup();		
		rbPerson = new JRadioButton(txtPerson);		
		rbPerson.setSelected(true);		
		rbOrganization = new JRadioButton(txtOrganization);		
		rbAddress = new JRadioButton(txtAddress);		
		rbEvent = new JRadioButton(txtEvent);		
		rbPhone = new JRadioButton(txtPhone);		
		rbPhoneCalls = new JRadioButton(txtPhoneCalls);		
		createMnemonics();
		createToolTips();
		btnGroup.add(rbPerson);
		btnGroup.add(rbOrganization);
		btnGroup.add(rbAddress);
		btnGroup.add(rbEvent);
		btnGroup.add(rbPhone);	
		btnGroup.add(rbPhoneCalls);				     
        rbPanel = new JPanel(new GridLayout(6,1));//rows,columns
		rbPanel.add(rbPerson);
		rbPanel.add(rbOrganization);
		rbPanel.add(rbAddress);
		rbPanel.add(rbEvent);
		rbPanel.add(rbPhone);
		rbPanel.add(rbPhoneCalls);
		add(rbPanel);	
	}
	
	public void createStrings()
	{
		txtPerson = appBundle.getString("link_analysis.person.text");
		txtOrganization = appBundle.getString("link_analysis.organization.text");
		txtAddress = appBundle.getString("link_analysis.address.text");
		txtEvent = appBundle.getString("link_analysis.event.text");
		txtPhone = appBundle.getString("link_analysis.phone.text");
		txtPhoneCalls = appBundle.getString("link_analysis.phone_calls.text");
	}
	
	public void createMnemonics()    
    {    	
    	/*If the character defined by the mnemonic is found within the button's
    	 *label string, the first occurrence of it will be underlined to indicate
    	 *the mnemonic to the user. (Alt-key + letter)
    	 */
		
		rbPerson.setMnemonic(KeyEvent.VK_P);	
    	rbOrganization.setMnemonic(KeyEvent.VK_O);
    	rbAddress.setMnemonic(KeyEvent.VK_A);
    	rbEvent.setMnemonic(KeyEvent.VK_E);
    	rbPhone.setMnemonic(KeyEvent.VK_H);
    	rbPhoneCalls.setMnemonic(KeyEvent.VK_C);				
    }
    
    public void createToolTips()
    {
    	/*The text displays when the cursor lingers over the component.
    	 *If the text is null, the tool tip is turned off for this component
    	 */ 
    	
    	rbPerson.setToolTipText(appBundle.getString("link_analysis.person.tooltip"));
    	rbOrganization.setToolTipText(appBundle.getString(
				"link_analysis.organization.tooltip"));
    	rbAddress.setToolTipText(appBundle.getString("link_analysis.address.tooltip"));
    	rbEvent.setToolTipText(appBundle.getString("link_analysis.event.tooltip"));
    	rbPhone.setToolTipText(appBundle.getString("link_analysis.phone.tooltip"));
    	rbPhoneCalls.setToolTipText(appBundle.getString(
				"link_analysis.phone_calls.tooltip"));
				
    }
    
	public ButtonGroup getBtnGroup() {
		return btnGroup;
	}

	public void setBtnGroup(ButtonGroup btnGroup) {
		this.btnGroup = btnGroup;
	}

	public JRadioButton getRbAddress() {
		return rbAddress;
	}

	public void setRbAddress(JRadioButton rbAddress) {
		this.rbAddress = rbAddress;
	}

	public JRadioButton getRbEvent() {
		return rbEvent;
	}

	public void setRbEvent(JRadioButton rbEvent) {
		this.rbEvent = rbEvent;
	}

	public JRadioButton getRbOrganization() {
		return rbOrganization;
	}

	public void setRbOrganization(JRadioButton rbOrganization) {
		this.rbOrganization = rbOrganization;
	}

	public JPanel getRbPanel() {
		return rbPanel;
	}

	public void setRbPanel(JPanel rbPanel) {
		this.rbPanel = rbPanel;
	}

	public JRadioButton getRbPerson() {
		return rbPerson;
	}

	public void setRbPerson(JRadioButton rbPerson) {
		this.rbPerson = rbPerson;
	}

	public JRadioButton getRbPhone() {
		return rbPhone;
	}

	public void setRbPhone(JRadioButton rbPhone) {
		this.rbPhone = rbPhone;
	}

	public JRadioButton getRbPhoneCalls() {
		return rbPhoneCalls;
	}

	public void setRbPhoneCalls(JRadioButton rbPhoneCalls) {
		this.rbPhoneCalls = rbPhoneCalls;
	}
	
	
}
