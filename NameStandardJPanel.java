//NameStandardJPanel.java is a panel used for obtaining input of a person's name
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
public class NameStandardJPanel extends JPanel {
	private JPanel standardPanel, lastPanel, firstPanel, middlePanel;
	protected JTextField lastName, firstName, middleName;
	private JLabel lblLast, lblFirst, lblMiddle;	
	
	public NameStandardJPanel(){}//default constructor	
	public NameStandardJPanel(String first, String middle, String last)
	{
		setLayout(new BorderLayout());
		standardPanel = new JPanel(new GridLayout(3,2,0,3));//rows,columns,hgap,vgap
		firstPanel = new JPanel();
		middlePanel = new JPanel();
		lastPanel = new JPanel();			
		lblFirst = new JLabel(first);
		firstName = new JTextField(15);		
		lblMiddle = new JLabel(middle);
		middleName = new JTextField(15);	
		lblLast = new JLabel(last);		
		lastName = new JTextField(15);		
		firstPanel.setLayout(new BorderLayout(5,5));		
		firstPanel.add(lblFirst, BorderLayout.WEST); 
		firstPanel.add(firstName, BorderLayout.CENTER);
		middlePanel.setLayout(new BorderLayout(5,5));
		middlePanel.add(lblMiddle, BorderLayout.WEST);
		middlePanel.add(middleName, BorderLayout.CENTER);
		lastPanel.setLayout(new BorderLayout(5,5));//(int horizontalGap, int verticalGap)
		lastPanel.add(lblLast, BorderLayout.WEST);
		lastPanel.add(lastName, BorderLayout.CENTER);	
		standardPanel.add(firstPanel);
		standardPanel.add(middlePanel);
		standardPanel.add(lastPanel);		
		add(standardPanel, BorderLayout.LINE_START);
	}
	
	/** Clears all text fields contained in this Object */
	public void clearTextFields(){
		firstName.setText("");
		middleName.setText("");
		lastName.setText("");
	}
	public JTextField getFirstName() {
		return firstName;
	}
	public void setFirstName(JTextField firstName) {
		this.firstName = firstName;
	}
	public JPanel getFirstPanel() {
		return firstPanel;
	}
	public void setFirstPanel(JPanel firstPanel) {
		this.firstPanel = firstPanel;
	}
	public JTextField getLastName() {
		return lastName;
	}
	public void setLastName(JTextField lastName) {
		this.lastName = lastName;
	}
	public JPanel getLastPanel() {
		return lastPanel;
	}
	public void setLastPanel(JPanel lastPanel) {
		this.lastPanel = lastPanel;
	}
	public JLabel getLblFirst() {
		return lblFirst;
	}
	public void setLblFirst(JLabel lblFirst) {
		this.lblFirst = lblFirst;
	}
	public JLabel getLblLast() {
		return lblLast;
	}
	public void setLblLast(JLabel lblLast) {
		this.lblLast = lblLast;
	}
	public JLabel getLblMiddle() {
		return lblMiddle;
	}
	public void setLblMiddle(JLabel lblMiddle) {
		this.lblMiddle = lblMiddle;
	}
	public JTextField getMiddleName() {
		return middleName;
	}
	public void setMiddleName(JTextField middleName) {
		this.middleName = middleName;
	}
	public JPanel getMiddlePanel() {
		return middlePanel;
	}
	public void setMiddlePanel(JPanel middlePanel) {
		this.middlePanel = middlePanel;
	}
	public JPanel getStandardPanel() {
		return standardPanel;
	}
	public void setStandardPanel(JPanel standardPanel) {
		this.standardPanel = standardPanel;
	}
}
