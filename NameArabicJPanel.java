//NameArabicJPanel.java is a panel used for obtaining input of an Arabic name
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
public class NameArabicJPanel extends JPanel {
	private JPanel mainPanel, firstPanel, fathersPanel, grandfathersPanel, familyPanel;
	private JLabel lblFirst, lblFathers, lblGrandfathers, lblFamilys;
	protected JTextField firstName, fathersName, grandfathersName, familysName;		
	
	public NameArabicJPanel(){}//default constructor
	
	public NameArabicJPanel(String first, String fathers, String grandfathers,
							String familys)
	{
		setLayout(new BorderLayout());		
		mainPanel = new JPanel(new GridLayout(4,2));//rows,columns,hgap,vgap
		firstPanel = new JPanel();
		fathersPanel = new JPanel();
		grandfathersPanel = new JPanel();
		familyPanel = new JPanel();		
		lblFirst = new JLabel(first);//"First:"
		firstName = new JTextField(15);
		lblFathers = new JLabel(fathers);//"Father's:"
		fathersName = new JTextField(15);
		lblGrandfathers = new JLabel(grandfathers);//"Grandfather's:"
		grandfathersName = new JTextField(15);
		lblFamilys = new JLabel(familys);//"Family's:"
		familysName = new JTextField(15);			
		firstPanel.setLayout(new BorderLayout(5,5));//(int horizontalGap, int verticalGap)
		firstPanel.add(lblFirst, BorderLayout.WEST);
		firstPanel.add(firstName, BorderLayout.CENTER);
		fathersPanel.setLayout(new BorderLayout(5,5));
		fathersPanel.add(lblFathers, BorderLayout.WEST); 
		fathersPanel.add(fathersName, BorderLayout.CENTER);
		grandfathersPanel.setLayout(new BorderLayout(5,5));
		grandfathersPanel.add(lblGrandfathers, BorderLayout.WEST);
		grandfathersPanel.add(grandfathersName, BorderLayout.CENTER);
		familyPanel.setLayout(new BorderLayout(5,5));
		familyPanel.add(lblFamilys, BorderLayout.WEST);
		familyPanel.add(familysName, BorderLayout.CENTER);
		
		//first, fathers, grandfathers, familys
		mainPanel.add(firstPanel);// First Name
		mainPanel.add(fathersPanel);// Fathers Name
		mainPanel.add(grandfathersPanel);// Grandfathers Name 
		mainPanel.add(familyPanel);//Familys Name				
		
		add(mainPanel, BorderLayout.LINE_START);	
	}
	
	/** Clears all text fields contained in this Object */
	public void clearTextFields(){
		firstName.setText("");
		fathersName.setText("");
		grandfathersName.setText("");
		familysName.setText("");
	}
	
	public JPanel getFamilyPanel() {
		return familyPanel;
	}

	public void setFamilyPanel(JPanel familyPanel) {
		this.familyPanel = familyPanel;
	}

	public JTextField getFamilysName() {
		return familysName;
	}

	public void setFamilysName(JTextField familysName) {
		this.familysName = familysName;
	}

	public JTextField getFathersName() {
		return fathersName;
	}

	public void setFathersName(JTextField fathersName) {
		this.fathersName = fathersName;
	}

	public JPanel getFathersPanel() {
		return fathersPanel;
	}

	public void setFathersPanel(JPanel fathersPanel) {
		this.fathersPanel = fathersPanel;
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

	public JTextField getGrandfathersName() {
		return grandfathersName;
	}

	public void setGrandfathersName(JTextField grandfathersName) {
		this.grandfathersName = grandfathersName;
	}

	public JPanel getGrandfathersPanel() {
		return grandfathersPanel;
	}

	public void setGrandfathersPanel(JPanel grandfathersPanel) {
		this.grandfathersPanel = grandfathersPanel;
	}

	public JLabel getLblFamilys() {
		return lblFamilys;
	}

	public void setLblFamilys(JLabel lblFamilys) {
		this.lblFamilys = lblFamilys;
	}

	public JLabel getLblFathers() {
		return lblFathers;
	}

	public void setLblFathers(JLabel lblFathers) {
		this.lblFathers = lblFathers;
	}

	public JLabel getLblFirst() {
		return lblFirst;
	}

	public void setLblFirst(JLabel lblFirst) {
		this.lblFirst = lblFirst;
	}

	public JLabel getLblGrandfathers() {
		return lblGrandfathers;
	}

	public void setLblGrandfathers(JLabel lblGrandfathers) {
		this.lblGrandfathers = lblGrandfathers;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
}