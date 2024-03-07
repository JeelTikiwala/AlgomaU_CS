/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_lab2*/
import java.util.*;
/**
 * @author Jtikiwala
 *
 */
public class Calculator {
	//Declaring 4 static methods
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int subtract(int a, int b) {
		return a-b;
	}
	
	public static int multiply(int a, int b) {
		return a*b;
	}
	
	public static double divide(int a, int b) {
		return (double) a / b;
	}
	
	
	public static void main(String[] args) { //main method
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the first number a: "); //to enter 1st number
		int n1 = sc.nextInt();
		
		System.out.println("Enter the first number b: ");// to enter 2nd number
		int n2 = sc.nextInt();
		
		System.out.println("Select what to do?"); //select any from four arithmetic operations
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		
		System.out.println("Enter what to do?");
		int choice = sc.nextInt();
		
		int result = 0;
		switch(choice) { //swith case to select what operation to perform
		case 1:
			result = add(n1, n2);
			System.out.println("result is: " + result);
			break;
			
		case 2:
			result =  subtract(n1, n2);
			System.out.println("result is: " + result);
			break;
			
		case 3:
			result = multiply(n1, n2);
			System.out.println("result is: " + result);
			break;
		
		case 4:
			double divresult = divide(n1, n2);
			System.out.println("result is: "+ divresult); 
			break;
			
		}
	}

}
