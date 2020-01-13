//PersonMediator.java handles component events from a person user interface
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class PersonMediator implements ActionListener, PersonConstants {
	private PersonJPanel personPanel;
	private FunctionButtonJPanel buttonPanel;
	private ResourceBundle appBundle;
	private PersonManager mgr;
	private Person p;
	private Name n;	
	private GenericDate dob;
	private Calendar aDate = Calendar.getInstance();
	private int month, date, year;		
	private String[] columnNames;
	private List results;
	private TablePerson tablePanel;
	private JupiterFrame tableFrame, actionFrame;
	private boolean personSelected = false;
	private boolean validDateInput = true;
	public PersonMediator(PersonJPanel personPanel, ResourceBundle appBundle)
	{
		this.personPanel=(PersonJPanel)personPanel;		
		this.buttonPanel=personPanel.getButtonPanel();
		this.appBundle=appBundle;
		mgr = new PersonManager();
		dob = new GenericDate();	
		//Previous values of other calendar fields (time etc. data) are retained. 		
		aDate.clear();//If this is not desired, call clear() first.
		columnNames = createTableColumnStrings();
		buttonPanel.getBtnSearch().addActionListener(this);
		buttonPanel.getBtnAdd().addActionListener(this);
		buttonPanel.getBtnDelete().addActionListener(this);
		buttonPanel.getBtnEdit().addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == buttonPanel.getBtnSearch())
		{			
			search();
		}//end if search action
		else if(e.getSource() == buttonPanel.getBtnAdd())
		{
			add();
		}
		else if(e.getSource() == buttonPanel.getBtnEdit())
		{
			//edit
		}
		else if(e.getSource() == buttonPanel.getBtnDelete())
		{
			//delete
		}
	}//end actionPerformed()
	
	/** Creates Strings for the Object's Table Column(s) */
	public String[] createTableColumnStrings()
	{
		String name = appBundle.getString("name.border_title.text");
		String gender = appBundle.getString("person.gender.border_title.text");
		String race = appBundle.getString("person.race.border_title.text");
		String dob = appBundle.getString("person.date_of_birth_border_title.text");
		String[] columns = {name, gender, race, dob};
		return columns;
	}
	
	/** Creates a Name from user input */
	public Name name()
	{	
		//A Name:String first, middle, mothersMaiden, fathers, grandfathers, familys, alias;	
		n = new Name();
		if(personPanel.getNamePanel().getCardSelected() == personPanel.getNamePanel().getTxtEnglish())
		{
			String englishFirst = removeNull(personPanel.getNamePanel().getStandardName().firstName.getText().trim());
			String englishMiddle = removeNull(personPanel.getNamePanel().getStandardName().middleName.getText().trim());		
			String englishFamilys = removeNull(personPanel.getNamePanel().getStandardName().lastName.getText().trim()); 
			
			n.setFirst(englishFirst);
			n.setMiddle(englishMiddle);
			n.setFamilys(englishFamilys);
			
			String mothersMaiden = removeNull(personPanel.getNamePanel().getHispanicName().mothersMaidenName.getText().trim());
			String fathers = removeNull(personPanel.getNamePanel().getArabicName().fathersName.getText().trim());
			String grandfathers = removeNull(personPanel.getNamePanel().getArabicName().grandfathersName.getText().trim());
			String alias = removeNull(personPanel.getNamePanel().getAliasName().aliasName.getText().trim());
			
			n.setMothersMaiden(mothersMaiden);
			n.setFathers(fathers);
			n.setGrandfathers(grandfathers);
			n.setAlias(alias);
		}
		else if(personPanel.getNamePanel().getCardSelected() == personPanel.getNamePanel().getTxtArabic())
		{
			String arabicFirst = removeNull(personPanel.getNamePanel().getArabicName().firstName.getText().trim());
			String arabicFathers = removeNull(personPanel.getNamePanel().getArabicName().fathersName.getText().trim());
			String arabicGrandfathers = removeNull(personPanel.getNamePanel().getArabicName().grandfathersName.getText().trim());
			String arabicFamilys = removeNull(personPanel.getNamePanel().getArabicName().familysName.getText().trim());
			
			n.setFirst(arabicFirst);
			n.setFathers(arabicFathers);
			n.setGrandfathers(arabicGrandfathers);
			n.setFamilys(arabicFamilys);	
			
			String middle = removeNull(personPanel.getNamePanel().getStandardName().middleName.getText().trim());
			String mothersMaiden = removeNull(personPanel.getNamePanel().getHispanicName().mothersMaidenName.getText().trim());
			String alias = removeNull(personPanel.getNamePanel().getAliasName().aliasName.getText().trim());
			
			n.setMiddle(middle);
			n.setMothersMaiden(mothersMaiden);
			n.setAlias(alias);
		}
		else if(personPanel.getNamePanel().getCardSelected() == personPanel.getNamePanel().getTxtHispanic())
		{
			String hispanicFirst = removeNull(personPanel.getNamePanel().getHispanicName().firstName.getText().trim());
			String hispanicFathers = removeNull(personPanel.getNamePanel().getHispanicName().fathersName.getText().trim());
			String hispanicMothersMaiden = removeNull(personPanel.getNamePanel().getHispanicName().mothersMaidenName.getText().trim());
			
			n.setFirst(hispanicFirst);
			n.setFathers(hispanicFathers);
			n.setMothersMaiden(hispanicMothersMaiden);
			
			String middle = removeNull(personPanel.getNamePanel().getStandardName().middleName.getText().trim());
			String grandfathers = removeNull(personPanel.getNamePanel().getArabicName().grandfathersName.getText().trim());
			String alias = removeNull(personPanel.getNamePanel().getAliasName().aliasName.getText().trim());
			String englishFamilys = removeNull(personPanel.getNamePanel().getStandardName().lastName.getText().trim());
			
			n.setMiddle(middle);
			n.setGrandfathers(grandfathers);
			n.setAlias(alias);
			n.setFamilys(englishFamilys);			
		}
		else if(personPanel.getNamePanel().getCardSelected() == personPanel.getNamePanel().getTxtAlias())
		{
			String alias = removeNull(personPanel.getNamePanel().getAliasName().aliasName.getText().trim());
			
			n.setAlias(alias);
			
			String englishFirst = removeNull(personPanel.getNamePanel().getStandardName().firstName.getText().trim());
			String englishMiddle = removeNull(personPanel.getNamePanel().getStandardName().middleName.getText().trim());	
			String mothersMaiden = removeNull(personPanel.getNamePanel().getHispanicName().mothersMaidenName.getText().trim());
			String arabicFathers = removeNull(personPanel.getNamePanel().getArabicName().fathersName.getText().trim());
			String arabicGrandfathers = removeNull(personPanel.getNamePanel().getArabicName().grandfathersName.getText().trim());
			String englishFamilys = removeNull(personPanel.getNamePanel().getStandardName().lastName.getText().trim()); 
			
			n.setFirst(englishFirst);
			n.setMiddle(englishMiddle);
			n.setMothersMaiden(mothersMaiden);
			n.setGrandfathers(arabicGrandfathers);
			n.setFathers(arabicFathers);		
			n.setFamilys(englishFamilys);
		}
		//System.out.println("From name() " + n.toString());
		return n;
	}
	
	/** Removes null values from an input String */
	public String removeNull(String s)
	{
		String notNull = "";
		if (s==null)
			return notNull;
		else return s;
	}
	
	/** Returns a String representation of a Person's Gender from user selection */
	public String gender()
	{
		String gender = (String)personPanel.getGenderPanel().getGenderBox().getSelectedItem();
		//System.out.println("From gender() " + gender);
		return gender;
	}
	
	/** Returns a String representation of a Person's Race from user selection */
	public String race()
	{
		String race = (String)personPanel.getRacePanel().getRaceBox().getSelectedItem();
		//System.out.println("From race() " + race);
		return race;
	}
	
	/** Returns a Calendar date object representing a Person's birth date from user input */
	public Calendar dob()
	{		
		InputVerifier verify = new InputVerifier();
		String inputDOB = (String)personPanel.getDobPanel().getJftDate().getText();
		month = personPanel.getDobPanel().getMonth(inputDOB);
		date = personPanel.getDobPanel().getDate(inputDOB);
		year = personPanel.getDobPanel().getYear(inputDOB);
		if(verify.dateIsNull(month, date, year))//if inputDOB is 00/00/0000
		{
			aDate=null;
		}
		else if(!verify.validDate(month,date,year))
		{
			//notify user of invalid date input
			JOptionPane.showMessageDialog(null,
					appBundle.getString("exception.io.invalid_date.message"),
					appBundle.getString("exception.io.invalid_date.title"),
					JOptionPane.ERROR_MESSAGE);
			setValidDateInput(false);//Input Date INVALID!
			aDate=null;
		}
		else//Date input is valid
		{
			dob.setTheDate(year,month,date);//set the Calendar date from user input
			aDate = dob.getTheDate();//Return the Calendar date
		}						
		return aDate;
	}//end dob()

	/** Adds a Person to the database */
	public void add()
	{
		try
		{
			p = new Person();
			Calendar dob = dob();
			//Make sure inputDOB is a valid Date
			if(!validDateInput)//if validDateInput is false
			{
				personPanel.getDobPanel().requestFocus();//set focus to date field
				setValidDateInput(true);//reset valid date input
				return;//abort add() record!
			}
			p.setName(name());			
			p.setGender(gender());
			p.setRace(race());
			p.setDob(dob);
			if(!nameNull(p.getName()))//If Name is not blank
			{
				//Check that Name does not exceed maximum input allowed
				if(!nameInputValid(p.getName()))		
				{//if input size is NOT valid
					JOptionPane.showMessageDialog(null,
							appBundle.getString("exception.io.exceed_max_input.message"),
							appBundle.getString("exception.io.exceed_max_input.title"),
							JOptionPane.ERROR_MESSAGE);
					return;
				}//end if name exceeds maximum allowed
				else//Add the record and notify user of record entry
				{
					mgr.add(p);
					personPanel.clearTextFields();
					String inputDOB;
					if(p.getDob() == null)
					{
						inputDOB="";
					}
					else
					{
						InputVerifier input = new InputVerifier();
						inputDOB = input.CalendarDateToStringDate(p.getDob());
					}
					JOptionPane.showMessageDialog(null,
							appBundle.getString("message.record_added.message.text")+
							"\n" + p.getName().toString() + "\n" + p.getGender() + " " +
							p.getRace() + " " + inputDOB,
							appBundle.getString("message.record_added.title.text"),
							JOptionPane.INFORMATION_MESSAGE);
				}//end else	name not null and does not exceed maximum			
			}
			else//Name was null! Add Person record not allowed!
			{
				JOptionPane.showMessageDialog(null,
						appBundle.getString("exception.io.blank_record.message"),
						appBundle.getString("exception.io.blank_record.title"),
						JOptionPane.ERROR_MESSAGE);
				return;
			}
				
		}//end try
		catch(NullPointerException ex)
		{
			//Its ok if date of birth is null
		}//end catch	
	}//end add()
	
	/** Uses nameValid(String aName) method to validate name input
	 	Returns true, if name does not exceed maximum, else returns false */
	public boolean nameInputValid(Name inputName)
	{
		 if((nameValid(inputName.getFirst())) &&
		 	(nameValid(inputName.getMiddle())) &&
				(nameValid(inputName.getFamilys()) &&
					(nameValid(inputName.getFathers())) &&
						(nameValid(inputName.getGrandfathers())) &&
							(nameValid(inputName.getMothersMaiden())) &&
								(nameValid(inputName.getAlias()))))
									return true;
		 else return false;
	}
	
	/** Uses InputVerifier to verify that a name string does not exceed maximum 	
	 * @param aName a name string (first, middle, familys...)
	 * @return true if name does not exceed maximum allowed, else returns false
	 */
	public boolean nameValid(String aName)
	{
		InputVerifier verify = new InputVerifier();
		return verify.inputSizeAllowed(aName, InputConstants.NAME_MAX_SIZE);
	}	
	
	/** Prohibits a user from adding a Person record that has no name
 		Returns true, if name fields are blank */
	public boolean nameNull(Name inputName)
	{
		 if((inputName.getFirst() == "") &&
		 	(inputName.getMiddle() == "") &&
				(inputName.getFamilys() == "") &&
					(inputName.getFathers() == "") &&
						(inputName.getGrandfathers() == "") &&
							(inputName.getMothersMaiden() == "") &&
								(inputName.getAlias() == ""))
									return true;
		 else return false;
	}
	
	/** Searches the database for a Person with parameters provided by user input
	 * 	Result:  Shows a Table containing the Search Results,
	 *  listens for any table selections,
	 *  sets selectedPerson to the Organization selected from the Table,
	 *  sets personSelected to true */
	public void search()
	{	
		try
		{				
			p = new Person();
			Calendar dob = dob();				
			p.setName(name());
			p.setGender(gender());
			p.setRace(race());
			p.setDob(dob);
			//System.out.println("PersonMediator p.toString() after input " + p.toString());
			results = mgr.findPersonsByExample(p);
			//System.out.println("PersonMediator results size " + results.size());			
			//Create TableModelPerson to show search results in table
			TableModelPerson model = new TableModelPerson(columnNames, results);				
			tablePanel = new TablePerson(model);//Create table			
			String frameTitle = (appBundle.getString("table.person.search_results.text"));
			//Add title and table to frame and show frame
			tableFrame = new JupiterFrame(frameTitle, tablePanel);
			tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			tableFrame.setResizable(false);
			tableFrame.setVisible(true);
			/* 
			 * Add a MouseListener to this table
			 * This mediator is only interested in a user double-clicking a row,
			 * then obtaining the object associated with the row.
			 * A class that is interested in processing a mouse event either implements
			 * MouseListener interface (and all the methods it contains) or it extends 
			 * the abstract MouseAdapter class (overriding only the methods of interest).
			 * MouseAdapter is used to override the only method of interest:
			 * MouseClicked (or double-clicked in this case)    
			 */
			tablePanel.getTable().addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					if(e.getClickCount() > 1)
					{					
						//if person is double-clicked set p to person selected
						setP(tablePanel.getPersonSelected());
						//System.out.println("Person double-clicked: " + p.toString());
						setPersonSelected(true);
						tableFrame.dispose();//close table frame
						actionFrame.dispose();//close link analysis frame
					}						
				}
			});			
		}//end try
		catch(NullPointerException ex)
		{
			System.out.println("NullPointerException in search()");
			//It is OK if some user input data is null
		}//end catch						
	}//end search() method
	
	public Calendar getADate() {
		return aDate;
	}
	public void setADate(Calendar date) {
		aDate = date;
	}
	public ResourceBundle getAppBundle() {
		return appBundle;
	}
	public void setAppBundle(ResourceBundle appBundle) {
		this.appBundle = appBundle;
	}
	public FunctionButtonJPanel getButtonPanel() {
		return buttonPanel;
	}
	public void setButtonPanel(FunctionButtonJPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}
	public String[] getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public GenericDate getDob() {
		return dob;
	}
	public void setDob(GenericDate dob) {
		this.dob = dob;
	}
	public PersonManager getMgr() {
		return mgr;
	}
	public void setMgr(PersonManager mgr) {
		this.mgr = mgr;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public Name getN() {
		return n;
	}
	public void setN(Name n) {
		this.n = n;
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public PersonJPanel getPersonPanel() {
		return personPanel;
	}
	public void setPersonPanel(PersonJPanel personPanel) {
		this.personPanel = personPanel;
	}
	public List getResults() {
		return results;
	}
	public void setResults(List results) {
		this.results = results;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public JupiterFrame getTableFrame() {
		return tableFrame;
	}

	public void setTableFrame(JupiterFrame tableFrame) {
		this.tableFrame = tableFrame;
	}

	public TablePerson getTablePanel() {
		return tablePanel;
	}

	public void setTablePanel(TablePerson tablePanel) {
		this.tablePanel = tablePanel;
	}	

	public JupiterFrame getActionFrame() {
		return actionFrame;
	}

	public void setActionFrame(JupiterFrame actionFrame) {
		this.actionFrame = actionFrame;
	}

	public boolean isPersonSelected() {
		return personSelected;
	}

	public void setPersonSelected(boolean personSelected) {
		this.personSelected = personSelected;
	}

	public boolean isValidDateInput() {
		return validDateInput;
	}

	public void setValidDateInput(boolean validDateInput) {
		this.validDateInput = validDateInput;
	}	
	
	
}

