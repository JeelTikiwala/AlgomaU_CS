/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 3 Q1:The Fibonacci Sequence.
 * Any and All work in this file is my.
 **/

// Fibonacci Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, …….
// The formula for the Fibonacci sequence is: fib(n) = fib(n – 1) + fib(n – 2), fib(1) = 1 and fib(2) = 1

package COSCLab3;

import java.util.Scanner;

public class JtikiwalaQ1 {
	
    public static void main(String[] args) {
    	
        //take input from the user using scanner class
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number to calculate the Fibonacci number:");
        int fibNum = sc.nextInt();
        System.out.println("The Fibonacci number at position " + fibNum + " is: " + fib(fibNum));

    }
    
    // Defining a method to calculate the nth Fibonacci number using recursion
    public static int fib(int n){
    	
        // Base the cases for recursion; 0 and 1
        if (n==0 || n==1 ){
            return n;
        }
        // Recursively calling the fib method to calculate the nth Fibonacci number
            return fib(n - 1) + fib(n - 2);
    }
}
