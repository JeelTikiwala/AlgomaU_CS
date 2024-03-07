/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment4*/
import java.util.*;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] array = getArray(); // Call the getArray() method 
		
		System.out.println("Enter the index of an array:");

		try {
			System.out.println("The corresponding element value is: " + 
					array[sc.nextInt()]); // Access the array element at the specified index
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Array index out of Bounds."); // Catch the ArrayIndexOutOfBoundsException if the user-entered index is out of range.
		}
	}
	
	public static int[] getArray() {
		int[] array = new int[100]; // Create an integer array with a length of 100.
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * 100) + 1; // Assign a random number between 1 and 100
		}
		
		return array; // Return the array.
	}

}
