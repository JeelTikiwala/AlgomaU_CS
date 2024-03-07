/* author @jtikiwala
 * 
 */
package com.library;

/**
 * @author jtikiwala
 *
 */
public abstract class LibraryItem {
	 protected String title; //variable to store title
	 protected int year; //variable to store yeaqr

	 public LibraryItem(String title, int year) {
	        this.title = title;
	        this.year = year;
	    }

public abstract void displayItemInfo();

}

class Book extends LibraryItem {
    private String author; //variable to store author

    public Book(String title, int year, String author) {
        super(title, year);
        this.author = author;
    }

    public void displayItemInfo() {
        System.out.println("The Book is:");
        System.out.println("The Title is: " + title);
        System.out.println("The Author is: " + author);
        System.out.println("The Year is: " + year);
        System.out.println();
    }
}

class Magazine extends LibraryItem {
    private int issueNumber; ////variable to store issueNumber

    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        this.issueNumber = issueNumber;
    }

    public void displayItemInfo() {
        System.out.println("The Magazine is:");
        System.out.println("The Title is: " + title);
        System.out.println("The Issue Number is: " + issueNumber);
        System.out.println("The Year is: " + year);
        System.out.println();
    }
}