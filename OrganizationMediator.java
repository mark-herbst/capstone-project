/** OrganizationMediator.java handles all events associated with an OrganizationJPanel */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OrganizationMediator implements ActionListener, InputConstants {
	private OrganizationJPanel orgPanel;
	private FunctionButtonJPanel buttonPanel;
	private ResourceBundle appBundle;
	private OrganizationManager mgr;
	private Organization org;
	private String[] columnNames;
	private List results;
	private TableOrganization tablePanel;
	private JupiterFrame tableFrame, actionFrame;
	private boolean orgSelected = false;
	
	public OrganizationMediator(OrganizationJPanel orgPanel, ResourceBundle appBundle)
	{
		this.orgPanel=(OrganizationJPanel)orgPanel;		
		this.buttonPanel=orgPanel.getButtonPanel();
		this.appBundle=appBundle;
		mgr = new OrganizationManager();
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
		String organization = appBundle.getString("organization.border_title.text");
		String[] columns = {organization};
		return columns;
	}
	
	/** Adds an Organization to the database */
	public void add()
	{
		try
		{
			org = new Organization();
			String orgName = (String)orgPanel.getOrganization().getText();
			InputVerifier verify = new InputVerifier();
			if(!verify.inputSizeAllowed(orgName, InputConstants.DEFAULT_MAX_SIZE))
			{//if input size is NOT valid
				JOptionPane.showMessageDialog(null,
						appBundle.getString("exception.io.exceed_max_input.message"),
						appBundle.getString("exception.io.exceed_max_input.title"),
						JOptionPane.ERROR_MESSAGE);
				return;
			}//end if !verify
			else//Add the record and notify user of record entry
			{
				org.setOrganizationName(orgName);			
				mgr.add(org);
				orgPanel.clearTextFields();
				JOptionPane.showMessageDialog(null,
						appBundle.getString("message.record_added.message.text")+
						"\n" + orgName,
						appBundle.getString("message.record_added.title.text"),
						JOptionPane.INFORMATION_MESSAGE);
			}//end else			
		}//end try
		catch(NullPointerException ex)//cannot add a null organization
		{
			JOptionPane.showMessageDialog(null,
					appBundle.getString("exception.io.null_input.message"),
					appBundle.getString("exception.io.null_input.title"),
					JOptionPane.ERROR_MESSAGE);
			orgPanel.getOrganization().requestFocus();
		}//end catch	
	}
	
	/** Searches the database for an Organization with parameters provided by user input
	 * 	Result:  Shows a Table containing the Search Results,
	 *  listens for any table selections,
	 *  sets selectedOrg to the Organization selected from the Table,
	 *  sets orgSelected to true */
	public void search()
	{	
		try
		{				
			String orgName = (String)orgPanel.getOrganization().getText();
			org = new Organization();
			org.setOrganizationName(orgName);			
			results = mgr.findOrganizationsByExample(org);						
			//Create TableModelOrganization to show search results in table
			TableModelOrganization model = new TableModelOrganization(columnNames, results);				
			tablePanel = new TableOrganization(model);//Create table			
			String frameTitle = (appBundle.getString("table.organization.search_results.text"));
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
						//if organization is double-clicked set org to org selected
						setOrg(tablePanel.getOrganizationSelected());
						//System.out.println("Person double-clicked: " + p.toString());
						setOrgSelected(true);
						tableFrame.dispose();//close table frame
						actionFrame.dispose();//close link analysis frame
					}						
				}
			});		
			
		}//end try
		catch(NullPointerException ex)
		{
			//System.out.println("NullPointerException in search()");
			//It is OK if search input is null
		}//end catch						
	}//end search() method

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

	public JupiterFrame getActionFrame() {
		return actionFrame;
	}

	public void setActionFrame(JupiterFrame actionFrame) {
		this.actionFrame = actionFrame;
	}

	public OrganizationManager getMgr() {
		return mgr;
	}

	public void setMgr(OrganizationManager mgr) {
		this.mgr = mgr;
	}

	public TableOrganization getTablePanel() {
		return tablePanel;
	}

	public void setTablePanel(TableOrganization tablePanel) {
		this.tablePanel = tablePanel;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public OrganizationJPanel getOrgPanel() {
		return orgPanel;
	}

	public void setOrgPanel(OrganizationJPanel orgPanel) {
		this.orgPanel = orgPanel;
	}

	public boolean isOrgSelected() {
		return orgSelected;
	}

	public void setOrgSelected(boolean orgSelected) {
		this.orgSelected = orgSelected;
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
}
