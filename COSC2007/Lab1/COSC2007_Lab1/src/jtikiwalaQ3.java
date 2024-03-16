/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 1 Q2: Recursion: ispalindrome
 * Any and All work in this file is my own.
 */
public class jtikiwalaQ3 {

	//find ispalindrome where int a[] is array and int n is size
    public static int isPalindrome(char a[], int n) {
    	
        // base case: if the array has 1 or 0 element, it's palindrome
        if (n <= 1) {
            return 1;
        }

        // case 1: check if the first and last elements are equal
        if (a[0] != a[n - 1]) {
            return 0; // Not a palindrome
        }

        // recursive case: check the remaining array except the first and last elements 
        //because we already did that in case 1
        
        //(a, 1, n - 1) creates new array from starting from 2nd element upto 2nd last element
        return isPalindrome(java.util.Arrays.copyOfRange(a, 1, n - 1), n - 2);
    }

    //main method
    public static void main(String[] args) {
        char[] a = {'r', 'a', 'c', 'e', 'c', 'a', 'r'}; //racecar is a palindrome
        int n = a.length;

        int result = isPalindrome(a, n);

        //converted char to string
        if (result == 1) {
            System.out.println("The given array " + String.valueOf(a) + " is a palindrome.");
        } else {
            System.out.println("The given array " + String.valueOf(a) +" is not a palindrome.");
        }
    }
}
