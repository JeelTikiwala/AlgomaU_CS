/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 10 Part 1 Q2: Bubble Sorting
 * Any and All work in this file is my own.
 */

import java.util.Arrays;

public class jtikiwalaLab10Part1Q2 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 25, 2, 8, 5, 32, 54, 9, 4, 6, 1, 55, 97, 45};

        // Bubble Sorting Result
        System.out.println("Bubble Sorting Result");
        System.out.println();
        System.out.println("Original array - before sorting: : " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted array - Array after sorting: " + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
