/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 10 Part 2 Q2: Merge Sort
 * Any and All work in this file is my own.
 */

import java.util.Arrays;

public class jtikiwalaLab10Part2Q2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 8, 9, 10, 15, 20, 25, 32, 45, 54, 55, 97};
        int[] descArray = Arrays.copyOf(arr, arr.length);

        // Merge Sorting Result
        System.out.println("Merge Sorting Result:");
        System.out.println();
        System.out.println("Array before sorting in ascending order: " + Arrays.toString(arr));
        mergeSort(descArray, 0, descArray.length - 1);
        System.out.println("Array after sorting in descending order: " + Arrays.toString(descArray));
    }

    public static void mergeSort(int[] arr, int start, int end){
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        mergeHalves(arr, start, mid, end);
    }

    public static void mergeHalves(int[] arr, int start, int mid, int end){
        int[] temp = new int[arr.length];
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid && right <= end) {
            if (temp[left] >= temp[right]) {
                arr[index] = temp[left];
                left++;
            } else {
                arr[index] = temp[right];
                right++;
            }
            index++;
        }

        while (left <= mid) {
            arr[index] = temp[left];
            left++;
            index++;
        }
    }
}
