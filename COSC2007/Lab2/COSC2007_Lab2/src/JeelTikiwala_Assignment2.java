/**
Name: Jeel Tikiwala
Student ID: 239659420
Lab 2
Any and all work in this file is my own.*/

import java.util.*;

public class JeelTikiwala_Assignment2 {

	//main class
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		//A: get the size of an array
		System.out.println("Enter the size of an array :");
		int n = sc.nextInt();
		
		//array of integrs with size n to store elements entered by the user
		int arr[] = new int[n];
		
		//B: get the element from the user
		System.out.println("Enter the element of the array :");
		//loop go read n elements and store that in the array arr[i]
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//C: check the numbers
		System.out.println("Check the numbers of the array :");
		int target = sc.nextInt();
		
		//D: find all quadruplets with sum <= given number
		Arrays.sort(arr);
		findQuadruplets(arr, target, 0, new int[4], 0);
	}
	
	public static void findQuadruplets(int arr[], int target, int startidx, int selected[], int count) {
		//base case: if 4 is selected, check if sum <= target
		if(count == 4) {
			int sum = 0;
			
			for(int num : selected) {
				sum += num;
			}
			
			//if true, print the quadruplets
			if(sum <= target) {
				System.out.println(Arrays.toString(selected));
			}
			
			//if false, return
			return;
			
			
		}
		
		//otherwise, continue the recursion
		for (int i = startidx; i< arr.length; i++) {
			selected[count] = arr[i]; //select the current element and add it to the array
			findQuadruplets(arr, target, i + 1, selected, count + 1); //find next element
		}
	}
}
