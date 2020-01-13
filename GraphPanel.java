//GraphPanel.java is a panel used to hold a Graph object
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
public class GraphPanel extends JPanel {//implements MouseListener
	private Graph graph;
	private JScrollPane graphScrollPane = new JScrollPane();
	public GraphPanel()
	{
		super(new BorderLayout());	
		setOpaque(true);
		//listen for re-sizing events on this panel
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				validate();
				repaint();
			}
		});
		
		//add mouse listener		
		//public void mouseClicked(MouseEvent e){ graph.revalidate(); graph.repaint();}..		
	}
	
	public Graph getGraph() {
		return graph;
	}
	
	/** Sets a graph into a JScrollPane and add them to this panel.
	 *  Pre-condition:  Graph is not null
	 * @param aGraph
	 */
	public void setGraph(Graph aGraph) {		
		this.graph = aGraph;	
		//Create the scroll pane and add the graph to it
		graphScrollPane = new JScrollPane(graph);
		graphScrollPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		graphScrollPane.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(graphScrollPane, BorderLayout.CENTER);
		setOpaque(true);//content pane must be opaque		
		validate();
	    repaint();
	}
	
}
