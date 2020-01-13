//LinkCreator.java creates links between entities
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.ResourceBundle;

public class LinkCreator implements EntityTypes {
	private ResourceBundle appBundle;
	private JPanel searchPanel;
	private JupiterFrame searchFrame;
	private PersonMediator personMediator;
	private OrganizationMediator orgMediator;
	private EventMediator eventMediator;
	private Person parentPerson, linkPerson;
	private Organization parentOrganization, linkOrganization;
	private Event parentEvent, linkEvent;
	private LinkManager linkManager;
	private static String Parent, Link;
	
	public LinkCreator(ResourceBundle appBundle, JPanel searchPanel,
			PersonMediator personMediator, OrganizationMediator orgMediator,
			EventMediator eventMediator)
	{
		this.appBundle=appBundle;
		this.searchPanel=searchPanel;
		this.personMediator=personMediator;
		this.orgMediator=orgMediator;
		this.eventMediator=eventMediator;
		searchForParent();		
	}
	
	/** Initiates a Search of the database for the Object to which
	 	a Link will be created */
	public void searchForParent()
	{
		String frameTitle = appBundle.getString("manage.add_link.search_for_target");		
		searchFrame = new JupiterFrame(frameTitle, searchPanel);
		searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		searchFrame.setResizable(true);
		searchFrame.setVisible(true);
		personMediator.setActionFrame(searchFrame);			
		orgMediator.setActionFrame(searchFrame);
		eventMediator.setActionFrame(searchFrame);
		//addressMediator.setActionFrame(parentSearchFrame);
		//phoneMediator.setActionFrame(parentSearchFrame);
		searchFrame.addWindowListener(new WindowAdapter(){
		public void windowClosed(WindowEvent e){
			if (personMediator.isPersonSelected())//if person parent selected
			{								
				parentPerson = personMediator.getP();
				personMediator.setPersonSelected(false);//reset personSelected
				Parent=PERSON;
				String personName = parentPerson.getName().toString();
				searchForLink(personName);//search for child person					
			}//end if isPersonSelected()
			else if (orgMediator.isOrgSelected())//if org parent selected
			{
				parentOrganization = orgMediator.getOrg();
				orgMediator.setOrgSelected(false);//reset orgSelected
				Parent=ORGANIZATION;
				String orgName = orgMediator.getOrg().toString();
				searchForLink(orgName);
			}
			else if (eventMediator.isEventSelected())
			{
				parentEvent = eventMediator.getAnEvent();
				eventMediator.setEventSelected(false);//reset eventSelected
				Parent=EVENT;
				String eventTitle = eventMediator.getAnEvent().getTitle().toString();
				searchForLink(eventTitle);
			}
			//else if (addressMediator.isAddressSelected()){}
			//else if (PhoneMediator.isPhoneSelected()){}
		}//end parentSearchFrame windowClosed
		});//end parentSearchFrame add WindowListener
	}//end searchForParent()
	
	/** Initiates a Search of the database for the Link Object to which
	 	a Link to the Parent Object will be created */
	public void searchForLink(String parentName)
	{		
		String frameTitle = appBundle.getString("manage.add_link_to.text");
		frameTitle = frameTitle + "  "  + parentName;
		searchFrame = new JupiterFrame(frameTitle, searchPanel);
		searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		searchFrame.setResizable(true);
		searchFrame.setVisible(true);
		personMediator.setActionFrame(searchFrame);			
		orgMediator.setActionFrame(searchFrame);
		eventMediator.setActionFrame(searchFrame);
		//addressMediator.setActionFrame(childSearchFrame);
		//phoneMediator.setActionFrame(childSearchFrame);
		searchFrame.addWindowListener(new WindowAdapter(){
		public void windowClosed(WindowEvent e){
			if (personMediator.isPersonSelected())//if person selected
			{								
				linkPerson = personMediator.getP(); 
				personMediator.setPersonSelected(false);//reset personSelected
				Link=PERSON;
				createLink();						
			}		
			else if (orgMediator.isOrgSelected())//if org selected
			{
				linkOrganization = orgMediator.getOrg();
				orgMediator.setOrgSelected(false);//reset orgSelected
				Link=ORGANIZATION;	
				createLink();
			}
			else if (eventMediator.isEventSelected())//if event selected
			{
				linkEvent = eventMediator.getAnEvent();
				eventMediator.setEventSelected(false);//reset eventSelected
				Link=EVENT;
				createLink();
			}
		}//end childSearchFrame windowClosed
		});//end childSearchFrame WindowListener
	}

