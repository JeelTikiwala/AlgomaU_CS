/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 1 Q2: Recursion: sum of array
 * Any and All work in this file is my own.
 */

// pseudocode:
//1. base case, check if there's only one element, return.
//2. Else, find sum of the array

public class jtikiwalaQ2 {

	//find sum of array where int a[] is array and int n is size
    public static int findSum(int a[], int n) {
        // base case
        if (n == 0) {
            return 0;
        }

        // recursive case
        return a[n - 1] + findSum(a, n - 1);
    }

    //main method
    public static void main(String[] args) {
    	//array has -ve element's as well
        int[] a = {9, 4, -9, 13, 7};
        int n = a.length;

        System.out.println("The sum of all elements in the array is: " + findSum(a, n));
    }
}
