//Graph.java is a Link Analysis Graph
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
public class Graph extends JPanel implements EntityTypes {
	private Node parentNode;//The graph's Parent or Root Node
	//Node Links of the parentNode
	private List personLinkNodes = new ArrayList();	
	private List organizationLinkNodes = new ArrayList();
	private List eventLinkNodes = new ArrayList();
	//Links of the parentNode for the Report view
	private List personLinks = new ArrayList();
	private List organizationLinks = new ArrayList();
	private List eventLinks = new ArrayList();
	private double centerX, centerY, linkCenterX, linkCenterY;
	private Point2D centerPoint, linkCenterPoint;
	
	public Graph()
	{
		setBackground(Color.WHITE);
		
	}//default constructor
	
	public void paint(Graphics g)
	{		
		Font font = new Font("Dialog",Font.PLAIN, 12);//set string font 
		int lineBuffer = 10;//Buffer between a node and the link line
		
		Graphics2D g2;
        g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        
        //Determine centerPoint Point2D.Double of dimension (where parentNode will reside)
        centerX = (((double)getWidth())/2);//create centerX point
        centerY = (((double)getHeight())/2);//create centerY point
        centerPoint = new Point2D.Double();//create a Point2D centerpoint
        centerPoint.setLocation(centerX, centerY);//set location of center point

        String parentText = parentNode.getText();//get Node string
        //String parentText = new String(parentPerson.getName().toString());//get Node string
        //Determine Rectangle2D bounds(x,y) for the string
        //The FontRenderContext class is a container for the information needed
        //to correctly measure text.
        FontRenderContext frc = g2.getFontRenderContext();//used to measure string bounds
        Rectangle2D stringBounds = font.getStringBounds(parentText, frc);
        //textX is X-coordinate at screen center minus 1/2 of the max text width
        int textX = (int)centerPoint.getX() - (int)stringBounds.getMaxX()/2;
        //textY is Y-coordinate at screen center plus max text height
        int textY = (int)centerPoint.getY() + (int)stringBounds.getMaxY();        
        
        //Draw the parent Node       
        g2.drawString(parentText, textX, textY);
        
        //Draw the link Nodes
        textX=50;//resets textX near top left corner of graph panel
        textY=50;//resets textY near top left corner of graph panel
        
        for (Iterator it = personLinkNodes.iterator();//Draw Person Links
		it.hasNext();)
        {			
	    	int incrementX = 100;//the X-coordinate increment for each link node
	        int incrementY = 100;//the Y-coordinate increment for each link node 
	        
	        Node aPersonNode = ((Node)it.next()); 
	        String personLinkText = aPersonNode.getText();        	
	    	FontRenderContext linkfrc = g2.getFontRenderContext();//used to measure string bounds
	        Rectangle2D linkBounds = font.getStringBounds(personLinkText, linkfrc);
	        aPersonNode.setBounds(linkBounds);
	        if (textX < (int)getSize().getWidth())
	        {
	        	linkCenterPoint = new Point2D.Double();//create a Point2D centerpoint
	        	linkCenterX=textX+(linkBounds.getMaxX()/2);//center X is 1/2 of string width
	        	linkCenterY=textY;
	        	linkCenterPoint.setLocation(linkCenterX, linkCenterY);//set location of center point
	        	aPersonNode.setCenterPoint(linkCenterPoint);
	        	g2.drawString(personLinkText,textX,textY);//draw node
	        	//connect node to parent node
				//drawLine(int x1, int y1, int x2, int y2)
				//In this code (x1, y1) is the start point of the line,
				//and (x2, y2) is the end point of the line.
				g2.draw(new Line2D.Double(centerX, centerY-lineBuffer, linkCenterX, linkCenterY+lineBuffer));
	        }//end if
        	else
        	{
	        	textX=50;
	        	textY+=incrementY;
	        	linkCenterPoint = new Point2D.Double();//create a Point2D centerpoint
	        	linkCenterX=textX+(linkBounds.getMaxX()/2);//center X is 1/2 of string width
	        	linkCenterY=textY;
	        	linkCenterPoint.setLocation(linkCenterX, linkCenterY);//set location of link center point
	        	g2.drawString(personLinkText,textX,textY);
	        	//connect node to parent node
				//drawLine(int x1, int y1, int x2, int y2)
				//In this code (x1, y1) is the start point of the line,
				//and (x2, y2) is the end point of the line. 
				g2.draw(new Line2D.Double(centerX, centerY-lineBuffer, linkCenterX, linkCenterY+lineBuffer));
        	}//end else
			textX += incrementX + (int)linkBounds.getMaxX();				
        }//end Iterator personLinkNodes    
        
        for (Iterator it = organizationLinkNodes.iterator();//Draw Organization Links
		it.hasNext();)
        {			
	    	int incrementX = 100;//the X-coordinate increment for each link node
	        int incrementY = 100;//the Y-coordinate increment for each link node 
	        
	        Node anOrganizationNode = ((Node)it.next()); 
	        String organizationLinkText = anOrganizationNode.getText();        	
	    	FontRenderContext linkfrc = g2.getFontRenderContext();//used to measure string bounds
	        Rectangle2D linkBounds = font.getStringBounds(organizationLinkText, linkfrc);
	        anOrganizationNode.setBounds(linkBounds);
	        if (textX < (int)getSize().getWidth())
	        {
	        	linkCenterPoint = new Point2D.Double();//create a Point2D centerpoint
	        	linkCenterX=textX+(linkBounds.getMaxX()/2);//center X is 1/2 of string width
	        	linkCenterY=textY;
	        	linkCenterPoint.setLocation(linkCenterX, linkCenterY);//set location of center point
	        	anOrganizationNode.setCenterPoint(linkCenterPoint);
	        	g2.drawString(organizationLinkText,textX,textY);//draw node
	        	//connect node to parent node
				//drawLine(int x1, int y1, int x2, int y2)
				//In this code (x1, y1) is the start point of the line,
				//and (x2, y2) is the end point of the line.
				g2.draw(new Line2D.Double(centerX, centerY-lineBuffer, linkCenterX, linkCenterY+lineBuffer));
	        }//end if
        	else
        	{
	        	textX=50;
	        	textY+=incrementY;
	        	linkCenterPoint = new Point2D.Double();//create a Point2D centerpoint
	        	linkCenterX=textX+(linkBounds.getMaxX()/2);//center X is 1/2 of string width
	        	linkCenterY=textY;
	        	linkCenterPoint.setLocation(linkCenterX, linkCenterY);//set location of link center point
	        	g2.drawString(organizationLinkText,textX,textY);
	        	//connect node to parent node
				//drawLine(int x1, int y1, int x2, int y2)
				//In this code (x1, y1) is the start point of the line,
				//and (x2, y2) is the end point of the line. 
				g2.draw(new Line2D.Double(centerX, centerY-lineBuffer, linkCenterX, linkCenterY+lineBuffer));
        	}//end else
			textX += incrementX + (int)linkBounds.getMaxX();				
        }//end Iterator organizationLinkNodes 
        
        for (Iterator it = eventLinkNodes.iterator();//Draw Event Links
		it.hasNext();)
        {			
	    	int incrementX = 100;//the X-coordinate increment for each link node
	        int incrementY = 100;//the Y-coordinate increment for each link node 
	        
	        Node anEventNode = ((Node)it.next()); 
	        String eventLinkText = anEventNode.getText();        	
	    	FontRenderContext linkfrc = g2.getFontRenderContext();//used to measure string bounds
	        Rectangle2D linkBounds = font.getStringBounds(eventLinkText, linkfrc);
	        anEventNode.setBounds(linkBounds);
	        if (textX < (int)getSize().getWidth())
	        {
	        	linkCenterPoint = new Point2D.Double();//create a Point2D centerpoint
	        	linkCenterX=textX+(linkBounds.getMaxX()/2);//center X is 1/2 of string width
	        	linkCenterY=textY;
	        	linkCenterPoint.setLocation(linkCenterX, linkCenterY);//set location of center point
	        	anEventNode.setCenterPoint(linkCenterPoint);
	        	g2.drawString(eventLinkText,textX,textY);//draw node
	        	//connect node to parent node
				//drawLine(int x1, int y1, int x2, int y2)
				//In this code (x1, y1) is the start point of the line,
				//and (x2, y2) is the end point of the line.
				g2.draw(new Line2D.Double(centerX, centerY-lineBuffer, linkCenterX, linkCenterY+lineBuffer));
	        }//end if
        	else
        	{
	        	textX=50;
	        	textY+=incrementY;
	        	linkCenterPoint = new Point2D.Double();//create a Point2D centerpoint
	        	linkCenterX=textX+(linkBounds.getMaxX()/2);//center X is 1/2 of string width
	        	linkCenterY=textY;
	        	linkCenterPoint.setLocation(linkCenterX, linkCenterY);//set location of link center point
	        	g2.drawString(eventLinkText,textX,textY);
	        	//connect node to parent node
				//drawLine(int x1, int y1, int x2, int y2)
				//In this code (x1, y1) is the start point of the line,
				//and (x2, y2) is the end point of the line. 
				g2.draw(new Line2D.Double(centerX, centerY-lineBuffer, linkCenterX, linkCenterY+lineBuffer));
        	}//end else
			textX += incrementX + (int)linkBounds.getMaxX();				
        }//end Iterator eventLinkNodes
    }//end paint	

