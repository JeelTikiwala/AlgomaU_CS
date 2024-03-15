package Ass4;
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Ass4: Main Infix Calculator
 * Any and All work in this file is my.
 **/
import java.util.Scanner;

public class CalculatorMain {

	//psvm
	public static void main(String[] args) {
		//scanner class
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String i = sc.nextLine();

        Calculator cal = new Calculator(i);

        try {
            String postfix = cal.getPostFix();
            System.out.println("The postfix expression is: " + postfix);
            int result = cal.evaluate();
            System.out.println("Result after evaluating the postfix expression: " + result);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
