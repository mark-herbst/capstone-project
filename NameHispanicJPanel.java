/** NameHispanicJPanel.java is a panel used for obtaining input of an
 	Hispanic person's name.  Typical format is first, fathers, mothersMaiden name */
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
public class NameHispanicJPanel extends JPanel {
	private JPanel hispanicPanel, firstPanel, fathersPanel, mothersMaidenPanel;
	private JLabel  lblFirst, lblFathers, lblMothersMaiden;	
	protected JTextField firstName, fathersName, mothersMaidenName;
	
	public NameHispanicJPanel(){}//default constructor	
	public NameHispanicJPanel(String first, String fathers, String mothersMaiden)
	{
		setLayout(new BorderLayout());
		hispanicPanel = new JPanel(new GridLayout(3,2,0,3));//rows,columns,hgap,vgap
		firstPanel = new JPanel();		
		fathersPanel = new JPanel();		
		mothersMaidenPanel = new JPanel();		
		lblFirst = new JLabel(first);
		firstName = new JTextField(15);		
		lblFathers = new JLabel(fathers);
		fathersName = new JTextField(15);		
		lblMothersMaiden = new JLabel(mothersMaiden);		
		mothersMaidenName = new JTextField(15);		
		firstPanel.setLayout(new BorderLayout(5,5));		
		firstPanel.add(lblFirst, BorderLayout.WEST); 
		firstPanel.add(firstName, BorderLayout.CENTER);
		fathersPanel.setLayout(new BorderLayout(5,5));
		fathersPanel.add(lblFathers, BorderLayout.WEST);
		fathersPanel.add(fathersName, BorderLayout.CENTER);
		mothersMaidenPanel.setLayout(new BorderLayout(5,5));//(int horizontalGap, int verticalGap)
		mothersMaidenPanel.add(lblMothersMaiden, BorderLayout.WEST);
		mothersMaidenPanel.add(mothersMaidenName, BorderLayout.CENTER);	
		hispanicPanel.add(firstPanel);
		hispanicPanel.add(fathersPanel);
		hispanicPanel.add(mothersMaidenPanel);		
		add(hispanicPanel, BorderLayout.LINE_START);
	}
	
	/** Clears all text fields contained in this Object */
	public void clearTextFields(){
		firstName.setText("");
		fathersName.setText("");
		mothersMaidenName.setText("");
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
	public JPanel getHispanicPanel() {
		return hispanicPanel;
	}
	public void setHispanicPanel(JPanel hispanicPanel) {
		this.hispanicPanel = hispanicPanel;
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
	public JLabel getLblMothersMaiden() {
		return lblMothersMaiden;
	}
	public void setLblMothersMaiden(JLabel lblMothersMaiden) {
		this.lblMothersMaiden = lblMothersMaiden;
	}
	public JTextField getMothersMaidenName() {
		return mothersMaidenName;
	}
	public void setMothersMaidenName(JTextField mothersMaidenName) {
		this.mothersMaidenName = mothersMaidenName;
	}
	public JPanel getMothersMaidenPanel() {
		return mothersMaidenPanel;
	}
	public void setMothersMaidenPanel(JPanel mothersMaidenPanel) {
		this.mothersMaidenPanel = mothersMaidenPanel;
	}
}

