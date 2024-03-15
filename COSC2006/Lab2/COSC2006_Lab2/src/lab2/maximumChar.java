/**
Author: Johnny Console
Student ID: 239659420
Lab 2, Part 1
Any and all work in this file is my own.*/
package lab2;

public class maximumChar {

	// This method finds and returns the character with the highest ASCII value in a string.
    public static char maximumChar(String str) {
        if (str == null || str.isEmpty()) {
        	
            // If the input string is empty or null, return null character
            return '\0';
        }

     // Extract the first character of the input string
        char firstChar = str.charAt(0);
        
     // This will find the maximum character in the rest of the string.
        char maxInRest = maximumChar(str.substring(1));
        
     // If the first character has a higher ASCII value, return it; otherwise, return the maximum character.
     // Compare the first character with the maximum character in the rest of the string.
     // Ternary Operator, if-else
        return firstChar > maxInRest ? firstChar : maxInRest;
    }
}
