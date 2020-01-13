/** MainFrameBuilder.java uses a ResourceFactory to build the main application window */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainFrameBuilder implements FilePaths {
	//width, height of main window
	private static final Dimension MAINFRAME_DIMENSION  = new Dimension(1000,900);
	private JupiterFrame mf;//main window frame
	private JPanel mp;//main panel to be added to main frame
	
	private ResourceFactory resources;//component factory	
	
	public MainFrameBuilder(){}//Default constructor	
	
	public void build()
	{				
		mf = new JupiterFrame();//create a main frame for resources
		mf.setSize(MAINFRAME_DIMENSION);//set Dimension of main frame
		mf.setLayout(new BorderLayout());		
		
		mp = new JPanel();//create a main panel for toolbar and graph
		mp.setLayout(new BorderLayout());//set Layout for main panel

		//Build main frame		
		addTitle();//add title to main frame
		addMenu();//add a menu bar to the main frame		
		
		//Build main panel				
		addToolBar();//add a toolbar to main panel			
		mf.add(mp);//Add main panel to main frame		
		mf.center();//center main frame on screen
		
		//respond to resizing events
		mf.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				mf.validate();
				mf.repaint();
			}
		});
	}
	
	/** Adds a title to the main frame */
	public void addTitle()
	{
		mf.setTitle(resources.createTitle("app.title.text"));
	}
	
	/** Adds a menu bar to the main frame */
	public void addMenu()
	{				
		mf.add(resources.createMenu(), BorderLayout.PAGE_START);
	}
	
	/** Adds a tool bar to main panel */
	public void addToolBar()
	{				
		mp.add(resources.createToolBar(), BorderLayout.NORTH);	
	}
	
	/** Adds a graph to the main panel */
	public void addGraphPanel(GraphPanel graph)
	{
		mp.add(graph, BorderLayout.CENTER);			
		mp.validate();
		mp.repaint();
	}
	
	/** Removes a graph from the main panel */
	public void removeGraphPanel()
	{
		mp.remove(1);//remove the graphPanel (location 1) from main panel
		mp.validate();
		mp.repaint();
	}
	/*
	public void addLinkReport(List links, String targetName)
	{			
		/*** Code to make a Link Report **
		List personLinks = personManager.getPersonLinks(personSelected);
		mfb.addLinkReport(personLinks, personSelected.getName().toString());					
		
		String reportTitle = new String("Links for:  " + targetName + "\n\n");
		String personTitle = new String("Person(s)\n\n");
		
		List personLinks = new ArrayList();
		personLinks.addAll(links);	
		
		JTextArea textArea = new JTextArea();
		//JTextPane textArea = new JTextPane();
		textArea.setEditable(false);
		textArea.append(reportTitle);
		textArea.append(personTitle);
		
		for (Iterator it = links.iterator();
		it.hasNext();) {
		PersonLink aPersonLink = (PersonLink)it.next();
		textArea.append(aPersonLink.toString());		
		}
		
		graphScrollPane = new JScrollPane(textArea);
		mp.add(graphScrollPane, BorderLayout.CENTER);		
		mp.revalidate();
		mp.repaint();
	}
	*/	
	
	public static Dimension getMAINFRAME_DIMENSION() {
		return MAINFRAME_DIMENSION;
	}

	public JupiterFrame getMf() {
		return mf;
	}

	public void setMf(JupiterFrame mf) {
		this.mf = mf;
	}

	public JPanel getMp() {
		return mp;
	}

	public void setMp(JPanel mp) {
		this.mp = mp;
	}

	public ResourceFactory getResources() {
		return resources;
	}

	public void setResources(ResourceFactory resources) {
		this.resources = resources;
	}
	
}
