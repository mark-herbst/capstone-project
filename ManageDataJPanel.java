/** ManageDataJPanel.java is a panel with buttons used to Add/Edit/Delete Records & Links */
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
public class ManageDataJPanel extends JPanel {
	private String txtEditDelete, txtAddRecord, txtAddLink;
	private JButton editDelete, addRecord, addLink;
	
	public ManageDataJPanel(String txtEditDelete, String txtAddRecord, String txtAddLink)
	{
		this.txtEditDelete=txtEditDelete;
		this.txtAddRecord=txtAddRecord;
		this.txtAddLink=txtAddLink;
		
		setLayout(new GridLayout(3,1,5,5));//rows,col,hgap,vgap
		editDelete = new JButton(txtEditDelete);
		addRecord = new JButton(txtAddRecord);
		addLink = new JButton(txtAddLink);
		
		add(editDelete);
		add(addRecord);
		add(addLink);		
	}
	
	public JButton getAddLink() {
		return addLink;
	}
	public void setAddLink(JButton addLink) {
		this.addLink = addLink;
	}
	public JButton getAddRecord() {
		return addRecord;
	}
	public void setAddRecord(JButton addRecord) {
		this.addRecord = addRecord;
	}
	public JButton getEditDelete() {
		return editDelete;
	}
	public void setEditDelete(JButton editDelete) {
		this.editDelete = editDelete;
	}
	public String getTxtAddLink() {
		return txtAddLink;
	}
	public void setTxtAddLink(String txtAddLink) {
		this.txtAddLink = txtAddLink;
	}
	public String getTxtAddRecord() {
		return txtAddRecord;
	}
	public void setTxtAddRecord(String txtAddRecord) {
		this.txtAddRecord = txtAddRecord;
	}
	public String getTxtEditDelete() {
		return txtEditDelete;
	}
	public void setTxtEditDelete(String txtEditDelete) {
		this.txtEditDelete = txtEditDelete;
	}
	
}
