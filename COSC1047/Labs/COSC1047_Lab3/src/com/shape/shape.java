/* author @jtikiwala
 * 
 */
package com.shape; //importing package
/**
 * @author jtikiwala
 *
 */
public class shape {
	void draw() {
		System.out.println("Drawing the shape");
	}
	
	void erase() {
		System.out.println("Erasing the shape");
	}
	
}

class Circle extends shape {
	void draw() {
		System.out.println("Drawing the shape: Circle.");
	}
	
	void erase() {
		System.out.println("Erasing the shape: Circle.");
	}
}

class Triangle extends shape {
	void draw() {
		System.out.println("Drawing the shape: Triangle.");
	}
	
	void erase() {
		System.out.println("Erasing the shape: Triangle.");
	}
}

class Square extends shape {
	void draw() {
		System.out.println("Drawing the shape: Square.");
	}
	
	void erase() {
		System.out.println("Erasing the shape: Square.");
	}
}
