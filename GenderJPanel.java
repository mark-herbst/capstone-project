//GenderJPanel.java is a panel that contains gender choices for a person
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GenderJPanel extends JPanel {
	private JComboBox genderBox;
	private JLabel lblGender;	
	
	public GenderJPanel(){}//default constructor	
	public GenderJPanel(String txtGender, String txtMale, String txtFemale)
	{				
		lblGender = new JLabel(txtGender);
		String[] genderTypes = {txtMale, txtFemale};
		genderBox = new JComboBox(genderTypes);
		genderBox.setEditable(false);
		genderBox.setFocusable(true);
		add(lblGender);
		add(genderBox);		
	}	
	
	public JComboBox getGenderBox() {
		return genderBox;
	}
	public void setGenderBox(JComboBox genderBox) {
		this.genderBox = genderBox;
	}
	public JLabel getLblGender() {
		return lblGender;
	}
	public void setLblGender(JLabel lblGender) {
		this.lblGender = lblGender;
	}
	
}
