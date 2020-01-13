//CountryJPanel.java is a panel that shows a list of countries
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
public class CountryJPanel extends JPanel {
	private JLabel lblCountry;
	private JComboBox jcbCountries;
	
	public CountryJPanel(String txtCountry, ArrayList countries)
	{
		lblCountry = new JLabel(txtCountry);
		jcbCountries = new JComboBox(countries.toArray());
		jcbCountries.setEditable(false);
		jcbCountries.setSelectedIndex(233);
		add(lblCountry);
		add(jcbCountries);
	}

	public JComboBox getJcbCountries() {
		return jcbCountries;
	}

	public void setJcbCountries(JComboBox jcbCountries) {
		this.jcbCountries = jcbCountries;
	}

	public JLabel getLblCountry() {
		return lblCountry;
	}

	public void setLblCountry(JLabel lblCountry) {
		this.lblCountry = lblCountry;
	}
	
	
}
