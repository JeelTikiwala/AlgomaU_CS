/* author @jtikiwala
 * 
 */
package com.library;

/**
 * @author jtikiwala
 *
 */
public class Lmethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LibraryItem[] items = new LibraryItem[3];
        items[0] = new Book("Harry Potter and the Sorcerer's Stone", 1997, "J. K. Rowling"); //book 
        items[1] = new Magazine("The Vampire Diaries", 1991, 2); //magazine
        items[2] = new Book("Jurassic Park", 1990, "Michael Crichton"); //book

        for (LibraryItem item : items) {
            item.displayItemInfo();
        }

	}

}
