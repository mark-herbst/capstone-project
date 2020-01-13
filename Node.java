//Node.java represents a node object in a graph
import java.awt.geom.*;
public class Node implements EntityTypes {
	private Long id;
	private static String TYPE;
	private Rectangle2D bounds;
	private String text;
	private Point2D centerPoint;
	
	public Node(){}//default constructor	

	public String getTYPE() {
		return TYPE;
	}
	
	public void setTYPE(String type) {
		TYPE = type;
	}

	public Rectangle2D getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle2D bounds) {
		this.bounds = bounds;
	}

	public Point2D getCenterPoint() {
		return centerPoint;
	}

	public void setCenterPoint(Point2D centerPoint) {
		this.centerPoint = centerPoint;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}	
}
