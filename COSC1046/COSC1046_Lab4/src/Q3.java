import java.util.*;
public class Q3 {

	public static void main(String[] args) {

		int unitution = 10000; //it increases every 5 years
		int cost = 0;
		
		for (int i = 1; i <= 10; i++) {  //use for loop to iterate through all 1-10 year

			unitution += unitution * .05; //increases 5% every 5 years

	        if (i == 10) {
	            cost = cost + unitution; //increase the cost
	        }

	    }

	    System.out.println("The total cost of 4 years tuition in 10 years is $" // print the output
	            + cost);
	}

}
