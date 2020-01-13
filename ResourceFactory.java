//ResourceFactory.java creates and maintains all resources needed for the application
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Enumeration;
import java.awt.Dimension;
import java.util.Collections;
public class ResourceFactory implements FilePaths {
	protected ResourceBundle appBundle, countriesBundle, USStatesBundle;
	protected Action linkAnalysisAction, openAction, saveAction, printAction,
					exitAction, manageAccountsAction, manageStoredDataAction,
					helpContentsAction, aboutAction;
	protected ArrayList countries;
	protected ArrayList USStates;
	private JupiterFrame mainFrame;
	private MainFrameBuilder mfb;
	private boolean isModified;//desktop modified
	private Graph graph;
	private GraphPanel graphPanel;	
	protected PersonMediator personMediator;
	protected ManageDataMediator manageDataMediator;
	protected OrganizationMediator orgMediator;
	protected EventMediator eventMediator;
	//protected AddressMediator addressMediator;	
	//protected PhoneMediator phoneMediator;
	//protected PhoneCallMediator phoneCallMediator;		
	
	public ResourceFactory(){}//Default constructor			
		
	public void createResources(ResourceBundle appBundle,
			ResourceBundle countriesBundle,
			ResourceBundle USStatesBundle)
	{
		this.appBundle = appBundle;
		this.countriesBundle = countriesBundle;
		this.USStatesBundle = USStatesBundle;			
		createMainResources();		
	}//end createResources()
	
	public void createMainResources()
	{		
		try {
			
		countries = createCountryStrings();
		//USStates = createUSStateStrings();
		
		linkAnalysisAction = new LinkAnalysisAction(appBundle.getString(
		"file.new.link_analysis" + ".text"), createIcon(ICON_LINK_ANALYSIS),
		appBundle.getString("file.new.link_analysis" + ".mnemonic"));

		openAction = new OpenAction(appBundle.getString("file.open" + ".text"),
		createIcon(ICON_OPEN), appBundle.getString("file.open" + ".mnemonic"));

		saveAction = new SaveAction(appBundle.getString("file.save" + ".text"),
		createIcon(ICON_SAVE), appBundle.getString("file.save" + ".mnemonic"));

		printAction = new PrintAction(appBundle.getString("file.print" +
		".text"), createIcon(ICON_PRINT), appBundle.getString("file.print" +
		".mnemonic"));

		exitAction = new ExitAction(appBundle.getString("file.exit" + ".text"),
		appBundle.getString("file.exit" + ".mnemonic"));
		
		manageAccountsAction = new ManageAccountsAction(appBundle.getString(
		"manage.accounts" + ".text"), appBundle.getString("manage.accounts" +
		".mnemonic"));
		
		manageStoredDataAction = new ManageStoredDataAction(
		appBundle.getString("manage.stored_data" + ".text"),
		appBundle.getString("manage.stored_data" + ".mnemonic"));
		
		helpContentsAction = new HelpContentsAction(appBundle.getString(
		"help.help_contents" + ".text"), createIcon(ICON_HELP), 
		appBundle.getString("help.help_contents" + ".mnemonic"));

		aboutAction = new AboutAction(appBundle.getString("help.about" +
		".text"), appBundle.getString("help.about" + ".mnemonic"));
		}
		catch (MissingResourceException ex)
		{
			JOptionPane.showMessageDialog(null, ((appBundle.getString(
			"exception.missing_resource_message.text") + "\n" +
			ex.getMessage())), appBundle.getString(
			"exception.missing_resource_title.text"), 
			JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}	
		catch (NullPointerException ex)
		{
			JOptionPane.showMessageDialog(null, ((appBundle.getString(
			"exception.null_pointer.message") + "\n" + ex.getMessage())), 
			appBundle.getString("exception.null_pointer.title"),
			JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}		
		catch (ClassCastException ex)
		{
			//Shown if the object found for the given key is not a string
			//exception is thrown while accessing one of the keys in a
			//resource bundle
			JOptionPane.showMessageDialog(null, ((appBundle.getString(
			"exception.class_cast.message") + "\n" + ex.getMessage())), 
			appBundle.getString("exception.class_cast.title"),
			JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}//end try
	}//end createMainResources()
	
	public JupiterFrame createLoginWindow()
	{				
		String lblUsernameTxt = appBundle.getString("user.username.text");
		String lblPasswordTxt = appBundle.getString("user.password.text");
		String btnHelpTxt = appBundle.getString("help.text");
		String btnLoginTxt = appBundle.getString("login.text");	
		String frameTitle = createTitle("login.frame_title.text");		
		
		LogInJPanel loginPanel = new LogInJPanel(createIcon(ICON_SPLASH),
		lblUsernameTxt, lblPasswordTxt, btnLoginTxt, helpContentsAction,
		btnHelpTxt);
		enterPressesWhenFocused(loginPanel.getBtnHelp());
		enterPressesWhenFocused(loginPanel.getBtnLogIn());	
		JupiterFrame loginFrame = new JupiterFrame(frameTitle, loginPanel);
		loginFrame.setResizable(false);
		loginFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent event)
			{
				System.exit(0);
			}
		});
		return loginFrame;				
	}//end createLoginWindow()
	
