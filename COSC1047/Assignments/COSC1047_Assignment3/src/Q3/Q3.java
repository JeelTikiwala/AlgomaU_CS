package Q3;

public class Q3 {

	public static void main(String[] args) {
		GeometricObject ob = new GeometricObject();  
	    GeometricObject ob1 = new Triangle();  // Create a Triangle object
	    GeometricObject ob2 = new Circle();  // Create a Circle object
	    GeometricObject ob3 = new Rectangle();  //Create a Rectangle object
	    
	    ob.area();
	    ob1.area();
	    ob2.area();
	    ob3.area();
	    
	    ob.perimeter();
	    ob1.perimeter();
	    ob2.perimeter();
	    ob3.perimeter();

	}

}
