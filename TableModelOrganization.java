//TableModelOrganization.java is used to show organization data in a table
import java.util.List;
import javax.swing.table.AbstractTableModel;
public class TableModelOrganization extends AbstractTableModel {
	private String[]columnNames;
	private Object[][] data;
	private List tableData;
	
	public TableModelOrganization(String[] columnNames, List searchResults)
	{	
		this.columnNames=columnNames;
		this.data = listToObjectArray(searchResults);
		this.tableData=searchResults;
		//System.out.println("The size of the searchResults passed to TableModel " + searchResults.size());
		//System.out.println("The data length() = Row Count: " + data.length);
	}
	
	/** Converts the given resultList to an Object Array */
	public Object[][] listToObjectArray(List list)
	{
		//System.out.println("The size of list in listToObjectArray(): " + list.size());
		data = new Object[list.size()][];//[list.size()] is the # of rows
		for (int i=0; i<list.size(); i++)
		{			
			//list.get(i) is an organization object containing name
			String name = ((Organization)list.get(i)).getOrganizationName().toString();		
			Object[] anOrg = {name};			
			data[i] = anOrg;//data[i] is a row
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
