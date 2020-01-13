import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.File;

public class GraphFrame extends JInternalFrame {
	private GraphPanel graphPanel;
	private Graph graph;
	private File file;
	
	public GraphFrame(Graph aGraph)
	{
		graph = aGraph;
		graphPanel = new GraphPanel();
		Container contentPane = getContentPane();
		contentPane.add(new JScrollPane(graphPanel), BorderLayout.CENTER);
		//add listener to confirm frame closing
	     addVetoableChangeListener(new VetoableChangeListener()
	     {
	        public void vetoableChange(PropertyChangeEvent event)
	               throws PropertyVetoException
	        {  
	            String name = event.getPropertyName();
	            Object value = event.getNewValue();

	            // we only want to check attempts to close a frame
	            if (name.equals("closed") 
	                  && value.equals(Boolean.TRUE) && graphPanel.isModified())
	            {  
	                // ask user if it is ok to close
	                int result = JOptionPane.showInternalConfirmDialog(
	                        GraphFrame.this, "OK to close?",
	                        "Confirm", JOptionPane.YES_NO_OPTION);

	                // if the user doesn't agree, veto the close
	                if (result != JOptionPane.YES_OPTION)
	                     throw new PropertyVetoException(
	                     "User canceled close", event);
	            }
	         }           
	      });
	     graphPanel.setGraph(graph);
	 }

	 /** Gets the graph that is being edited in this frame.
	     @return the graph */
	 public Graph getGraph()
	 {
	     return graph;
	 }

	 /** Gets the graph panel that is contained in this frame.
	     @return the graph panel */
	 public GraphPanel getGraphPanel()
	 {
	     return graphPanel;
	 }

	   /**
	      Gets the file property.
	      @return the file
	   */
	   public File getFile()
	   {
	      return file;
	   }

	   /**
	      Sets the file property.
	      @param newValue the file
	   */
	   public void setFile(File newValue)
	   {
	      file = newValue;
	   }	
}
