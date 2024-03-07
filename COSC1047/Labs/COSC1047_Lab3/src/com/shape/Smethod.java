/* author @jtikiwala
 * 
 */
package com.shape;

/**
 * @author jtikiwala
 *
 */
public class Smethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		shape ct = new Circle(); 
		shape tr = new Triangle();
		shape sq = new Square();
		
		ct.draw(); // drawing the circle
		ct.erase(); // erasing the circle
		
		System.out.println(); //to add space b/w 
		
		tr.draw(); // drawing the triangle
		tr.erase(); // erasing the triangle
		
		System.out.println(); //to add space b/w 
		
		sq.draw(); // drawing the square
		sq.erase(); // erasing the square
		

	}

}
