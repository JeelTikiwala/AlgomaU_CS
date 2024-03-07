//Excercise 2
import java.util.*; // Import the Scanner class
public class Q2 {

	public static void main(String[] args) {
		// Define all the variables such as SVelocity as v0, EVelocity as v1 and Time as t
		
		Scanner input = new Scanner(System.in); // Created Scanner Object 
		
		System.out.println("Enter the Starting Velocity in meters/seconds");
		Double v0 = input.nextDouble(); 		//Define Starting Velocity v0
		
		System.out.println("Enter the Ending Velocity in meters/seconds");
		Double v1 = input.nextDouble(); 		//Define Starting Velocity v1	
		
		System.out.println("Enter the time in seconds");
		Double t = input.nextDouble();			//Define the Time

		Double a;	//Define the acceleration
		
		a = v1 - v0 / t; //Formula of acceleration
		
		System.out.println("The average acceleration is " + a + " meters/seconds.");
		
	}

}
