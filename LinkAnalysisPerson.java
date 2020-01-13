import java.util.List;

//LinkAnalysisPerson.java creates a link analysis of a person selected by a user
public class LinkAnalysisPerson {
	private Person personSelected;
	private Graph graph;
	private GraphPanel graphPanel;
	private List personLinkNodes;
	private LinkManager linkManager;
	public LinkAnalysisPerson(Person personSelected)
	{
		this.personSelected = personSelected;
		linkManager = new LinkManager();			
		List personPersonLinkNodes = linkManager.getPersonPersonLinkNodes(personSelected);
		graph = new Graph();//create a new graph
		graph.setParentPerson(personSelected);//set the parent node in graph
		graph.setPersonLinkNodes(personPersonLinkNodes);//set the link nodes in graph		
		graphPanel = new GraphPanel();
		graphPanel.setGraph(graph);				
		
	}
	
	public Graph getGraph() {
		return graph;
	}
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	public GraphPanel getGraphPanel() {
		return graphPanel;
	}
	public void setGraphPanel(GraphPanel graphPanel) {
		this.graphPanel = graphPanel;
	}
	public LinkManager getLinkManager() {
		return linkManager;
	}
	public void setLinkManager(LinkManager linkManager) {
		this.linkManager = linkManager;
	}
	public List getPersonLinkNodes() {
		return personLinkNodes;
	}
	public void setPersonLinkNodes(List personLinkNodes) {
		this.personLinkNodes = personLinkNodes;
	}
	public Person getPersonSelected() {
		return personSelected;
	}
	public void setPersonSelected(Person personSelected) {
		this.personSelected = personSelected;
	}
	
	
}
