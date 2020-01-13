//NameJPanel.java holds all name type panels for input of a person's name
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;
public class NameJPanel extends JPanel implements ItemListener {
	private ResourceBundle appBundle;
	private JPanel cards = new JPanel(new CardLayout());
	private JPanel typePanel, namePanel;
	private NameStandardJPanel standardName;
	private NameHispanicJPanel hispanicName;
	private NameArabicJPanel arabicName;
	private NameAliasJPanel aliasName;
	private JLabel lblType;
	private JComboBox cbType;		
	private JButton btnSearch;	
	private String lblNameTypeTxt, txtEnglish, txtHispanic, txtArabic, txtAliasType, txtFirst,
	txtMiddle, txtLast, txtFathers, txtMothersMaiden, txtGrandfathers, txtFamilys,
	txtAlias, cardSelected;	
	
	public NameJPanel(){}// Default constructor	
	public NameJPanel(ResourceBundle appBundle)
	{
		this.appBundle = appBundle;		
		createStrings();		
		String[] nameTypes = {txtEnglish, txtHispanic, txtArabic, txtAliasType};
		//NameTypes: "English" "Hispanic" "Arabic" "Alias"		
		setLayout(new BorderLayout());		
		lblType = new JLabel(lblNameTypeTxt);		
		cbType = new JComboBox(nameTypes);
		cbType.setEditable(false);		
		cbType.setFocusable(true); 
		typePanel = new JPanel();
		typePanel.setLayout(new FlowLayout());
		typePanel.add(lblType);
		typePanel.add(cbType);		
		
		//Name Panels or "cards"
		//Standard Name: first:, middle:, last:
		standardName = new NameStandardJPanel(txtFirst, txtMiddle, txtLast);
		//Hispanic Name: first:, fathers:, mothersMaiden:
		hispanicName = new NameHispanicJPanel(txtFirst, txtFathers, txtMothersMaiden);
		//Arabic Name: first:, fathers:, grandfathers:, familys:
		arabicName = new NameArabicJPanel(txtFirst, txtFathers, txtGrandfathers, txtFamilys);
		//Alias Name: alias:
		aliasName= new NameAliasJPanel(txtAlias);
		//Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(standardName, txtEnglish);
        cards.add(hispanicName, txtHispanic);
        cards.add(arabicName, txtArabic);
        cards.add(aliasName, txtAliasType);
        namePanel = new JPanel(new BorderLayout());
        namePanel.add(cards, BorderLayout.WEST);   		
		
        add(typePanel, BorderLayout.WEST);
        add(namePanel, BorderLayout.CENTER);        
        standardName.firstName.requestFocusInWindow();
        setCardSelected(txtEnglish);
  
        //add listeners
        cbType.addItemListener(this);
	}
	
