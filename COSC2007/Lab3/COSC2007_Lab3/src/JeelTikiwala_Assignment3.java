/**
Name: Jeel Tikiwala
Student ID: 239659420
Lab 3
Any and all work in this file is my own.*/
public class JeelTikiwala_Assignment3 {
	//time complexity = nlogn
	
	//to merge array from 2 halves
	public static void conquer(int arr[], int si, int mid, int ei) {
		int merge[] = new int[ei - si +1];
		
		int index1 = si;
		int index2 = mid + 1;
		int x = 0;
		
		// Merge the two halves into the temporary array
		while(index1 <= mid && index2 <= ei) {
			if(arr[index1] <= arr[index2]) {
				merge[x] = arr[index1];
				x++;
				index1++;
			}
			else {
				merge[x++] = arr[index2++];
			}
		}
		
		// Copy remaining elements from the first half, if any
		while(index1 <= mid) {
			merge[x++] = arr[index1++];
		}
		
		// Copy remaining elements from the second half, if any
		while(index2 <= ei) {
			merge[x++] = arr[index2++];
		}
		
		// Copy the merged elements back to the original array
		for(int i=0, j=si; i<merge.length; i++, j++) {
			arr[j] = merge[i];
		}
	}
	
	//divide array in 2 half: divide and conquer method
	public static void divide(int arr[], int si, int ei) {
		
		if(si >= ei) {
			return;
		}
		//to find mid of the array
		int mid = si + (ei- si)/2;
		divide(arr, si, mid);
		divide(arr, mid+1, ei);
		
		//merge the sorted array
		conquer(arr, si, mid, ei);
	}
	
	public static void main(String[] args) {
		int arr[] = {1,7,4,2};
		int n = arr.length;
		
		divide(arr, 0, n-1);
		
		//to print the array
		for (int i = 0; i < n; i++) {
	        if (i < n - 1) {
	            System.out.print(arr[i] + " -> ");
	        } else {
	            System.out.print(arr[i] + " -> NULL");
	        }
		}

	}
}
