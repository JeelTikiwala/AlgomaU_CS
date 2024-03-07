/* author @jtikiwala
 * 
 */
package com.wrapper;

/**
 * @author jtikiwala
 *
 */
public class Wrapping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10; // Wrapping the integer value 10 into an Integer object
		Integer aObj = new Integer(a);
		
		int b = 14; // Wrapping the integer value 14 into a Double object
		Double bObj = new Double(b);
		
		System.out.println("The Integer a is: " + aObj);
		System.out.println("The Decimal b is: " + bObj);
		
		// Converting the wrapped Integer value back to decimal using doubleValue() method
		System.out.println("The Integer to Decimal value is or Boxed Value: " + new Integer(a).doubleValue());
		
		// Converting the wrapped Double value back to integer using intValue() method
		System.out.println("The Decimal to Integer value is or Boxed Value: " + new Double(b).intValue());
		
		
		 

	}

}
