/** FunctionButtonJPanel.java is a panel that holds buttons used to select application
 	functions */
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FunctionButtonJPanel extends JPanel {
	private JButton btnSearch, btnAdd, btnEdit, btnDelete, btnHelp;
	public FunctionButtonJPanel(Action helpAction, String txtSearch, String txtAdd,
			String txtEdit, String txtDelete, String txtHelp)
	{
		btnSearch = new JButton(txtSearch);
		btnAdd = new JButton(txtAdd);
		btnEdit = new JButton(txtEdit);
		btnDelete= new JButton(txtDelete);
		btnHelp = new JButton(helpAction);
		btnHelp.setIcon(null);//Disable icon in helpAction
		btnHelp.setText(txtHelp);//Modify text displayed from text in helpAction
		add(btnSearch);
		add(btnAdd);
		add(btnEdit);
		add(btnDelete);
		add(btnHelp);
	}
	
	/** Enables Search button and Disables Add/Edit/Delete buttons */
	public void searchMode()
	{
		btnSearch.setEnabled(true);
		btnAdd.setEnabled(false);
		btnEdit.setEnabled(false);
		btnDelete.setEnabled(false);
		btnHelp.setEnabled(true);		
	}
	
	/** Enables Add/Edit/Delete buttons and Disables Search button */
	public void manageDataMode()
	{
		btnSearch.setEnabled(false);
		btnAdd.setEnabled(true);
		btnEdit.setEnabled(true);
		btnDelete.setEnabled(true);
		btnHelp.setEnabled(true);
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}
	public JButton getBtnEdit() {
		return btnEdit;
	}
	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}
	public JButton getBtnHelp() {
		return btnHelp;
	}
	public void setBtnHelp(JButton btnHelp) {
		this.btnHelp = btnHelp;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}	
}
