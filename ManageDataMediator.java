/** ManageDataMediator.java handles button events in a ManageDataJPanel object */
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
public class ManageDataMediator implements ActionListener {
	private JupiterFrame managerFrame;
	private ResourceBundle appBundle;
	private ManageDataJPanel manageTypePanel;
	private boolean addLink = false;
	private boolean addRecord = false;
	private boolean editDelete = false;

	public ManageDataMediator(ResourceBundle appBundle, ManageDataJPanel manageTypePanel)
	{
		this.appBundle=appBundle;
		this.manageTypePanel=manageTypePanel;
		
		manageTypePanel.getAddLink().addActionListener(this);
		manageTypePanel.getAddRecord().addActionListener(this);
		manageTypePanel.getEditDelete().addActionListener(this);		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == manageTypePanel.getAddLink()){			
			setAddLink(true);
			managerFrame.dispose();
		}//end if add link action
		else if(e.getSource() == manageTypePanel.getAddRecord()){
			setAddRecord(true);
			managerFrame.dispose();
		}//end if add record action
		else if(e.getSource() == manageTypePanel.getEditDelete()){
			setEditDelete(true);
			managerFrame.dispose();
		}//end if edit/delete action
	}//end actionPerformed()
	
	public ResourceBundle getAppBundle() {
		return appBundle;
	}
	public void setAppBundle(ResourceBundle appBundle) {
		this.appBundle = appBundle;
	}
	public JupiterFrame getManagerFrame() {
		return managerFrame;
	}
	public void setManagerFrame(JupiterFrame managerFrame) {
		this.managerFrame = managerFrame;
	}
	public ManageDataJPanel getManageTypePanel() {
		return manageTypePanel;
	}
	public void setManageTypePanel(ManageDataJPanel manageTypePanel) {
		this.manageTypePanel = manageTypePanel;
	}
	public boolean isAddLink() {
		return addLink;
	}

	public void setAddLink(boolean addLink) {
		this.addLink = addLink;
	}

	public boolean isAddRecord() {
		return addRecord;
	}

	public void setAddRecord(boolean addRecord) {
		this.addRecord = addRecord;
	}

	public boolean isEditDelete() {
		return editDelete;
	}

	public void setEditDelete(boolean editDelete) {
		this.editDelete = editDelete;
	}
	
	
}
