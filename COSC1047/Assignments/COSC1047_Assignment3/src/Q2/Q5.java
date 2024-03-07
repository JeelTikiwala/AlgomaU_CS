package Q2;
import java.util.ArrayList;

public class Q5 {

	public static void main(String[] args) {
		// Create an ArrayList to store decimal numbers
		ArrayList<Double> decimalList = new ArrayList<>();
		
		// Adding decimal numbers to the list
		decimalList.add(54.23);
		decimalList.add(29.98);
		decimalList.add(89.18);
		decimalList.add(12.27);
		decimalList.add(77.31);
		// Print all decimal numbers in the list using for-each loop
		for (double number : decimalList) {
		System.out.println(number); // Print each number in the list
		}

	}

}
