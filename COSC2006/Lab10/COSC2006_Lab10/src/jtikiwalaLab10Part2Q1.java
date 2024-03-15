/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 10 Part 2 Q1: Binary Search
 * Any and All work in this file is my own.
 */

import java.util.Arrays;

public class jtikiwalaLab10Part2Q1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 8, 9, 10, 15, 20, 25, 32, 45, 54, 55, 97};

        // Binary Search Result
        System.out.println("Binary Search Result:");
        System.out.println();
        Display(binarySearch(arr, 97, 0, arr.length-1));
    }

    public static int binarySearch(int[] arr, int target, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return binarySearch(arr, target, mid + 1, high);
            } else {
                return binarySearch(arr, target, low, mid - 1);
            }
        }
        return -1;
    }

    public static void Display(int index){
        if (index != -1) {
            System.out.println("Target found at index " + index);
        } else {
            System.out.println("Target not found in the array");
        }
    }
}
