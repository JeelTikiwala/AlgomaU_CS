/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment1*/
package com.salestax; //package for salestax to retrive data from SalesTax

import java.util.*; //library import

public class SalesTaxTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //scanner object for input
		System.out.println("Enter the purchase amount of the goods: ");
		
		double purchaseAmount = sc.nextDouble(); //enter the amount from the user
		SalesTax st = new SalesTax(purchaseAmount); //instance of salestax with paramenter purchaseamount
		
		System.out.println("The Sales tax of the purchased good is: $" + st.getSalesTax()); //display the output
		sc.close(); //end of [program or close the scanner, it's not necessary

	}

}
