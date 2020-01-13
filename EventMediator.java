//EventMediator.java handles component events from a event user interface
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EventMediator implements ActionListener {
	private EventJPanel eventPanel;
	private ResourceBundle appBundle;
	private FunctionButtonJPanel buttonPanel;
	private EventManager mgr;
	private Event anEvent;
	private GenericDate eventDate;
	private Calendar aDate = Calendar.getInstance();
	private int month, date, year;		
	private String[] columnNames;
	private List results;
	private TableEvent tablePanel;
	private JupiterFrame tableFrame, actionFrame;
	private boolean eventSelected = false;
	private boolean validDateInput = true;
	public EventMediator(EventJPanel eventPanel, ResourceBundle appBundle)
	{
		this.eventPanel=(EventJPanel)eventPanel;		
		this.buttonPanel=eventPanel.getButtonPanel();
		this.appBundle=appBundle;
		mgr = new EventManager();
		eventDate = new GenericDate();	
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
		String date = appBundle.getString("table.event.column_date.text");
		String title = appBundle.getString("table.event.column_title.text");
		String description = appBundle.getString("table.event.column_description.text");		
		String[] columns = {date,title,description};
		return columns;
	}
	
	/** Returns a Calendar date object representing an Event Date from user input */
	public Calendar eventDate()
	{		
		InputVerifier verify = new InputVerifier();
		String inputEventDate = (String)eventPanel.getDatePanel().getJftDate().getText();
		month = eventPanel.getDatePanel().getMonth(inputEventDate);
		date = eventPanel.getDatePanel().getDate(inputEventDate);
		year = eventPanel.getDatePanel().getYear(inputEventDate);
		if(verify.dateIsNull(month, date, year))//if inputEventDate is 00/00/0000
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
			eventDate.setTheDate(year,month,date);//set the Calendar date from user input
			aDate = eventDate.getTheDate();//Return the Calendar date
		}	
		return aDate;
	}//end eventDate()
	
	/** Removes null values from an input String */
	public String removeNull(String s)
	{
		String notNull = "";
		if (s==null)
			return notNull;
		else return s;
	}
	
	/** Returns a String representation of an Event Title from user input */
	public String title()
	{
		String title = removeNull((String)eventPanel.getTitle().getText());
		return title;
	}
	
	/** Returns a String representation of an Event Description from user input */
	public String description()
	{
		String description = removeNull((String)eventPanel.getDescription().getText());
		return description;
	}
	
	/** Adds an Event to the database */
	public void add()
	{
		try
		{
			anEvent = new Event();
			Calendar aDate = eventDate();
			//Make sure inputEventDate is a valid Date
			if(!validDateInput)//if date input is not valid
			{
				eventPanel.getDatePanel().requestFocus();//set focus to date field
				setValidDateInput(true);//reset valid date input
				return;
			}
			anEvent.setEventDate(aDate);
			anEvent.setTitle(title());			
			anEvent.setDescription(description());
			//If Event title and description input is not blank
			if(!eventNull(anEvent.getTitle(), anEvent.getDescription()))
			{
				//Check that title and/or description do not exceed maximum input allowed
				if(!eventInputValid(anEvent.getTitle(), anEvent.getDescription()))		
				{//if input size is NOT valid
					JOptionPane.showMessageDialog(null,
							appBundle.getString("exception.io.exceed_max_input.message"),
							appBundle.getString("exception.io.exceed_max_input.title"),
							JOptionPane.ERROR_MESSAGE);
				}//end if title and/or description exceeds maximum allowed
				else//Add the record and notify user of record entry
				{
					mgr.add(anEvent);
					eventPanel.clearTextFields();
					String inputEventDate;
					if(anEvent.getEventDate() == null)
					{
						inputEventDate="";
					}
					else
					{
						InputVerifier input = new InputVerifier();
						inputEventDate = input.CalendarDateToStringDate(anEvent.getEventDate());
					}
					JOptionPane.showMessageDialog(null,
							appBundle.getString("message.record_added.message.text")+
							"\n" + inputEventDate + "\n" + anEvent.getTitle() + "\n" +
							anEvent.getDescription(),
							appBundle.getString("message.record_added.title.text"),
							JOptionPane.INFORMATION_MESSAGE);
				}//end else	name not null and does not exceed maximum			
			}
			else//Event was blank! Add record not allowed!
			{
				JOptionPane.showMessageDialog(null,
						appBundle.getString("exception.io.blank_record.message"),
						appBundle.getString("exception.io.blank_record.title"),
						JOptionPane.ERROR_MESSAGE);
			}				
		}//end try add()
		catch(NullPointerException ex)
		{
			//Its ok if event date is null
		}//end catch	
	}//end add()
	
	/** Searches the database for a Person with parameters provided by user input
	 * 	Result:  Shows a Table containing the Search Results,
	 *  listens for any table selections,
	 *  sets selectedPerson to the Organization selected from the Table,
	 *  sets personSelected to true */
	public void search()
	{	
		try
		{				
			anEvent = new Event();
			Calendar aDate = eventDate();
			anEvent.setEventDate(aDate);
			anEvent.setTitle(title());			
			anEvent.setDescription(description());
			results = mgr.findEventsByExample(anEvent);
			TableModelEvent model = new TableModelEvent(columnNames, results);				
			tablePanel = new TableEvent(model);//Create table			
			String frameTitle = (appBundle.getString("table.event.search_results.text"));
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
						//if an event is double-clicked set anEvent to Event selected
						setAnEvent(tablePanel.getEventSelected());
						setEventSelected(true);
						tableFrame.dispose();//close table frame
						actionFrame.dispose();//close link analysis frame
					}						
				}
			});			
		}//end try
		catch(NullPointerException ex)
		{
			//System.out.println("NullPointerException in search()");
			//It is OK if some user input data is null
		}//end catch						
	}//end search() method
	
	/** Uses titleValid(String title) and descriptionValid(String description)
	 *  methods to validate event input.
	 *  Returns true, if both title and description do not exceed maximum,
	 *  Returns false, if either title or description exceed maximum.  */
	public boolean eventInputValid(String title, String description)
	{
		 if(titleValid(title) && descriptionValid(description))
			 return true;
		 else return false;
	}

	/** Uses InputVerifier to verify that a title string does not exceed maximum 	
	 * @param title an event title string
	 * @return true if title does not exceed maximum allowed, else returns false
	 */
	public boolean titleValid(String title)
	{
		InputVerifier verify = new InputVerifier();
		return verify.inputSizeAllowed(title, InputConstants.NAME_MAX_SIZE);
	}	

	/** Uses InputVerifier to verify that a description string does not exceed maximum 	
	 * @param description an event description string
	 * @return true if description does not exceed maximum allowed, else returns false
	 */
	public boolean descriptionValid(String description)
	{
		InputVerifier verify = new InputVerifier();
		return verify.inputSizeAllowed(description, InputConstants.DEFAULT_MAX_SIZE);
	}	
	
	/** Prohibits a user from adding an Event record that is blank
		Returns true, if fields are blank
		Returns false, if fields contain data */
	public boolean eventNull(String title, String description)
	{
		 if((title == "") &&
		 	(description == ""))
				return true;
		 else return false;
	}

	public JupiterFrame getActionFrame() {
		return actionFrame;
	}

	public void setActionFrame(JupiterFrame actionFrame) {
		this.actionFrame = actionFrame;
	}

	public Calendar getADate() {
		return aDate;
	}

	public void setADate(Calendar date) {
		aDate = date;
	}

	public Event getAnEvent() {
		return anEvent;
	}

	public void setAnEvent(Event anEvent) {
		this.anEvent = anEvent;
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

	public GenericDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(GenericDate eventDate) {
		this.eventDate = eventDate;
	}

	public EventJPanel getEventPanel() {
		return eventPanel;
	}

	public void setEventPanel(EventJPanel eventPanel) {
		this.eventPanel = eventPanel;
	}

	public boolean isEventSelected() {
		return eventSelected;
	}

	public void setEventSelected(boolean eventSelected) {
		this.eventSelected = eventSelected;
	}

	public EventManager getMgr() {
		return mgr;
	}

	public void setMgr(EventManager mgr) {
		this.mgr = mgr;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public List getResults() {
		return results;
	}

	public void setResults(List results) {
		this.results = results;
	}

	public JupiterFrame getTableFrame() {
		return tableFrame;
	}

	public void setTableFrame(JupiterFrame tableFrame) {
		this.tableFrame = tableFrame;
	}

	public TableEvent getTablePanel() {
		return tablePanel;
	}

	public void setTablePanel(TableEvent tablePanel) {
		this.tablePanel = tablePanel;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isValidDateInput() {
		return validDateInput;
	}

	public void setValidDateInput(boolean validDateInput) {
		this.validDateInput = validDateInput;
	}
	
	
}
