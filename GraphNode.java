import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
public class GraphNode extends Canvas {
	private Object aNode;
	private Person aPerson;
	
	public GraphNode()
	{
		setBackground(Color.white);
	}
	
	public void paint(Graphics g) {
		
		Dimension theSize= getSize();
		Graphics2D g2;
        g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        
        /* Fill a round ellipse centered in the drawing area where circle and
         * text will reside.
         * Calculate the size of the rectangle from the size of the text*/
        String text = new String(aPerson.getName().toString());
        Font font = new Font("Dialog",Font.PLAIN, 12);        
        FontRenderContext frc = g2.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(text, frc);
        int wText = (int)bounds.getWidth();
        int hText = (int)bounds.getHeight();
        int rX = (theSize.width-wText)/1000;//point x on screen
        int rY = (theSize.height-hText)/1000;//point y on screen
        g2.setColor(Color.yellow);        
        g2.fillRoundRect(rX, rY, wText, hText, hText/2, hText/2);
        
        
        /* Draw the circle and the text, positioned in the rectangle.
         * Since the rectangle is sized based on the bounds of
         * the String we can position it using those bounds.*/
        int xText = rX-(int)bounds.getX();
        int yText = rY-(int)bounds.getY();
        g2.setColor(Color.black);
        //Draw the circle (x,y,recwidth,recheight)
        //g2.fill(new Ellipse2D.Double(rX,rY,20,20));//before it was in rect
        g2.fill(new Ellipse2D.Double(xText,yText,20,20));
        g2.setFont(font);
        g2.drawString(text, xText, yText);
        
        
        /*
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY);    
                            */    
    }

	public Object getANode() {
		return aNode;
	}

	public void setANode(Object node) {
		aNode = node;
		repaint();
	}

	public Person getAPerson() {
		return aPerson;
	}

	public void setAPerson(Person person) {
		aPerson = person;
		repaint();
	}	
}
