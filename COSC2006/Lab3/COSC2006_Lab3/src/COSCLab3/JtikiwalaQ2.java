/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 3 Q2:The Fibonacci Sequence.
 * Any and All work in this file is my.
 **/

package COSCLab3;

import java.util.Scanner;

public class JtikiwalaQ2 {
    public static void main(String[] args) {
    	
    	//take input from the user
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of rows for the star pattern: ");
        int num = sc.nextInt(); //read int from user
        System.out.println("The Upward star Pattern:");
        printUp(num);
        System.out.println("\nThe Downward star pattern: ");
        printDown(num);


    }
    // Defining a method to print the upward star pattern
    public static void printUp(int n){
    	// Base case: if n is <= 0, return
        if(n==0 || n<0)
            return;
        
        // Recursively call the function with n-1 to print the pattern
        printUp(n-1);
        for (int i = 0; i < n; i++) {
            // Printing the stars for the current row
            System.out.print("* ");

        }
        // Moving to the next line
        System.out.println();

    }
    // Defining a method to print the downward star pattern
    public static void printDown(int n){
    	// Base case: if n is <= 0, return
        if(n==0 || n<0)
            return;
        for (int i = 0; i < n; i++) {
            // Printing the stars for the current row
            System.out.print("* ");

        }
        // Moving to the next line
        System.out.println();
        // Recursively calling the printDown method
        printDown(n-1);

    }
}
