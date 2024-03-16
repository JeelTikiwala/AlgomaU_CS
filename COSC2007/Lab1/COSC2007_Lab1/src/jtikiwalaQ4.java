/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 1 Q2: Recursion: linear search
 * Any and All work in this file is my own.
 */


public class jtikiwalaQ4 {

    public static boolean linearSearch(int a[], int target, int index) {
    	
        // base case
        if (index >= a.length) {
            return false;
        }

        // check element is equals to target
        if (a[index] == target) {
            return true;
        }

        // recursive case
        return linearSearch(a, target, index + 1);
    }

    public static void main(String[] args) {
        int[] a = {11, 2, 31, 24, 55, 6, 72, 8, 19, 10};
        int target = 14;

        
        boolean result = linearSearch(a, target, 0);

        if (result) {
            System.out.println("The target " + target + " found in the array.");
        } else {
            System.out.println("The target " + target + " is not found in the array.");
        }
    }
}
