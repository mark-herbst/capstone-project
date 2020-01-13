//DateJPanel.java shows a date label and formatted date field
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
public class DateJPanel extends JPanel  {
	private JLabel lblDate;
	private JFormattedTextField jftDate;
	
	public DateJPanel(){}//default constructor	
	public DateJPanel(String txtLabel)
	{
		lblDate = new JLabel(txtLabel);	
		try {
			jftDate = new JFormattedTextField(new MaskFormatter("##/##/####"));			
		}
		catch(ParseException e)
		{
			//A ParseException will be thrown if mask is an invalid mask
		}		
		jftDate.setColumns(6);
		//jftDate.setText("00/00/0000");
		add(lblDate);
		add(jftDate);			
	}
	
	/** Returns an int month from the text field input based on format ##/##/#### */
	public int getMonth(String aDate)
	{
		try
		{
			int month=0;
			aDate = (String)jftDate.getValue();
			String[] m = aDate.split("/");
			month = Integer.parseInt(m[0]);	
			return month;
		}
		catch(NullPointerException ex)
		{
			return 0;
		}		
	}
	
	/** Returns an int date from the text field input based on format ##/##/#### */
	public int getDate(String aDate)
	{
		try
		{
			int date=0;
			aDate = (String)jftDate.getValue();
			String[] d = aDate.split("/");
			date = Integer.parseInt(d[1]);		
			return date;
		}	
		catch(NullPointerException ex)
		{
			return 0;
		}
	}
	
	/** Returns an int year from the text field input based on format ##/##/#### */
	public int getYear(String aDate)
	{
		try
		{
			int year=0;
			aDate = (String)jftDate.getValue();
			String[] y = aDate.split("/");
			year = Integer.parseInt(y[2]);		
			return year;
		}	
		catch(NullPointerException ex)
		{
			return 0;
		}
	}
	
	/** Clears all text fields contained in this Object */
	public void clearTextFields(){
		jftDate.setText("");
	}
	
	public JFormattedTextField getJftDate() {
		return jftDate;
	}

	public void setJftDate(JFormattedTextField jftDate) {
		this.jftDate = jftDate;
	}
	public JLabel getLblDate() {
		return lblDate;
	}
	public void setLblDate(JLabel lblDate) {
		this.lblDate = lblDate;
	}

	
}
