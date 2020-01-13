//EntityTabbedPane.java is a panel that holds Tabbed Panes of entity panels 
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
public class EntityTabbedPane extends JPanel {
	private JTabbedPane tabbedPane;
	public EntityTabbedPane(){}//default constructor
	//public EntityTabbedPane(String personTitle, JPanel personPanel, String orgTitle, JPanel orgPanel, String eventTitle, JPanel eventPanel, String addressTitle, JPanel addressPanel, String phoneTitle, JPanel phonePanel, String phoneCallTitle, JPanel phoneCallPanel);
	public EntityTabbedPane(String personTitle, JPanel personPanel, String orgTitle, JPanel orgPanel, String eventTitle, JPanel eventPanel, String addressTitle, JPanel addressPanel)
	{
		super(new BorderLayout());		
		tabbedPane = new JTabbedPane();		
		tabbedPane.addTab(personTitle, personPanel);//"Person" = personTitle
		tabbedPane.addTab(orgTitle, orgPanel);//"Organization" = orgTitle
		tabbedPane.addTab(eventTitle, eventPanel);//"Event" = eventTitle
		tabbedPane.addTab(addressTitle, addressPanel);//"Address" = addressTitle
		//tabbedPane.addTab(phoneTitle, phonePanel);//"Phone"= phoneTitle
		//tabbedPane.addTab(phoneCallTitle, phoneCallPanel);//"Phone Calls" = phoneCallTitle
		tabbedPane.setMnemonicAt(0,KeyEvent.VK_P);//Person mnemonic at P
		tabbedPane.setMnemonicAt(1,KeyEvent.VK_O);//Organization mnemonic at O
		tabbedPane.setMnemonicAt(2,KeyEvent.VK_E);//Event mnemonic at E
		tabbedPane.setMnemonicAt(3,KeyEvent.VK_A);//Address mnemonic at A
		//tabbedPane.setMnemonicAt(4,KeyEvent.VK_H);//Phone mnemonic at H
		//tabbedPane.setMnemonicAt(5,KeyEvent.VK_C);//Phone Call mnemonic at C
		add(tabbedPane, BorderLayout.CENTER);
	}
	
	
}
