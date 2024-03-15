/**
Author: Johnny Console
Student ID: 239659420
Lab 2, Part 2
Any and all work in this file is my own.*/
package lab2;

public class Reversed {

    public static void reverse(int no) {
        // Check if the number is negative
        boolean isNegative = false;
        if (no  < 0) {
            isNegative = true;
            no = -no; // Make the number positive for reversal
        }

        int reversed = 0;
        while (no > 0) {
            int digit = no % 10;  // Extract the last digit
            reversed = reversed * 10 + digit;  // Append the digit in reverse order
            no /= 10;  // Remove the last digit
        }

        // If the input number was negative, add the negative sign to the reversed number
        if (isNegative) {
            System.out.println("The reversed number is: " + reversed + "-");
        } else { //if the input is positive, no sign to the reversed number
            System.out.println("The reversed number is: " + reversed);
        }
    }
}

