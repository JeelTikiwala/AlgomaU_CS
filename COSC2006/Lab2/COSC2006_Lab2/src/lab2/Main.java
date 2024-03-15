/**
Author: Johnny Console
Student ID: 239659420
Lab 2, Part 3
Any and all work in this file is my own.*/
package lab2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       // used scanner to ask input from user
        System.out.println("Choose what do you want to do?");
        System.out.println(); //extra line
        System.out.println("Enter 1 to get find ASCII value within the string:");
        System.out.println("Enter 2 to reverse the number:");
        System.out.println(); //extra line
        System.out.print("Enter 1 or 2: ");
        int sw = sc.nextInt();
        sc.nextLine(); 

        //use switch method to print both q1 and q2 in main
        switch (sw) {
            case 1:
                // to get highest ASCII character
                System.out.println("Enter a string to get the string's highest ASCII value: ");
                //take input from user
                String inputString = sc.nextLine();
                char maxChar = maximumChar.maximumChar(inputString);
                System.out.println("Character with the highest ASCII value is: " + maxChar);
                
                break;
            case 2:
                // reverse the number: add -ve at the end if the number is negative
                System.out.println("Enter an number to reverse it: ");
                int no = sc.nextInt();
                Reversed.reverse(no);
                break;
                
            default:
                System.out.println("The option is invalid. The only options you have is 1: Highest ASCII value and 2. To reverse the string.");
                break;
        }

    }
}
