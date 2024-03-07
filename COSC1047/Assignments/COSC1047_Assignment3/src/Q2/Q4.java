package Q2;
import java.util.ArrayList;

public class Q4 {

	public static void main(String[] args) {
		ArrayList<Triangle> triangleList = new ArrayList<>();
		// Create three Triangle objects and add them to the list
		Triangle triangle1 = new Triangle(4.0, 5.0, 5.0);
		Triangle triangle2 = new Triangle(7.0, 11.0, 17.2);
		Triangle triangle3 = new Triangle(8.0, 9.0, 11.0);
		
		triangleList.add(triangle2);
		triangleList.add(triangle3);
		// Print the area of all three triangles using for-each loop
		for (Triangle triangle : triangleList) {
		double area = triangle.getArea();
		System.out.println("Area is: " + area);
		}
	}

}
