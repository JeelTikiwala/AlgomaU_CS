
/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment1*/
package com.computetax; //package for accessing the methods from ComputeTax

/**
 * @author jtikiwala
 *
 */
public class ComputeTaxTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) { //main method is necessary to run the program
		ComputeTax tax = new ComputeTax();
		
		tax.setIncome(170000);  // Set the income to 170000
		tax.setTax(0.2); //Set the tax,  but it's actually not used in calculations as we already defined tax in COmputeTax.java file
	}

}
