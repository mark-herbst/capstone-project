//TableModelEvent.java is used by a table to show event data
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.util.Calendar;
public class TableModelEvent extends AbstractTableModel {
	private String[]columnNames;
	private Object[][] data;
	private List tableData;
	
	public TableModelEvent(String[] columnNames, List searchResults)
	{	
		this.columnNames=columnNames;
		this.data = listToObjectArray(searchResults);
		this.tableData=searchResults;
	}
	
	/** Converts the given resultList to an Object Array */
	public Object[][] listToObjectArray(List list)
	{
		InputVerifier input = new InputVerifier();//INPUT FROM DATABASE		
		data = new Object[list.size()][];//[list.size()] is the # of rows
		for (int i=0; i<list.size(); i++)
		{			
			//list.get(i) is an Event object containing eventDate, title & description
			Calendar theDate = ((Event)list.get(i)).getEventDate();//get calendar_date from DB				
			String eventDate;//convert Calender date object to string
			if(theDate == null)
			{
				eventDate="";
			}
			else
			{
				eventDate=input.CalendarDateToStringDate(theDate);
			}
			eventDate = input.CalendarDateToStringDate(theDate);	
			String title = ((Event)list.get(i)).getTitle().toString();//get name from DB			
			String description = ((Event)list.get(i)).getDescription().toString();
			Object[] anEvent = {eventDate, title, description};			
			data[i] = anEvent;//data[i] is a row
		}
		return data;
	}	
	
	/** Returns the number of rows in Object[][] data array */
	public int getRowCount()
	{
        return data.length;
    }
	
	/** Returns the number of columns */
	public int getColumnCount()
	{
        return columnNames.length;
    }
	
	/** Returns the Object at the specified row & column */
	public Object getValueAt(int row, int col)
	{
        return data[row][col];
    }
	
	/** Returns a String representation of a table column
	 	col is the index of the column
	 	columnNames is an array of Strings containing the column names for
	 	a JTable. */
	public String getColumnName(int col)
	{
		return columnNames[col];
    }
	
	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public List getTableData() {
		return tableData;
	}

	public void setTableData(List tableData) {
		this.tableData = tableData;
	}
}
