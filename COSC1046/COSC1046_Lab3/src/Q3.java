import java.util.*; //import explicit function

public class Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //import scanner class

	// Prompt the user to enter a letter grade A, B, C, D or F
		System.out.print("Enter a letter grade: ");

		char let = sc.next().charAt(0);

		
		if (let >= 'A' && let <= 'F' && let != 'E')
		{
			System.out.print("The numeric value for grade " + let + " is ");
			switch(let)
			{
				case 'A': System.out.println(4); 
					break;
				case 'B': System.out.println(3); 
					break;
				case 'C': System.out.println(2); 
					break;
				case 'D': System.out.println(1); 
					break;
				case 'F': System.out.println(0); 
			}
		}
		
		else
			System.out.println(let + " is an invalid grade");
	}
	
	
}


