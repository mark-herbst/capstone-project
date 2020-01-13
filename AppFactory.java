//AppFactory.java interface is implemented by an Application Factory which
//creates the required resources for the application
import java.util.ResourceBundle;
import javax.swing.*;
import java.util.ArrayList;

public interface AppFactory extends FilePaths {
//creates application resources from strings contained in resource bundles
void createResources(ResourceBundle appBundle,
								ResourceBundle countriesBundle,
								ResourceBundle USStatesBundle);
void createMainResources();//creates the Action objects and application string lists
void configureActions(String userType);//configures Action objects based on userType
JMenuBar createMenu();//returns the main menu
JToolBar createToolBar();//returns the tool bar
ImageIcon createIcon(String path);//creates Icons
//returns a collection of countries from resource bundle
ArrayList createCountryStrings();
//returns a collection of US States from resource bundle
ArrayList createUSStateStrings();
}
