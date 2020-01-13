/** RaceJPanel.java is a panel that represents a Person's Race */
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class RaceJPanel extends JPanel {
	private JComboBox raceBox;
	private JLabel lblRace;	
	
	public RaceJPanel(){}//default constructor	
	public RaceJPanel(String txtRace, String txtAsian, String txtBlack, String txtHispanic,
						String txtIndian, String txtWhite, String txtUnknown)
	{
		lblRace = new JLabel(txtRace);
		String[] genderTypes = {txtAsian, txtBlack, txtHispanic, txtIndian,
								txtWhite, txtUnknown};
		raceBox = new JComboBox(genderTypes);
		raceBox.setEditable(false);
		raceBox.setFocusable(true);
		add(lblRace);
		add(raceBox);		
		raceBox.setSelectedItem(txtWhite);
	}	
	
	public JLabel getLblRace() {
		return lblRace;
	}
	public void setLblRace(JLabel lblRace) {
		this.lblRace = lblRace;
	}
	public JComboBox getRaceBox() {
		return raceBox;
	}
	public void setRaceBox(JComboBox raceBox) {
		this.raceBox = raceBox;
	}	
}