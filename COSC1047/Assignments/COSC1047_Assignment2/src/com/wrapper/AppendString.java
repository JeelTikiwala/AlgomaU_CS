/* author @jtikiwala*/
package com.wrapper;

public class AppendString {

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("Hello World");

        // Append the additional string without creating a new object
        str.append("This is my String extending program");

        // Convert the StringBuilder back to a String
        String result = str.toString();

        // Print the final result
        System.out.println(result);
		

	}

}
