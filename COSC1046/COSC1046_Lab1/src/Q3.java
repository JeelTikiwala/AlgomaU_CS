import java.util.*; // Import the Scanner class
public class Q3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); //Created Scanner Object
		
		System.out.println("Enter Weight in pounds: ");
		Double weight = input.nextDouble(); //Defining Weight
		
		System.out.println("Enter height in inches");
		Double height = input.nextDouble(); //Defining Height
		
		
		//To define BMI and convert Kg to Pounds and Height in inches
		Double BMI = weight * 0.45359237 / (height * 0.0254 * height * 0.0254);
		
		System.out.println("The BMI is: " + BMI); //Display the output

	}

}
