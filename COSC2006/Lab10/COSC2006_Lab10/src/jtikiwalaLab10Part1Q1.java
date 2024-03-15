/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 10 Part 1 Q1: Sequential Search
 * Any and All work in this file is my own.
 */

public class jtikiwalaLab10Part1Q1 {
    public static void main(String[] args) {
    	//given array
        int[] arr = {10, 20, 15, 25, 2, 8, 5, 32, 54, 9, 4, 6, 1, 55, 97, 45};

        // Sequential Search Result
        System.out.println("Sequential Search Result");
        System.out.println();
        
        Display(sequentialSearch(arr, 9));
        Display(sequentialSearch(arr, 900));
    }

    public static int sequentialSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; 
            }
        }
        return -1;
    }


    public static void Display(int index){
        if (index != -1) {
            System.out.println("The target was found at index: " + index);
        } else {
            System.out.println("The target was not found in the array");
        }
    }
}
