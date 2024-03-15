/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 6 Q2: Single Linked list class
 * Any and All work in this file is my.
 **/
package lab6;

public class jtikiwalaLab6Q2 {
	
    //head node set to null
    protected jtikiwalaLab6Q1 head = null;

    //check if the list is empty or not.
    public boolean isEmpty() {
        return head == null;
    }
    
    //check the size of the list
    public int size() {
        int count = 0;
        jtikiwalaLab6Q1 current = head;
        //if current node is null
        while (current != null) {
            count++;
            //move to next node
            current = current.nextNode;
        }
        return count;
    }
    
    
    // add item in list at the given index
    public void add(String item, int i) throws ListException {
        if (i < 0 || i > size()) {
            throw new ListException("Invalid Index: IndexOutOfBound Exception");
        }
        if (i == 0) {
            head = new jtikiwalaLab6Q1(item);
        } else {
        	jtikiwalaLab6Q1 currentPtr = head;
            for (int j = 0; j < i - 1; j++) {
                currentPtr = currentPtr.nextNode;
            }

            currentPtr.nextNode = new jtikiwalaLab6Q1(item, currentPtr.nextNode);
        }

    }
    
    // remove an item from the list at certain index
    public String remove(int index) throws ListException {
        String removedItem;
        
        if (isEmpty()) {
            throw new ListException("Error: Empty List");
        }
        if (index < 0 || index >= size()) {
            throw new ListException("Error: Invalid Index: IndexOutOfBound Exception");
        }
        if (index == 0) {
            removedItem = head.item;
            head = head.nextNode;
        } else {
        	jtikiwalaLab6Q1 currentPtr = head;
            for (int j = 0; j < index - 1; j++) {
                currentPtr = currentPtr.nextNode;

            }
            removedItem = currentPtr.nextNode.item;
            currentPtr.nextNode = currentPtr.nextNode.nextNode;
        }
        return removedItem;
    }

    public void removeAll() {
        head = null;
    }


    
    public String get(int index) throws ListException {
        if (isEmpty()) {
            throw new ListException("Error: Empty List");
        }
        if (index < 0 || index >= size()) {
            throw new ListException("Error: Invalid Index: IndexOutOfBound Exception");
        } else {
        	jtikiwalaLab6Q1 currentPtr = head;
            for (int j = 0; j < index - 1; j++) {
                currentPtr = currentPtr.nextNode;

            }
            return currentPtr.item;
        }
    }

    public int find(String item) {
        int currentIndex = 0;

        jtikiwalaLab6Q1 currentPtr = head;

        while (currentPtr != null) {
            if (currentPtr.item.equals(item)) {
                return currentIndex;
            }
            currentIndex++;
            currentPtr = currentPtr.nextNode;

        }
        return -1;
    }
    
    public String toString() {
        StringBuilder build = new StringBuilder();
        jtikiwalaLab6Q1 currentPtr = head;
        while (currentPtr != null) {
        	build.append(currentPtr.item);
            if (currentPtr.nextNode != null) {
            	build.append(" -> ");
            }
            currentPtr = currentPtr.nextNode;
        }
        build.append(" -> null");
        return build.toString();
    }


}

// Custom Exception Class
class ListException extends Exception {
    private static final long serialVersionUID = 1L;

    public ListException(String message) {
        super(message);
    }
}

