/** TableEvent.java is a panel that contains a JTable populated with Event objects
 	supplied by an EventTableModel */
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class TableEvent extends JPanel {
	private static final int ROW_SELECTION_MODE = javax.swing.ListSelectionModel.
	SINGLE_SELECTION;
	final JTable table;
	private TableModelEvent tableModel;
	private int row;
	private Event eventSelected;
	
	public TableEvent(TableModelEvent tableModel)
	{
		super(new GridLayout(1,0));
		this.tableModel = tableModel;
		table = new JTable(tableModel);		
		table.setPreferredScrollableViewportSize(new Dimension(700, 200));
		table.setSelectionMode(ROW_SELECTION_MODE);
		table.getTableHeader().setReorderingAllowed(false);
		table.getSelectionModel().addListSelectionListener(new RowListener());
		//set description column size (name column location starts at 0)
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
        
		//Create the scroll pane and add the table to it
		JScrollPane scrollPane = new JScrollPane(table);				
		add(scrollPane);//Add the scroll pane to this panel
		setOpaque(true);//content pane must be opaque
	}
	
	/** RowListener.java is an inner class that listens to user's row selections */
	private class RowListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if(event.getValueIsAdjusting()) {
                return;//Returns true if the selection is undergoing a series of changes
                		//not interested in this event
            }
            setRow(table.getSelectedRow());//set int row selected by user
            //get the Person Object associated with the row selected and set it to
            //this.personSelected
            setEventSelected((Event)tableModel.getTableData().get(row));
        }
	}

	public static int getROW_SELECTION_MODE() {
		return ROW_SELECTION_MODE;
	}

	public Event getEventSelected() {
		return eventSelected;
	}

	public void setEventSelected(Event eventSelected) {
		this.eventSelected = eventSelected;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public JTable getTable() {
		return table;
	}

	public TableModelEvent getTableModel() {
		return tableModel;
	}

	public void setTableModel(TableModelEvent tableModel) {
		this.tableModel = tableModel;
	}	
}
