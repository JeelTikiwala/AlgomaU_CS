
public class GeometricObject {
	String color;
	Boolean filled;
	java.util.Date dateCreated;
	
	public GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	public GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	/**Getter method for color*/
	public String getColor() {
		return color;
	}
	
	/**Setter method for color*/
	public void setColor(String color) {
		this.color = color;
	}
	
	/**Getter method for filled*/
	public Boolean getFilled() {
		return filled;
	}
	
	/**Setter method for filled*/
	public void setFilled(Boolean filled) {
		this.filled = filled;
	}
	
	public String toString() {
	    return "Color: " + color + " and filled: " + filled;
	   }
	
}