	public Point2D getCenterPoint() {
		return centerPoint;
	}

	public void setCenterPoint(Point2D centerPoint) {
		this.centerPoint = centerPoint;
		repaint();
	}

	public double getCenterX() {
		return centerX;
	}

	public void setCenterX(double centerX) {
		this.centerX = centerX;
		repaint();
	}

	public double getCenterY() {
		return centerY;
	}

	public void setCenterY(double centerY) {
		this.centerY = centerY;
		repaint();
	}

	public List getPersonLinks() {
		return personLinks;
	}

	public void setPersonLinks(List personLinks) {
		this.personLinks = personLinks;
	}

	public Point2D getLinkCenterPoint() {
		return linkCenterPoint;
	}

	public void setLinkCenterPoint(Point2D linkCenterPoint) {
		this.linkCenterPoint = linkCenterPoint;
	}

	public double getLinkCenterX() {
		return linkCenterX;
	}

	public void setLinkCenterX(double linkCenterX) {
		this.linkCenterX = linkCenterX;
	}

	public double getLinkCenterY() {
		return linkCenterY;
	}

	public void setLinkCenterY(double linkCenterY) {
		this.linkCenterY = linkCenterY;
	}

	public List getPersonLinkNodes() {
		return personLinkNodes;
	}

	public void setPersonLinkNodes(List personLinkNodes) {
		this.personLinkNodes = personLinkNodes;
	}

	public List getOrganizationLinkNodes() {
		return organizationLinkNodes;
	}

	public void setOrganizationLinkNodes(List organizationLinkNodes) {
		this.organizationLinkNodes = organizationLinkNodes;
	}

	public List getOrganizationLinks() {
		return organizationLinks;
	}

	public void setOrganizationLinks(List organizationLinks) {
		this.organizationLinks = organizationLinks;
	}

	public List getEventLinkNodes() {
		return eventLinkNodes;
	}

	public void setEventLinkNodes(List eventLinkNodes) {
		this.eventLinkNodes = eventLinkNodes;
	}

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}

	public List getEventLinks() {
		return eventLinks;
	}

	public void setEventLinks(List eventLinks) {
		this.eventLinks = eventLinks;
	}

	
	
	
	
	

		
	

}
