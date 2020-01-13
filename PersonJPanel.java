/** PersonJPanel.java is a panel that contains components used to create a Person Object */
import javax.swing.JPanel;
import java.awt.BorderLayout;
public class PersonJPanel extends JPanel  {
	private String title;
	private JPanel mainPanel, componentPanel;
	private NameJPanel namePanel;
	private GenderJPanel genderPanel;
	private RaceJPanel racePanel;
	private DateJPanel dobPanel;
	private FunctionButtonJPanel buttonPanel;
	
	public PersonJPanel(String title, JPanel name, JPanel gender, JPanel race,
						JPanel dob, JPanel buttons)//JPanel address, 
	{
		setLayout(new BorderLayout());	
		this.title=title;
		this.namePanel=(NameJPanel)name;
		this.genderPanel=(GenderJPanel)gender;
		this.racePanel=(RaceJPanel)race;
		this.dobPanel=(DateJPanel)dob;
		this.buttonPanel=(FunctionButtonJPanel)buttons;
		
		componentPanel = new JPanel();
		componentPanel.add(genderPanel);
		componentPanel.add(racePanel);
		componentPanel.add(dobPanel);
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(namePanel, BorderLayout.NORTH);
		mainPanel.add(componentPanel, BorderLayout.WEST);
		
		add(mainPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);		
	}
	
	/** Clears all text fields contained in this Object */
	public void clearTextFields()
	{
		namePanel.clearTextFields();
    	dobPanel.clearTextFields();
	}

	public FunctionButtonJPanel getButtonPanel() {
		return buttonPanel;
	}
	public void setButtonPanel(FunctionButtonJPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}
	public JPanel getComponentPanel() {
		return componentPanel;
	}
	public void setComponentPanel(JPanel componentPanel) {
		this.componentPanel = componentPanel;
	}
	public DateJPanel getDobPanel() {
		return dobPanel;
	}
	public void setDobPanel(DateJPanel dobPanel) {
		this.dobPanel = dobPanel;
	}
	public GenderJPanel getGenderPanel() {
		return genderPanel;
	}
	public void setGenderPanel(GenderJPanel genderPanel) {
		this.genderPanel = genderPanel;
	}
	public JPanel getMainPanel() {
		return mainPanel;
	}
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	public NameJPanel getNamePanel() {
		return namePanel;
	}
	public void setNamePanel(NameJPanel namePanel) {
		this.namePanel = namePanel;
	}
	public RaceJPanel getRacePanel() {
		return racePanel;
	}
	public void setRacePanel(RaceJPanel racePanel) {
		this.racePanel = racePanel;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
}
