
public class Q1 {

	public static void main(String[] args) {
		 //create an object of Triangle class
        Triangle my = new Triangle(1,1.5,1,"yellow", true);
        //Call method getArea() to get the area of Triangle
        System.out.println("Area of Triangle " +my.getArea());
        //Call method getPerimeter() to get the perimeter of Triangle
        System.out.println("Perimeter of triangle " +my.getPerimeter());
        //call getter method getColor()
        System.out.println("color of the Triangle is " +my.getColor());


	}

}
