/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 1 Q1: Recursion: Minimum element of array
 * Any and All work in this file is my own.
 */


// pseudocode:
//1. base case, check if there's only one element, return.
//2. Else, find minimum from the array.

public class jtikiwalaQ1 {

	//find minimum of array where int a[] is array and int n is size
    public static int findMin(int a[], int n) {
    	
        // base case
        if (n == 1) {
            return a[0]; //return one and only element
        }
        
        //recursive case
        return Math.min(a[n-1], findMin(a, n-1));
    }

    //main method
    public static void main(String[] args) {
        
        int[] a = {3, 9, -7, 4, 3};
        int n = a.length;

        System.out.println("The minimum element of the given array is: " + findMin(a, n));
    }
}
