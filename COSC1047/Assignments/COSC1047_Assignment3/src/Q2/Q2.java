package Q2;
 import java.util.*;
public class Q2 {

	public static void main(String[] args) {
		System.out.println("Enter three sides: ");
		Scanner sc=new Scanner(System.in);

		double side1, side2, side3;

		side1=sc.nextDouble();
		side2=sc.nextDouble();
		side3=sc.nextDouble();
		Triangle triangle=new Triangle(side1, side2, side3);

		System.out.println("Enter the color: ");
		String color;
		color=sc.next();

		System.out.println("Enter true/false for filled : ");
		boolean filled;

		filled=sc.nextBoolean();
		triangle.setColor(color);
		triangle.setFilled(filled);

		System.out.println("Area is "+triangle.getArea());
		System.out.println("Perimeter is "+triangle.getPerimeter());
		System.out.println("Color is " +triangle.getColor());
		System.out.println("Filled is "+(triangle.isFilled()));



	}

}