	public JupiterFrame createMainWindow()
	{
		mfb = new MainFrameBuilder();
		mfb.setResources(this);
		mfb.build();
		mainFrame = mfb.getMf();//set this mainFrame
		mainFrame.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e)
		{			
			if(!isModified)//if graph is not modified
			{
				System.exit(0);//exit program
			}
			else if(isModified)
			{
				int n = JOptionPane.showConfirmDialog(mainFrame,
						appBundle.getString("message.exit_app.text"),
						appBundle.getString("message.exit_app.title.text"),
						JOptionPane.YES_NO_CANCEL_OPTION);
		        if (n == JOptionPane.YES_OPTION) {
		            //Save Action;
		        } 
		        else if(n == JOptionPane.NO_OPTION) {
		        	System.exit(0);
		        }
			}
		}
		});
		return mfb.getMf();
	}//end createMainWindow()
	
	public ArrayList createCountryStrings()
	{
		countries = new ArrayList();
		Enumeration bundleKeys = countriesBundle.getKeys();
		String key = null;
		while (bundleKeys.hasMoreElements()) {
			key = (String)bundleKeys.nextElement();
		    String value = countriesBundle.getString(key);
		    countries.add(value);	
		    Collections.sort(countries);
		}
        return countries;
	}
        
    public ArrayList createUSStateStrings()
    {
    	USStates = new ArrayList();
		Enumeration bundleKeys = USStatesBundle.getKeys();
        while (bundleKeys.hasMoreElements()) {
            String key = (String)bundleKeys.nextElement();
            String value = USStatesBundle.getString(key);
            USStates.add(value);
            Collections.sort(USStates);
        }
        return USStates;    	
    }
	public JPanel createNamePanel()
	{		
		String title = appBundle.getString("name.border_title.text");	
		NameJPanel namePanels = new NameJPanel(appBundle);	
		namePanels.setBorder(BorderFactory.createTitledBorder(title));		
		return namePanels;
	}
	public JPanel createGenderPanel()
	{
		String gender = appBundle.getString("person.gender.text");
		String male = appBundle.getString("person.gender.male.text");
		String female = appBundle.getString("person.gender.female.text");
		GenderJPanel genderPanel = new GenderJPanel(gender, male, female);
		return genderPanel;
	}
	
	public JPanel createRacePanel()
	{
		String race = appBundle.getString("person.race.text");
		String asian = appBundle.getString("person.race.asian.text");
		String black = appBundle.getString("person.race.black.text");
		String hispanic = appBundle.getString("person.race.hispanic.text");
		String indian = appBundle.getString("person.race.indian.text");
		String white = appBundle.getString("person.race.white.text");
		String unknown = appBundle.getString("person.race.unknown.text");		
		RaceJPanel racePanel = new RaceJPanel(race, asian, black, hispanic, indian,
												white, unknown);
		return racePanel;
	}
	
	public JPanel createDatePanel(String lblText)
	{
		DateJPanel dobPanel = new DateJPanel(lblText);
		return dobPanel;
	}
	
	public JPanel createCountryPanel()
	{
		String txtCountry = appBundle.getString("address.country.text");
		CountryJPanel countryPanel = new CountryJPanel(txtCountry, countries);
		return countryPanel;
	}
	
	public JPanel createAddressPanel()
	{			    
		String txtStreet = appBundle.getString("address.street.text");
		String txtCity = appBundle.getString("address.city.text");
		String txtState = appBundle.getString("address.state.text");
		String txtZipcode = appBundle.getString("address.zip_code.text");
		
		JPanel countryPanel = createCountryPanel();
		JPanel buttonPanel = createFunctionButtonPanel();
		AddressJPanel addressPanel = new AddressJPanel(countryPanel, txtStreet, txtCity,
													txtState, txtZipcode, buttonPanel);
		//addressMediator = new AddressMediator(addressPanel, appBundle);
		return addressPanel;
	}
	
	public JPanel createPersonPanel()
	{
		String title = appBundle.getString("person.border_title.text");
		String txtDOB = appBundle.getString("person.date_of_birth.text");
		JPanel namePanel = createNamePanel();
		JPanel genderPanel = createGenderPanel();
		JPanel racePanel = createRacePanel();
		JPanel dobPanel = createDatePanel(txtDOB);
		//JPanel addressPanel = createAddressPanel();		
		JPanel buttonPanel = createFunctionButtonPanel();
		PersonJPanel personPanel = new PersonJPanel(title, namePanel, genderPanel, racePanel,
													dobPanel, buttonPanel);//addressPanel,
		personMediator = new PersonMediator(personPanel, appBundle);
		return personPanel;
	}
	
	public JPanel createOrganizationPanel()
	{
		String title = appBundle.getString("organization.border_title.text");
		String txtName = appBundle.getString("organization.name.text");
		JPanel buttonPanel = createFunctionButtonPanel();
		OrganizationJPanel orgPanel = new OrganizationJPanel(title, txtName, buttonPanel);
		orgMediator = new OrganizationMediator(orgPanel, appBundle);
		return orgPanel;
		
	}
	
	public JPanel createEventPanel()
	{
		String txtTitle = appBundle.getString("event.title.text");
		String txtDescription = appBundle.getString("event.description.text");
		String txtDate = appBundle.getString("event.date.text");
		JPanel datePanel = createDatePanel(txtDate);
		JPanel buttonPanel = createFunctionButtonPanel();
		EventJPanel eventPanel = new EventJPanel(txtTitle, txtDescription, datePanel, buttonPanel);
		eventMediator = new EventMediator(eventPanel, appBundle);
		return eventPanel;
	}
	
	public JPanel createFunctionButtonPanel()
	{
		String txtSearch = appBundle.getString("function.search.text");
		String txtAdd = appBundle.getString("function.add.text");
		String txtEdit = appBundle.getString("function.edit.text");
		String txtDelete = appBundle.getString("function.delete.text");	
		String txtHelp = appBundle.getString("help.text");
		FunctionButtonJPanel functionButtons = new FunctionButtonJPanel(helpContentsAction,
		txtSearch, txtAdd, txtEdit, txtDelete, txtHelp);
		enterPressesWhenFocused(functionButtons.getBtnSearch());
		enterPressesWhenFocused(functionButtons.getBtnAdd());
		enterPressesWhenFocused(functionButtons.getBtnEdit());
		enterPressesWhenFocused(functionButtons.getBtnDelete());
		enterPressesWhenFocused(functionButtons.getBtnHelp());		
		return functionButtons;
	}
	public JPanel createEntitySearchPanel()
	{		
		String personTitle = appBundle.getString("person.border_title.text");
		JPanel personPanel = createPersonPanel();		
		((PersonJPanel)personPanel).getButtonPanel().searchMode();
		
		String organizationTitle = appBundle.getString("organization.border_title.text");
		JPanel organizationPanel = createOrganizationPanel();
		((OrganizationJPanel)organizationPanel).getButtonPanel().searchMode();
		
		String eventTitle = appBundle.getString("event.border_title.text");
		JPanel eventPanel = createEventPanel();
		((EventJPanel)eventPanel).getButtonPanel().searchMode();
		
		String addressTitle = appBundle.getString("address.border_title.text");
		JPanel addressPanel = createAddressPanel();
		((AddressJPanel)addressPanel).getButtonPanel().searchMode();

		JPanel tabbedLAPanel = new EntityTabbedPane(personTitle, personPanel, organizationTitle, organizationPanel,
				eventTitle, eventPanel, addressTitle, addressPanel);
		return tabbedLAPanel;		
	}
	
	public JPanel createManageTypePanel()
	{
		String txtEditDelete = appBundle.getString("manage.edit_delete.text");
		String txtAddRecord = appBundle.getString("manage.add_record.text");
		String txtAddLink = appBundle.getString("manage.add_link.text");
		ManageDataJPanel managePanel = new ManageDataJPanel(txtEditDelete, txtAddRecord, txtAddLink);
		manageDataMediator = new ManageDataMediator(appBundle, managePanel);				
		return managePanel;
	}
	
	public JPanel createManageDataPanel()
	{
		String personTitle = appBundle.getString("person.border_title.text");
		JPanel personPanel = createPersonPanel();		
		((PersonJPanel)personPanel).getButtonPanel().manageDataMode();
		
		String organizationTitle = appBundle.getString("organization.border_title.text");
		JPanel organizationPanel = createOrganizationPanel();
		((OrganizationJPanel)organizationPanel).getButtonPanel().manageDataMode();
		
		String eventTitle = appBundle.getString("event.border_title.text");
		JPanel eventPanel = createEventPanel();
		((EventJPanel)eventPanel).getButtonPanel().manageDataMode();
		
		String addressTitle = appBundle.getString("address.border_title.text");
		JPanel addressPanel = createAddressPanel();
		((AddressJPanel)addressPanel).getButtonPanel().manageDataMode();
		
		JPanel tabbedLAPanel = new EntityTabbedPane(personTitle, personPanel, organizationTitle, organizationPanel,
				eventTitle, eventPanel, addressTitle, addressPanel);
		
		return tabbedLAPanel;
	}
	public String createTitle(String key)
	{
		String title = appBundle.getString(key);
		return title;
	}
	
	public ImageIcon createIcon(String iconPath)
	{		
		String path = iconPath;
		ImageIcon icon = new ImageIcon(path);
		return icon;
	}	
	
	public JMenuBar createMenu()
	{		
		JMenuBar menuBar = new JMenuBar();			
		JMenu fileMenu, newMenu, manageMenu, helpMenu;			
		JMenuItem linkAnalysis, open, save,	print, exit,
					manageAccounts, manageStoredData, helpContents, about;	
		
		// Create menus			
		fileMenu = new JMenu();
		newMenu = new JMenu();		
		manageMenu = new JMenu();
		helpMenu = new JMenu();	
		
		fileMenu.setOpaque(true);
		newMenu.setOpaque(true);
		manageMenu.setOpaque(true);
		helpMenu.setOpaque(true);
		
		linkAnalysis = new JMenuItem(linkAnalysisAction);
		linkAnalysis.setToolTipText(null);
		linkAnalysis.setIcon(null);					
			
		open = new JMenuItem(openAction);
		open.setIcon(null);		
		open.setToolTipText(null);	
		
		save = new JMenuItem(saveAction);
		save.setIcon(null);
		save.setToolTipText(null);		
		
		print = new JMenuItem(printAction);
		print.setIcon(null);
		print.setToolTipText(null);	
		
		exit = new JMenuItem(exitAction);
		exit.setToolTipText(null);				
		
		manageAccounts = new JMenuItem(manageAccountsAction);
		manageAccounts.setToolTipText(null);
		
		manageStoredData = new JMenuItem(manageStoredDataAction);
		manageStoredData.setToolTipText(null);
		
		helpContents = new JMenuItem(helpContentsAction);
		helpContents.setIcon(null);
		helpContents.setToolTipText(null);
		
		about = new JMenuItem(aboutAction);
		about.setToolTipText(null);		
		
		// Set menu text 
		fileMenu.setText(appBundle.getString("file" + ".text"));				
		newMenu.setText(appBundle.getString("file.new" + ".text"));		
		manageMenu.setText(appBundle.getString("manage" + ".text"));		
		helpMenu.setText(appBundle.getString("help" + ".text"));		
			
		try {
		//Set accelerators(Ctrl-key + letter) and mnemonics(Alt-key + letter)
		linkAnalysis.setAccelerator(KeyStroke.getKeyStroke(appBundle.getString(
					"file.new.link_analysis" + ".accelerator")));
		open.setAccelerator(KeyStroke.getKeyStroke(appBundle.getString(
					"file.open" + ".accelerator")));
		save.setAccelerator(KeyStroke.getKeyStroke(appBundle.getString(
					"file.save" + ".accelerator")));
		print.setAccelerator(KeyStroke.getKeyStroke(appBundle.getString(
					"file.print" + ".accelerator")));
		exit.setAccelerator(KeyStroke.getKeyStroke(appBundle.getString(
					"file.exit" + ".accelerator")));		
		manageAccounts.setAccelerator(KeyStroke.getKeyStroke(appBundle.getString(
				"manage.accounts" + ".accelerator")));	
		manageStoredData.setAccelerator(KeyStroke.getKeyStroke(appBundle.getString(
				"help.help_contents" + ".accelerator")));	
		helpContents.setAccelerator(KeyStroke.getKeyStroke(appBundle.getString(
					"manage.stored_data" + ".accelerator")));	
		
		fileMenu.setMnemonic(appBundle.getString("file" + ".mnemonic").charAt(0));
		newMenu.setMnemonic(appBundle.getString("file.new" + ".mnemonic").charAt(0));
		manageMenu.setMnemonic(appBundle.getString("manage" + ".mnemonic").charAt(0));
		helpMenu.setMnemonic(appBundle.getString("help" + ".mnemonic").charAt(0));		
		}
		catch (MissingResourceException ex)
		{
			//ok not to set Accelerators and/or Mnemonics
		}
		
		// Construct menus
		fileMenu.add(newMenu);
		newMenu.add(linkAnalysis);	
		fileMenu.add(open);
		fileMenu.addSeparator();
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(print);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		manageMenu.add(manageAccounts);
		manageMenu.add(manageStoredData);
		helpMenu.add(helpContents);
		helpMenu.add(about);
		
		// Add menus to toolbar
		menuBar.add(fileMenu);
		menuBar.add(manageMenu);
		menuBar.add(helpMenu);
		
		return menuBar;
	}
	
	public JToolBar createToolBar()
	{		
		Border border = BorderFactory.createEtchedBorder(
				EtchedBorder.LOWERED); 
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBorder(border);
		
		JButton btnOpen, btnLinkAnalysis, btnPrint, btnSave, btnHelp;
		
		btnOpen= new JButton(openAction);
		btnOpen.setText("");
		enterPressesWhenFocused(btnOpen);
		
		btnLinkAnalysis = new JButton(linkAnalysisAction);	
		btnLinkAnalysis.setText("");		
		enterPressesWhenFocused(btnLinkAnalysis);
		
		btnPrint = new JButton(printAction);
		btnPrint.setText("");		
		enterPressesWhenFocused(btnPrint);
		
		btnSave = new JButton(saveAction);	    
	    btnSave.setText("");	
	    enterPressesWhenFocused(btnSave);
	    
	    btnHelp = new JButton(helpContentsAction);
	    btnHelp.setText("");
	    enterPressesWhenFocused(btnHelp);
	    
	    toolBar.add(btnOpen);
	    toolBar.add(btnLinkAnalysis);
	    toolBar.addSeparator();
	    toolBar.add(btnPrint);
	    toolBar.add(btnSave);
	    toolBar.addSeparator();
	    toolBar.add(btnHelp);
	    
		return toolBar;
	}
	
	public void configureActions(String userType)
	{
		if (userType.equals("Administrator"))
		{
			//Enable Administrator menu items (Manage... Accounts, Stored Data)
			this.getManageAccountsAction().setEnabled(true);
			this.getManageStoredDataAction().setEnabled(true);
		}
		else return;//leave default menu settings
	}
	
	public void setUserAccess(String userType)
	{
		if (!(userType.equals("Administrator")))
			return;
		else
		{
			manageAccountsAction.setEnabled(true);
			manageStoredDataAction.setEnabled(true);
		}
	}
    
    //Enables a button to be activated by pressing keyboard "Enter"
	//button or spacebar
	public static void enterPressesWhenFocused(JButton button)
	{		
	    button.registerKeyboardAction(
	        button.getActionForKeyStroke(
	            KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)), 
	            KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), 
	            JComponent.WHEN_FOCUSED);
	           
	    button.registerKeyboardAction(
	        button.getActionForKeyStroke(
	            KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)), 
	            KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), 
	            JComponent.WHEN_FOCUSED);
	}
	
	public class LinkAnalysisAction extends AbstractAction {
		private JupiterFrame LAFrame;
		private Person personSelected;
		private Organization orgSelected;
		private Event eventSelected;
		private LinkManager linkManager;
		public LinkAnalysisAction(String text, ImageIcon icon, String mnemonic)
		{
			super(text,icon);		
			putValue(MNEMONIC_KEY, new Integer(mnemonic.charAt(0)));
			putValue(Action.SHORT_DESCRIPTION, "New Link Analysis...");
		}
		public void actionPerformed(ActionEvent e)
		{			
			if (isModified())//of graph is modified
			{
				int n = JOptionPane.showConfirmDialog(mainFrame,
						appBundle.getString("message.exit_app.text"),
						appBundle.getString("message.exit_app.title.text"),
						JOptionPane.YES_NO_CANCEL_OPTION);
			    if (n == JOptionPane.YES_OPTION)
			    {
			    	//Save Graph 
			    	//mfb.removeGraphPanel();
			    }//end if Save Graph is YES
			    else if (n == JOptionPane.NO_OPTION)
			    {
			    	mfb.removeGraphPanel();//remove current graph shown
			    }//end if Save Graph is NO							
			}//end if isModified
			startLinkAnalysis();		
		}//end actionPerformed
		
		public void startLinkAnalysis()
		{
			JPanel LAPanel = createEntitySearchPanel();//LINK ANALYSIS PANEL
			String frameTitle = appBundle.getString("link_analysis.frame_title.text");			
			LAFrame = new JupiterFrame(frameTitle, LAPanel);//LINK ANALYSIS FRAME
			LAFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			LAFrame.setResizable(false);
			LAFrame.setVisible(true);
			personMediator.setActionFrame(LAFrame);			
			orgMediator.setActionFrame(LAFrame);
			eventMediator.setActionFrame(LAFrame);
			//addressMediator.setActionFrame(LAFrame);
			//phoneMediator.setActionFrame(LAFrame);
			LAFrame.addWindowListener(new WindowAdapter(){
			public void windowClosed(WindowEvent e){
				mainFrame.repaint();//removes the shaded area from the frame
				if (personMediator.isPersonSelected())//if Person is selected
				{										
					personSelected = personMediator.getP();	
					personMediator.setPersonSelected(false);//reset personSelected
					graph = new Graph();//create a new graph
					//make personSelected the parent Node in the Graph
					Node parentNode = new Node();
					parentNode.setId(personSelected.getId());
					parentNode.setTYPE(Node.PERSON);
					parentNode.setText(personSelected.getName().toString());
					linkManager = new LinkManager();//find links to personSelected			
					List personPersonLinkNodes = linkManager.
									getPersonPersonLinkNodes(personSelected);
					List personOrganizationLinkNodes = linkManager.
									getPersonOrganizationLinkNodes(personSelected);
					List personEventLinkNodes = linkManager.getPersonEventLinkNodes(
									personSelected);
					graph.setParentNode(parentNode);
					//set the link nodes in graph	
					graph.setPersonLinkNodes(personPersonLinkNodes);
					graph.setOrganizationLinkNodes(personOrganizationLinkNodes);
					graph.setEventLinkNodes(personEventLinkNodes);
					graphPanel = new GraphPanel();
					graphPanel.setGraph(graph);	
					mfb.addGraphPanel(graphPanel);
					mainFrame.validate();
					mainFrame.repaint();
					setModified(true);//graph window is now modified
				}//end if personSelected	
				else if (orgMediator.isOrgSelected())//if Organization is selected
				{										
					orgSelected = orgMediator.getOrg();
					orgMediator.setOrgSelected(false);//reset orgSelected
					graph = new Graph();//create a new graph
					//make orgSelected the parent Node in the Graph
					Node parentNode = new Node();
					parentNode.setId(orgSelected.getId());
					parentNode.setTYPE(Node.ORGANIZATION);
					parentNode.setText(orgSelected.toString());
					linkManager = new LinkManager();//find links to personSelected			
					List orgOrgLinkNodes = linkManager.getOrganizationOrganizationLinkNodes(orgSelected);
					List orgPersonLinkNodes = linkManager.
									getOrganizationPersonLinkNodes(orgSelected);
					List orgEventLinkNodes = linkManager.getOrganizationEventLinkNodes(
									orgSelected);
					graph.setParentNode(parentNode);
					//set the link nodes in graph	
					graph.setPersonLinkNodes(orgPersonLinkNodes);
					graph.setOrganizationLinkNodes(orgOrgLinkNodes);
					graph.setEventLinkNodes(orgEventLinkNodes);
					graphPanel = new GraphPanel();
					graphPanel.setGraph(graph);	
					mfb.addGraphPanel(graphPanel);
					mainFrame.validate();
					mainFrame.repaint();
					setModified(true);//graph window is now modified
				}//end if orgSelected
				else if (eventMediator.isEventSelected())//if Event is selected
				{										
					eventSelected = eventMediator.getAnEvent();
					eventMediator.setEventSelected(false);//reset eventSelected
					graph = new Graph();//create a new graph
					//make eventSelected the parent Node in the Graph
					Node parentNode = new Node();
					parentNode.setId(eventSelected.getId());
					parentNode.setTYPE(Node.EVENT);
					parentNode.setText(eventSelected.getTitle().toString());
					linkManager = new LinkManager();//find links to personSelected			
					List eventOrgLinkNodes = linkManager.getEventOrganizationLinkNodes(
							eventSelected);
					List eventPersonLinkNodes = linkManager.
									getEventPersonLinkNodes(eventSelected);
					List eventEventLinkNodes = linkManager.getEventEventLinkNodes(
									eventSelected);
					graph.setParentNode(parentNode);
					//set the link nodes in graph	
					graph.setPersonLinkNodes(eventPersonLinkNodes);
					graph.setOrganizationLinkNodes(eventOrgLinkNodes);
					graph.setEventLinkNodes(eventEventLinkNodes);
					graphPanel = new GraphPanel();
					graphPanel.setGraph(graph);	
					mfb.addGraphPanel(graphPanel);
					mainFrame.validate();
					mainFrame.repaint();
					setModified(true);//graph window is now modified
				}//end if eventSelected
			}});//end addWindowListener windowClosed 	
		}
	}//end LinkAnalysisAction
	
	public class OpenAction extends AbstractAction {
		public OpenAction(String text, ImageIcon icon, String mnemonic)
		{
			super(text,icon);		
			putValue(MNEMONIC_KEY, new Integer(mnemonic.charAt(0)));
			putValue(Action.SHORT_DESCRIPTION, text);
		}
		public void actionPerformed(ActionEvent e)
		{
			//Open a graph file
		}		
	}	
	
	public class SaveAction extends AbstractAction {
		public SaveAction(String text, ImageIcon icon, String mnemonic)
		{
			super(text,icon);		
			putValue(MNEMONIC_KEY, new Integer(mnemonic.charAt(0)));
			putValue(Action.SHORT_DESCRIPTION, text);
			setEnabled(true);//ENABLED FOR TESTING Disabled when graph is null
		}
		public void actionPerformed(ActionEvent e)
		{
			//get GraphFrame
			//Save File
		}		
	}	
	
	public class PrintAction extends AbstractAction {
		public PrintAction(String text, ImageIcon icon, String mnemonic)
		{
			super(text,icon);		
			putValue(MNEMONIC_KEY, new Integer(mnemonic.charAt(0)));
			putValue(Action.SHORT_DESCRIPTION, text);
			setEnabled(true);//ENABLED FOR TESTING Disabled when graph is null
		}
		public void actionPerformed(ActionEvent e)
		{
			//Print a graph
		}		
	}	
	
	public class ExitAction extends AbstractAction {
		public ExitAction(String text, String mnemonic)
		{
			putValue(Action.NAME, text);
			putValue(MNEMONIC_KEY, new Integer(mnemonic.charAt(0)));			
		}
		public void actionPerformed(ActionEvent e)
		{
			if (!isModified())
			{
				System.exit(0);
			}//end if graph !isModified
			else if (isModified())
			{
				int n = JOptionPane.showConfirmDialog(mainFrame,
						appBundle.getString("message.exit_app.text"),
						appBundle.getString("message.exit_app.title.text"),
						JOptionPane.YES_NO_CANCEL_OPTION);
			    if (n == JOptionPane.YES_OPTION)
			    {
			    	//Save Graph 
			    }//end if Save Graph is YES
			    else if (n == JOptionPane.NO_OPTION)
			    {
			    	System.exit(0);
			    }//end if Save Graph is NO							
			}//end if isModified			
		}//end ExitAction actionPerformed			
	}//end inner-class ExitAction
	
	public class ManageAccountsAction extends AbstractAction {
		public ManageAccountsAction(String text, String mnemonic)
		{
			putValue(Action.NAME, text);
			putValue(MNEMONIC_KEY, new Integer(mnemonic.charAt(0)));
			setEnabled(false);//Must be Administrator to enable
		}
		public void actionPerformed(ActionEvent e)
		{
			//Manage user accounts
		}
	}//end inner-class ManageAccountsAction
	
	public class ManageStoredDataAction extends AbstractAction {
		private JupiterFrame manageDataFrame;
		public ManageStoredDataAction(String text, String mnemonic)
		{
			putValue(Action.NAME, text);
			putValue(MNEMONIC_KEY, new Integer(mnemonic.charAt(0)));
			setEnabled(false);//Must be Administrator to enable
		}
		public void actionPerformed(ActionEvent e)
		{
			String managerFrameTitle = appBundle.getString("manage.frame_title.text");		
			//Edit/Delete a Record, Add a Record, Add a Link
			JPanel manageTypePanel = createManageTypePanel();			
			manageDataFrame = new JupiterFrame(managerFrameTitle, manageTypePanel);
			manageDataFrame.setSize(new Dimension(250,130));//width,height
			manageDataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			manageDataFrame.setResizable(false);
			manageDataFrame.setVisible(true);
			manageDataMediator.setManagerFrame(manageDataFrame);			
			manageDataFrame.addWindowListener(new WindowAdapter(){
				public void windowClosed(WindowEvent e){
					if (manageDataMediator.isAddLink())//Add a link
					{
						JPanel searchPanel = createEntitySearchPanel();
						new LinkCreator(appBundle, searchPanel, personMediator,
								orgMediator, eventMediator);
						
					}//end if (manageDataMediator.isAddLink())					
					else if (manageDataMediator.isAddRecord())//Add a record
					{
						JPanel addRecordPanel = createManageDataPanel();						
						String frameTitle = appBundle.getString("manage.add_record.text");			
						JupiterFrame addRecordFrame = new JupiterFrame(frameTitle, addRecordPanel);
						addRecordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
						addRecordFrame.setResizable(false);
						addRecordFrame.setVisible(true);
						personMediator.setActionFrame(addRecordFrame);			
						orgMediator.setActionFrame(addRecordFrame);
						eventMediator.setActionFrame(addRecordFrame);
						//addressMediator.setLAFrame(LAFrame);
						//phoneMediator.setLAFrame(LAFrame);
						
					}//end if manageDataMediator.isAddRecord()
				}//end manageDataFrame windowClosed
				});//end manageDataFrame add WindowListener		
		}//end ActionPerformed
	}//end inner class ManageStoredDataAction
	
	public class HelpContentsAction extends AbstractAction {
		public HelpContentsAction(String text, ImageIcon icon, String mnemonic)
		{
			super(text,icon);		
			putValue(MNEMONIC_KEY, new Integer(mnemonic.charAt(0)));
			putValue(Action.SHORT_DESCRIPTION, text);
		}
		public void actionPerformed(ActionEvent e)
		{
			String helpFrameTitle = appBundle.getString("help.frame_title.text");
			JPanel helpPanel = new HelpJPanel();
			JupiterFrame helpFrame = new JupiterFrame(helpFrameTitle, helpPanel);
			helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			helpFrame.setResizable(false);
			helpFrame.setVisible(true);
		}		
	}	
	
	public class AboutAction extends AbstractAction {
		public AboutAction(String text, String mnemonic)
		{
			putValue(Action.NAME, text);
			putValue(MNEMONIC_KEY, new Integer(mnemonic.charAt(0)));
		}
		public void actionPerformed(ActionEvent e)
		{
			//show about Dialog
		}		
	}

	public Action getAboutAction() {
		return aboutAction;
	}

	public void setAboutAction(Action aboutAction) {
		this.aboutAction = aboutAction;
	}

	public ResourceBundle getAppBundle() {
		return appBundle;
	}

	public void setAppBundle(ResourceBundle appBundle) {
		this.appBundle = appBundle;
	}

	public ResourceBundle getCountriesBundle() {
		return countriesBundle;
	}

	public void setCountriesBundle(ResourceBundle countriesBundle) {
		this.countriesBundle = countriesBundle;
	}

	public Action getExitAction() {
		return exitAction;
	}

	public void setExitAction(Action exitAction) {
		this.exitAction = exitAction;
	}

	public Action getHelpContentsAction() {
		return helpContentsAction;
	}

	public void setHelpContentsAction(Action helpContentsAction) {
		this.helpContentsAction = helpContentsAction;
	}

	public Action getLinkAnalysisAction() {
		return linkAnalysisAction;
	}

	public void setLinkAnalysisAction(Action linkAnalysisAction) {
		this.linkAnalysisAction = linkAnalysisAction;
	}

	public Action getOpenAction() {
		return openAction;
	}

	public void setOpenAction(Action openAction) {
		this.openAction = openAction;
	}

	public Action getPrintAction() {
		return printAction;
	}

	public void setPrintAction(Action printAction) {
		this.printAction = printAction;
	}

	public Action getSaveAction() {
		return saveAction;
	}

	public void setSaveAction(Action saveAction) {
		this.saveAction = saveAction;
	}

	public ResourceBundle getUSStatesBundle() {
		return USStatesBundle;
	}

	public void setUSStatesBundle(ResourceBundle statesBundle) {
		USStatesBundle = statesBundle;
	}

	public Action getManageAccountsAction() {
		return manageAccountsAction;
	}

	public void setManageAccountsAction(Action manageAccountsAction) {
		this.manageAccountsAction = manageAccountsAction;
	}

	public Action getManageStoredDataAction() {
		return manageStoredDataAction;
	}

	public void setManageStoredDataAction(Action manageStoredDataAction) {
		this.manageStoredDataAction = manageStoredDataAction;
	}

	public ArrayList getCountries() {
		return countries;
	}

	public void setCountries(ArrayList countries) {
		this.countries = countries;
	}

	public ArrayList getUSStates() {
		return USStates;
	}

	public void setUSStates(ArrayList states) {
		USStates = states;
	}

	public boolean isModified() {
		return isModified;
	}

	public void setModified(boolean isModified) {
		this.isModified = isModified;
	}

	public JupiterFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JupiterFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public MainFrameBuilder getMfb() {
		return mfb;
	}

	public void setMfb(MainFrameBuilder mfb) {
		this.mfb = mfb;
	}

	public PersonMediator getPersonMediator() {
		return personMediator;
	}

	public void setPersonMediator(PersonMediator personMediator) {
		this.personMediator = personMediator;
	}
	
	
}
