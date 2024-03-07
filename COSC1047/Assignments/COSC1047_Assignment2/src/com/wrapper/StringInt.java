/* author @jtikiwala
 * 
 */

package com.wrapper;

/**
 * @author jtikiwala
 *
 */
public class StringInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int a = Integer.parseInt("1", 2); //declaring variablesd
		int b = Integer.parseInt("5", 8); //declaring variables
		int c = Integer.parseInt("15", 10); //declaring variablesd
		int d = Integer.parseInt("0111", 16); //declaring variablesd
		
		System.out.println("Integer value of String integer 1 with radix 2" + a);  // Parsing string "1" as a binary number
		System.out.println("Integer value of String integer 5 with radix 8" +b); // Parsing string "5" as an octal number
		System.out.println("Integer value of String integer 11 with radix 10 is" + c); // Parsing string "15" as a decimal number
		System.out.println("Integer value of String integer 11 with radix 10 is" + d); // Parsing string "0111" as a hexadecimal number

	}

}

