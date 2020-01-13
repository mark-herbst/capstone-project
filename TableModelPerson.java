//TableModelPerson.java is used by a table to show person data
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.util.Calendar;
public class TableModelPerson extends AbstractTableModel {
	private String[]columnNames;
	private Object[][] data;
	private List tableData;
	
	public TableModelPerson(String[] columnNames, List searchResults)
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
		InputVerifier input = new InputVerifier();//INPUT FROM DATABASE		
		//System.out.println("The size of list in listToObjectArray(): " + list.size());
		data = new Object[list.size()][];//[list.size()] is the # of rows
		for (int i=0; i<list.size(); i++)
		{			
			//list.get(i) is a person object containing name,gender,race,dob
			String name = ((Person)list.get(i)).getName().toString();//get name from DB			
			String gender = ((Person)list.get(i)).getGender().toString();
			String race = ((Person)list.get(i)).getRace().toString();	
			String dob;
			Calendar birthDate = ((Person)list.get(i)).getDob();//get calendar_date from DB
			if(birthDate == null)
			{
				dob="";
			}
			else
			{
				dob=input.CalendarDateToStringDate(birthDate);
			}
			//System.out.println("DOB from DB TableModelPerson listToObjectArray() " + birthDate.toString());
			//convert Calender date object to string	
			//String dob = input.CalendarDateToStringDate(birthDate);			
			Object[] aPerson = {name, gender, race, dob};			
			data[i] = aPerson;//data[i] is a row
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

