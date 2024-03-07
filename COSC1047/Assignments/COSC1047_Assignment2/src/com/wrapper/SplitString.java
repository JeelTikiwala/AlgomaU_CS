/* author @jtikiwala*/
package com.wrapper;

public class SplitString {

	public static void main(String[] args) {
		String str = "The Founder of:Ethereum is; Vitalik"; // Input string with delimiters ":" and ";"
		String[] arrOfStr = str.split("[:;]"); // splitting the string based on delimiters ":" and ";"
		
		for(String s:arrOfStr) //itearion through for loop
			System.out.println(s); //output

	}

}
