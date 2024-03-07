/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_lab5*/

import java.util.*;
public class Q1 {

	/**
	 * 
	 */
	public Q1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first number: ");
		int a = sc.nextInt();
		
		System.out.println("Enter the second number: ");
		int b = sc.nextInt();
		
		try {
			int result = a/b;
			System.out.println("The number is divisible: " + result);
		}
		catch(ArithmeticException e){
			System.out.println("This number cannot be divisible..");
		}
		

	}

}