	public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        setCardSelected((String)e.getItem());        
        cl.show(cards, cardSelected);
        standardName.firstName.requestFocusInWindow();
        hispanicName.firstName.requestFocusInWindow();
        arabicName.firstName.requestFocusInWindow();   
        aliasName.aliasName.requestFocusInWindow();
        if(getCardSelected()==txtEnglish)
        {
        	hispanicName.clearTextFields();
        	arabicName.clearTextFields();
        	aliasName.clearTextFields();
        }
        if(getCardSelected()==txtArabic)
        {
        	standardName.clearTextFields();
        	hispanicName.clearTextFields();
        	aliasName.clearTextFields();
        }
        if(getCardSelected()==txtHispanic)
        {
        	standardName.clearTextFields();
        	arabicName.clearTextFields();
        	aliasName.clearTextFields();
        }
        if(getCardSelected()==txtAlias)
        {
        	standardName.clearTextFields();
        	arabicName.clearTextFields();
        	hispanicName.clearTextFields();
        }
    }
	
	/** Uses a ResourceBundle to create the strings displayed in the panel */
	public void createStrings()
	{
		lblNameTypeTxt = appBundle.getString("name.type.text");
		txtEnglish = appBundle.getString("name.type.english.text");
		txtHispanic = appBundle.getString("name.type.hispanic.text");
		txtArabic = appBundle.getString("name.type.arabic.text");
		txtAliasType = appBundle.getString("name.type.alias.text");//Alias
		txtFirst = appBundle.getString("name.first.text");
		txtMiddle = appBundle.getString("name.middle.text");
		txtLast = appBundle.getString("name.last.text");
		txtFathers = appBundle.getString("name.fathers.text");
		txtMothersMaiden = appBundle.getString("name.mothers_maiden.text");
		txtGrandfathers = appBundle.getString("name.grandfathers.text");
		txtFamilys = appBundle.getString("name.familys.text");
		txtAlias = appBundle.getString("name.alias.text");//Alias:		
	}
	
	/** Clears all text fields contained in this Object */
	public void clearTextFields()
	{
		standardName.clearTextFields();
    	hispanicName.clearTextFields();
    	arabicName.clearTextFields();
    	aliasName.clearTextFields();
	}
	
	public NameAliasJPanel getAliasName() {
		return aliasName;
	}
	public void setAliasName(NameAliasJPanel aliasName) {
		this.aliasName = aliasName;
	}
	public NameArabicJPanel getArabicName() {
		return arabicName;
	}
	public void setArabicName(NameArabicJPanel arabicName) {
		this.arabicName = arabicName;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}
	public JPanel getCards() {
		return cards;
	}
	public void setCards(JPanel cards) {
		this.cards = cards;
	}
	public NameHispanicJPanel getHispanicName() {
		return hispanicName;
	}
	public void setHispanicName(NameHispanicJPanel hispanicName) {
		this.hispanicName = hispanicName;
	}
	public JLabel getLblType() {
		return lblType;
	}
	public void setLblType(JLabel lblType) {
		this.lblType = lblType;
	}
	public JPanel getNamePanel() {
		return namePanel;
	}
	public void setNamePanel(JPanel namePanel) {
		this.namePanel = namePanel;
	}
	public NameStandardJPanel getStandardName() {
		return standardName;
	}
	public void setStandardName(NameStandardJPanel standardName) {
		this.standardName = standardName;
	}
	public JComboBox getTypeBox() {
		return cbType;
	}
	public void setTypeBox(JComboBox cbType) {
		this.cbType = cbType;
	}
	public JPanel getTypePanel() {
		return typePanel;
	}
	public void setTypePanel(JPanel typePanel) {
		this.typePanel = typePanel;
	}
	public String getLblNameTypeTxt() {
		return lblNameTypeTxt;
	}
	public void setLblNameTypeTxt(String lblNameTypeTxt) {
		this.lblNameTypeTxt = lblNameTypeTxt;
	}
	public String getTxtAlias() {
		return txtAlias;
	}
	public void setTxtAlias(String txtAlias) {
		this.txtAlias = txtAlias;
	}
	public String getTxtAliasType() {
		return txtAliasType;
	}
	public void setTxtAliasType(String txtAliasType) {
		this.txtAliasType = txtAliasType;
	}
	public String getTxtArabic() {
		return txtArabic;
	}
	public void setTxtArabic(String txtArabic) {
		this.txtArabic = txtArabic;
	}
	public String getTxtFamilys() {
		return txtFamilys;
	}
	public void setTxtFamilys(String txtFamilys) {
		this.txtFamilys = txtFamilys;
	}
	public String getTxtFathers() {
		return txtFathers;
	}
	public void setTxtFathers(String txtFathers) {
		this.txtFathers = txtFathers;
	}
	public String getTxtFirst() {
		return txtFirst;
	}
	public void setTxtFirst(String txtFirst) {
		this.txtFirst = txtFirst;
	}
	public String getTxtGrandfathers() {
		return txtGrandfathers;
	}
	public void setTxtGrandfathers(String txtGrandfathers) {
		this.txtGrandfathers = txtGrandfathers;
	}
	public String getTxtHispanic() {
		return txtHispanic;
	}
	public void setTxtHispanic(String txtHispanic) {
		this.txtHispanic = txtHispanic;
	}
	public String getTxtLast() {
		return txtLast;
	}
	public void setTxtLast(String txtLast) {
		this.txtLast = txtLast;
	}
	public String getTxtMiddle() {
		return txtMiddle;
	}
	public void setTxtMiddle(String txtMiddle) {
		this.txtMiddle = txtMiddle;
	}
	public String getTxtMothersMaiden() {
		return txtMothersMaiden;
	}
	public void setTxtMothersMaiden(String txtMothersMaiden) {
		this.txtMothersMaiden = txtMothersMaiden;
	}
	public ResourceBundle getAppBundle() {
		return appBundle;
	}
	public void setAppBundle(ResourceBundle appBundle) {
		this.appBundle = appBundle;
	}
	public String getTxtEnglish() {
		return txtEnglish;
	}
	public void setTxtEnglish(String txtEnglish) {
		this.txtEnglish = txtEnglish;
	}
	public String getCardSelected() {
		return cardSelected;
	}
	public void setCardSelected(String cardSelected) {
		this.cardSelected = cardSelected;
	}
	public JComboBox getCbType() {
		return cbType;
	}
	public void setCbType(JComboBox cbType) {
		this.cbType = cbType;
	}	
}
