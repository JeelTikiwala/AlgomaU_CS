/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 5 Q1: ADTList Class
 * Any and All work in this file is my.
 **/
package lab5;

public class jtikiwalaLab5Q1 {
    private String[] items;
    private int size;


    // COnstructor, throws a ListException if the size is less than zero.
    public jtikiwalaLab5Q1(int size) throws ListException {
        if (size < 0) {
            throw new ListException("Invalid size entered!");
        }
        items = new String[size];
        this.size = 0;
    }
    
    // This method checks if the list is empty and returns(boolean)true or false.
    public boolean isEmpty() {
        return size == 0;
    }
    // returns the size of the list.
    public int size() {
        return size;
    }

    // A method that adds an item to the list at the specified index.
    // Throws a ListException if the index is invalid or if the list is full.
    public void add(String item, int i) throws ListException {
        if (i < 0 || i > size) {
            throw new ListException("Invalid index. Unable to add the item.");
        }
        if (size == items.length) {
            throw new ListException("List is full. Unable to add the item");
        }

        for (int j = size - 1; j >= i; j--) {
            items[j] = items[j - 1];
        }
        items[i] = item;
        size++;

    }

    //method add an item, throws exception. returns the item that was removed.
    public String remove(int i) throws ListException {
        if (i < 0 || i >= size) {
            throw new ListException("Invalid index. Unable to remove the item.");
        }

        String removedItem = items[i];
        String[] anotherArray = new String[items.length];
        for (int j = 0, k = 0; j < items.length; j++) {


            if (j == i) {
                continue;
            }
            anotherArray[k++] = items[j];
        }
        items = anotherArray;
        size--;
        return removedItem;
    }
    

    // clears the list,set all values to null and the size to 0.
    public void removeAll() {
        for (int i = 0; i < size; i++) {
        	items[i] = null;
        }
        System.out.println("List has been cleared!");
        size = 0;
    }
    

    // method returns the item at specific index, throws a ListException if the index is invalid.
    public String get(int i) throws ListException {
        if (i < 0 || i >= size) {
            throw new ListException("Invalid index provided.");
        }
        return items[i];
    }

    
    public int find(String item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    
    //display method to converting the list to a string.
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(items[i]);
            if (i != size - 1) {
                builder.append(", ");
            }

        }
        return builder.toString();
    }

}

    class ListException extends Exception {
    private static final long serialVersionUID = 1L;

    public ListException(String s) {
        super(s);
    }
}

