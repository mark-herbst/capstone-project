/** AddressJPanel.java is a panel that contains components used for input of
 * 	an international address */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
public class AddressJPanel extends JPanel {
	private JLabel lblStreet, lblCity, lblState, lblZipcode;
	private JTextField street, city, state, zipcode;
	private CountryJPanel countryPanel;
	private JPanel streetPanel, cityPanel, statePanel, zipcodePanel,
					streetCityPanel, stateZipPanel, addressPanel, mainPanel,
					groupPanel, formattedMainPanel;
	private FunctionButtonJPanel buttonPanel;
	
	public AddressJPanel(JPanel countryPanel, String txtStreet, String txtCity,
							String txtState, String txtZipcode,	JPanel buttons)
	{		
		this.countryPanel=(CountryJPanel)countryPanel;
		this.buttonPanel=(FunctionButtonJPanel)buttons;
		setLayout(new BorderLayout());
		
		lblStreet = new JLabel(txtStreet);
		lblCity = new JLabel(txtCity);
		lblState = new JLabel(txtState);
		lblZipcode = new JLabel(txtZipcode);
		street = new JTextField(15);
		city = new JTextField(15);
		state = new JTextField(15);
		zipcode = new JTextField(5);
		
		streetPanel = new JPanel(new BorderLayout(5,5));//(hgap, vgap)
		streetPanel.add(lblStreet, BorderLayout.WEST);
		streetPanel.add(street, BorderLayout.CENTER);			
		
		cityPanel = new JPanel(new BorderLayout(5,5));
		cityPanel.add(lblCity, BorderLayout.WEST);
		cityPanel.add(city, BorderLayout.CENTER);
		
		statePanel = new JPanel(new BorderLayout(5,5));
		statePanel.add(lblState, BorderLayout.WEST);
		statePanel.add(state, BorderLayout.CENTER);		
		
		zipcodePanel = new JPanel(new BorderLayout(5,5));
		zipcodePanel.add(lblZipcode, BorderLayout.WEST);
		zipcodePanel.add(zipcode, BorderLayout.CENTER);	
		
		streetCityPanel = new JPanel(new GridLayout(2,0));//row,col
		streetCityPanel.add(streetPanel);
		streetCityPanel.add(cityPanel);
		
		stateZipPanel = new JPanel(new GridLayout(2,0));
		stateZipPanel.add(statePanel);
		stateZipPanel.add(zipcodePanel);		
		
		addressPanel = new JPanel(new GridLayout(2,0));
		addressPanel.add(streetCityPanel);
		addressPanel.add(stateZipPanel);
		
		groupPanel = new JPanel(new BorderLayout());
		groupPanel.add(countryPanel, BorderLayout.NORTH);
		groupPanel.add(addressPanel, BorderLayout.CENTER);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(groupPanel, BorderLayout.NORTH);
		
		formattedMainPanel = new JPanel();
		formattedMainPanel.add(mainPanel);
	
		add(formattedMainPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/** Clears all text fields contained in this Object */
	public void clearTextFields()
	{
		street.setText("");
		city.setText("");
		state.setText("");
		zipcode.setText("");
	}
	
	public CountryJPanel getCountryPanel() {
		return countryPanel;
	}

	public void setCountryPanel(CountryJPanel countryPanel) {
		this.countryPanel = countryPanel;
	}

	public JPanel getAddressPanel() {
		return addressPanel;
	}

	public void setAddressPanel(JPanel addressPanel) {
		this.addressPanel = addressPanel;
	}

	public JTextField getCity() {
		return city;
	}

	public void setCity(JTextField city) {
		this.city = city;
	}

	public JPanel getCityPanel() {
		return cityPanel;
	}

	public void setCityPanel(JPanel cityPanel) {
		this.cityPanel = cityPanel;
	}
	
	public JLabel getLblCity() {
		return lblCity;
	}

	public void setLblCity(JLabel lblCity) {
		this.lblCity = lblCity;
	}

	public JLabel getLblState() {
		return lblState;
	}

	public void setLblState(JLabel lblState) {
		this.lblState = lblState;
	}

	public JLabel getLblStreet() {
		return lblStreet;
	}

	public void setLblStreet(JLabel lblStreet) {
		this.lblStreet = lblStreet;
	}

	public JLabel getLblZipcode() {
		return lblZipcode;
	}

	public void setLblZipcode(JLabel lblZipcode) {
		this.lblZipcode = lblZipcode;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JTextField getState() {
		return state;
	}

	public void setState(JTextField state) {
		this.state = state;
	}

	public JPanel getStatePanel() {
		return statePanel;
	}

	public void setStatePanel(JPanel statePanel) {
		this.statePanel = statePanel;
	}
	
	public JPanel getStateZipPanel() {
		return stateZipPanel;
	}

	public void setStateZipPanel(JPanel stateZipPanel) {
		this.stateZipPanel = stateZipPanel;
	}

	public JTextField getStreet() {
		return street;
	}

	public void setStreet(JTextField street) {
		this.street = street;
	}

	public JPanel getStreetCityPanel() {
		return streetCityPanel;
	}

	public void setStreetCityPanel(JPanel streetCityPanel) {
		this.streetCityPanel = streetCityPanel;
	}

	public JPanel getStreetPanel() {
		return streetPanel;
	}

	public void setStreetPanel(JPanel streetPanel) {
		this.streetPanel = streetPanel;
	}

	public JTextField getZipcode() {
		return zipcode;
	}

	public void setZipcode(JTextField zipcode) {
		this.zipcode = zipcode;
	}

	public JPanel getZipcodePanel() {
		return zipcodePanel;
	}

	public void setZipcodePanel(JPanel zipcodePanel) {
		this.zipcodePanel = zipcodePanel;
	}

	public FunctionButtonJPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(FunctionButtonJPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public JPanel getFormattedMainPanel() {
		return formattedMainPanel;
	}

	public void setFormattedMainPanel(JPanel formattedMainPanel) {
		this.formattedMainPanel = formattedMainPanel;
	}

	public JPanel getGroupPanel() {
		return groupPanel;
	}

	public void setGroupPanel(JPanel groupPanel) {
		this.groupPanel = groupPanel;
	}	
	
}
