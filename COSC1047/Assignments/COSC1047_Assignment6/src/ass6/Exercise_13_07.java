package ass6;
/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment6*/
public class Exercise_13_07 {
	/** Main method */
	public static void main(String[] args) {
		// Create an array of five GeometricObjects
		GeometricObject[] squares = {new Square(3.5), new Square(11), 
			new Square(9.6), new Square(17), new Square(2)};

		// Display the area and invoke the howToColor 
		// method for each GeometricObject
		for (int i = 0; i < squares.length; i++) {
		 	System.out.println("\nSquare #" + (i + 1));
		 	System.out.println("The Area is: " + squares[i].getArea());
		 	System.out.println("How to color the Square: " + ((Square)squares[i]).howToColor());
		 } 
	}
}