	/** Determines the Link Type and then calls the appropriate method to
	 	create a Link between the two selected Objects */
	public void createLink()
	{
		if(Parent.equals(PERSON)&& Link.equals(PERSON))
		{
			createPersonPersonLink();
		}
		else if(Parent.equals(ORGANIZATION)&& Link.equals(ORGANIZATION))
		{
			createOrganizationOrganizationLink();
		}
		else if(Parent.equals(EVENT)&& Link.equals(EVENT))
		{
			createEventEventLink();
		}
		else if((Parent.equals(PERSON) && Link.equals(ORGANIZATION)) ||
				(Parent.equals(ORGANIZATION) && Link.equals(PERSON)))
		{
			createPersonOrganizationLink();
		}
		else if((Parent.equals(PERSON)&& Link.equals(EVENT)) ||
				(Parent.equals(EVENT) && Link.equals(PERSON)))
		{
			createPersonEventLink();
		}
		else if((Parent.equals(ORGANIZATION)&& Link.equals(EVENT)) ||
				(Parent.equals(EVENT) && Link.equals(ORGANIZATION)))
		{
			createOrganizationEventLink();
		}
	}
	
	/** Creates a bi-directional Person-Person Link */
	public void createPersonPersonLink()
	{
		linkManager = new LinkManager();
		linkManager.addPersonPersonLink(parentPerson, linkPerson);
		linkManager.addPersonPersonLink(linkPerson, parentPerson);
		JOptionPane.showMessageDialog(null,
				appBundle.getString("message.link_added.message.text")+
				"\n" + parentPerson.getName().toString() + "\n" + 
				appBundle.getString("message.link_added.and.text") + "\n" +
				linkPerson.getName().toString(),
				appBundle.getString("message.link_added.title.text"),
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** Creates an bi-directional Organization-Organization Link */
	public void createOrganizationOrganizationLink()
	{
		linkManager= new LinkManager();
		linkManager.addOrganizationOrganizationLink(parentOrganization, linkOrganization);
		linkManager.addOrganizationOrganizationLink(linkOrganization, parentOrganization);
		JOptionPane.showMessageDialog(null,
				appBundle.getString("message.link_added.message.text")+
				"\n" + parentOrganization.toString() + "\n" + 
				appBundle.getString("message.link_added.and.text") + "\n" +
				linkOrganization.toString(),
				appBundle.getString("message.link_added.title.text"),
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** Creates an bi-directional Event-Event Link */
	public void createEventEventLink()
	{
		linkManager= new LinkManager();
		linkManager.addEventEventLink(parentEvent, linkEvent);
		linkManager.addEventEventLink(linkEvent, parentEvent);
		JOptionPane.showMessageDialog(null,
				appBundle.getString("message.link_added.message.text")+
				"\n" + parentEvent.getTitle().toString() + "\n" + 
				appBundle.getString("message.link_added.and.text") + "\n" +
				linkEvent.getTitle().toString(),
				appBundle.getString("message.link_added.title.text"),
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** Creates a Link between a Person & Organization */
	public void createPersonOrganizationLink()
	{
		linkManager= new LinkManager();
		if(parentPerson!=null)
		{
			linkManager.addPersonOrganizationLink(parentPerson, linkOrganization);
			JOptionPane.showMessageDialog(null,
					appBundle.getString("message.link_added.message.text")+
					"\n" + parentPerson.getName().toString() + "\n" + 
					appBundle.getString("message.link_added.and.text") + "\n" +
					linkOrganization.toString(),
					appBundle.getString("message.link_added.title.text"),
					JOptionPane.INFORMATION_MESSAGE);
		}//end if
		else 
		{
			linkManager.addPersonOrganizationLink(linkPerson, parentOrganization);
			JOptionPane.showMessageDialog(null,
					appBundle.getString("message.link_added.message.text")+
					"\n" + parentOrganization.toString() + "\n" + 
					appBundle.getString("message.link_added.and.text") + "\n" +
					linkPerson.getName().toString(),
					appBundle.getString("message.link_added.title.text"),
					JOptionPane.INFORMATION_MESSAGE);
		}//end else		
	}

	/** Creates a Link between a Person & Event */
	public void createPersonEventLink()
	{
		linkManager= new LinkManager();
		if(parentPerson!=null)
		{
			linkManager.addPersonEventLink(parentPerson, linkEvent);
			JOptionPane.showMessageDialog(null,
					appBundle.getString("message.link_added.message.text")+
					"\n" + parentPerson.getName().toString() + "\n" + 
					appBundle.getString("message.link_added.and.text") + "\n" +
					linkEvent.getTitle().toString(),
					appBundle.getString("message.link_added.title.text"),
					JOptionPane.INFORMATION_MESSAGE);
		}//end if
		else 
		{
			linkManager.addPersonEventLink(linkPerson, parentEvent);
			JOptionPane.showMessageDialog(null,
					appBundle.getString("message.link_added.message.text")+
					"\n" + parentEvent.getTitle().toString() + "\n" + 
					appBundle.getString("message.link_added.and.text") + "\n" +
					linkPerson.getName().toString(),
					appBundle.getString("message.link_added.title.text"),
					JOptionPane.INFORMATION_MESSAGE);
		}//end else		
	}
	
	/** Creates a Link between an Organization & Event */
	public void createOrganizationEventLink()
	{
		linkManager= new LinkManager();
		if(parentOrganization!=null)
		{
			linkManager.addOrganizationEventLink(parentOrganization, linkEvent);
			JOptionPane.showMessageDialog(null,
					appBundle.getString("message.link_added.message.text")+
					"\n" + parentOrganization.getOrganizationName().toString() + "\n" + 
					appBundle.getString("message.link_added.and.text") + "\n" +
					linkEvent.getTitle().toString(),
					appBundle.getString("message.link_added.title.text"),
					JOptionPane.INFORMATION_MESSAGE);
		}//end if
		else 
		{
			linkManager.addOrganizationEventLink(linkOrganization, parentEvent);
			JOptionPane.showMessageDialog(null,
					appBundle.getString("message.link_added.message.text")+
					"\n" + parentEvent.getTitle().toString() + "\n" + 
					appBundle.getString("message.link_added.and.text") + "\n" +
					linkOrganization.getOrganizationName().toString(),
					appBundle.getString("message.link_added.title.text"),
					JOptionPane.INFORMATION_MESSAGE);
		}//end else		
	}
	public ResourceBundle getAppBundle() {
		return appBundle;
	}

	public void setAppBundle(ResourceBundle appBundle) {
		this.appBundle = appBundle;
	}

	public LinkManager getLinkManager() {
		return linkManager;
	}

	public void setLinkManager(LinkManager linkManager) {
		this.linkManager = linkManager;
	}

	public Organization getLinkOrganization() {
		return linkOrganization;
	}

	public void setLinkOrganization(Organization linkOrganization) {
		this.linkOrganization = linkOrganization;
	}

	public Person getLinkPerson() {
		return linkPerson;
	}

	public void setLinkPerson(Person linkPerson) {
		this.linkPerson = linkPerson;
	}

	public OrganizationMediator getOrgMediator() {
		return orgMediator;
	}

	public void setOrgMediator(OrganizationMediator orgMediator) {
		this.orgMediator = orgMediator;
	}

	public Organization getParentOrganization() {
		return parentOrganization;
	}

	public void setParentOrganization(Organization parentOrganization) {
		this.parentOrganization = parentOrganization;
	}

	public Person getParentPerson() {
		return parentPerson;
	}

	public void setParentPerson(Person parentPerson) {
		this.parentPerson = parentPerson;
	}

	public PersonMediator getPersonMediator() {
		return personMediator;
	}

	public void setPersonMediator(PersonMediator personMediator) {
		this.personMediator = personMediator;
	}

	public JupiterFrame getSearchFrame() {
		return searchFrame;
	}

	public void setSearchFrame(JupiterFrame searchFrame) {
		this.searchFrame = searchFrame;
	}

	public JPanel getSearchPanel() {
		return searchPanel;
	}

	public void setSearchPanel(JPanel searchPanel) {
		this.searchPanel = searchPanel;
	}

	public static String getLink() {
		return Link;
	}

	public static void setLink(String link) {
		Link = link;
	}

	public static String getParent() {
		return Parent;
	}

	public static void setParent(String parent) {
		Parent = parent;
	}

	public EventMediator getEventMediator() {
		return eventMediator;
	}

	public void setEventMediator(EventMediator eventMediator) {
		this.eventMediator = eventMediator;
	}

	public Event getLinkEvent() {
		return linkEvent;
	}

	public void setLinkEvent(Event linkEvent) {
		this.linkEvent = linkEvent;
	}

	public Event getParentEvent() {
		return parentEvent;
	}

	public void setParentEvent(Event parentEvent) {
		this.parentEvent = parentEvent;
	}
	
	
	
	
}
